package com.f3pro.sgci.manager;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.repositories.PessoaRespository;
import com.f3pro.sgci.schema.*;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Service
@Validated
public class PessoaManager {
    @Autowired
    private PessoaRespository pessoaRespository;

    @Transactional
    public Pessoa createPessoa(PessoaReq req) {
        Endereco endereco = new Endereco(req.endereco().cep(), req.endereco().estado(), req.endereco().cidade(),
                req.endereco().rua(), req.endereco().bairro(), req.endereco().numero());
        Pessoa pessoa = new Pessoa(endereco, req.nome(), req.tipo(), req.documento(), req.profissao(),
                req.estadoCivil());
        return pessoaRespository.save(pessoa);
    }

    @Transactional
    public void deletePessoa(Long idPessoa) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa).orElseThrow();
        pessoaRespository.delete(pessoa);
    }

    public ResponsePagedCommom<PessoaResponse> findAll(@Valid PessoaFilter filtros) {
        List<PessoaResponse> listResponse = new ArrayList<PessoaResponse>();

        Specification<Pessoa> filtrosCustomizados = (root, query, cb) -> {
            List<Predicate> condicoes = new ArrayList<>();
            if (filtros.getNome() != null) {
                condicoes.add(cb.like(root.get("nome"), "%" + filtros.getNome() + "%"));
            }
            if (filtros.getCep() != null) {
                condicoes.add(cb.equal(root.get("endereco").get("cep"), filtros.getCep()));
            }
            if (filtros.getEstado() != null) {
                condicoes.add(cb.equal(root.get("endereco").get("estado"), filtros.getEstado()));
            }
            if (filtros.getCidade() != null) {
                condicoes.add(cb.equal(root.get("endereco").get("cidade"), filtros.getCidade()));
            }
            if (filtros.getTipo() != null) {
                condicoes.add(cb.equal(root.get("tipo"), filtros.getTipo()));
            }
            if (filtros.getDocumento() != null) {
                condicoes.add(cb.equal(root.get("documento"), filtros.getDocumento()));
            }

            return cb.and(condicoes.toArray(Predicate[]::new));
        };

        Page<Pessoa> listPessoaDB = pessoaRespository.findAll(filtrosCustomizados, PageRequest.of(filtros.getPage(), filtros.getSize(), Sort.by(filtros.getDirection(), filtros.getOrdenarPo())));
        listPessoaDB.forEach(item -> {
            EnderecoResponse enderecoResponse = EnderecoMapper.INSTANCE.toEnderecoResponse(item.getEndereco());
            PessoaResponse pessoaResponse = PessoaMapper.INSTANCE.toPessoaResponse(item, enderecoResponse);

            listResponse.add(pessoaResponse);


        });

        return new ResponsePagedCommom<PessoaResponse>(listResponse, listPessoaDB.getTotalElements(), listPessoaDB.getTotalPages(), filtros.getSize());
    }


    @Transactional
    public Pessoa updatePessoa(@Valid Long idPessoa, PessoaUpd upd) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa).orElseThrow();
        pessoa.setDocumento(upd.documento());
        pessoa.setEstadoCivil(upd.estadoCivil());
        pessoa.setNome(upd.nome());
        pessoa.setProfissao(upd.profissao());
        pessoa.setTipo(upd.tipo());

        pessoa.getEndereco().setCep(upd.endereco().cep());
        pessoa.getEndereco().setEstado(upd.endereco().estado());
        pessoa.getEndereco().setCidade(upd.endereco().estado());
        pessoa.getEndereco().setRua(upd.endereco().rua());
        pessoa.getEndereco().setBairro(upd.endereco().bairro());
        pessoa.getEndereco().setNumero(upd.endereco().numero());
        return pessoaRespository.save(pessoa);
    }

    public PessoaResponse findById(Long idPessoa) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa).orElseThrow();
        EnderecoResponse enderecoResponse = EnderecoMapper.INSTANCE.toEnderecoResponse(pessoa.getEndereco());
        return PessoaMapper.INSTANCE.toPessoaResponse(pessoa, enderecoResponse);


    }
}