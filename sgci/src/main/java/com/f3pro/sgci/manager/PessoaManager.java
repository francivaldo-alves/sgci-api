package com.f3pro.sgci.manager;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.repositories.PessoaRespository;
import com.f3pro.sgci.schema.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class PessoaManager {

    @Autowired
    private PessoaRespository pessoaRespository;

    @Transactional
    public Pessoa createPessoa(PessoaReq req) {
        Endereco endereco = criarEndereco(req.getEndereco());
        Pessoa pessoa = new Pessoa(endereco, req.getNome(), req.getTipo(), req.getDocumento(), req.getProfissao(), req.getEstadoCivil());
        return pessoaRespository.save(pessoa);
    }

    @Transactional
    public void deletePessoa(Long idPessoa) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + idPessoa));
        pessoaRespository.delete(pessoa);
    }

    public ResponsePagedCommom<PessoaResponse> findAll(@Valid PessoaFilter filtros) {
        Specification<Pessoa> filtrosCustomizados = criarEspecificacao(filtros);
        Page<Pessoa> listPessoaDB = pessoaRespository.findAll(filtrosCustomizados,
                PageRequest.of(filtros.getPage(), filtros.getSize(), Sort.by(filtros.getDirection(), filtros.getOrdenarPo())));

        List<PessoaResponse> listResponse = listPessoaDB.stream()
                .map(this::converterParaPessoaResponse)
                .collect(Collectors.toList());

        return new ResponsePagedCommom<>(listResponse, listPessoaDB.getTotalElements(), listPessoaDB.getTotalPages(), filtros.getSize());
    }

    @Transactional
    public Pessoa updatePessoa(@Valid Long idPessoa, PessoaUpd upd) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + idPessoa));

        pessoa.setDocumento(upd.documento());
        pessoa.setEstadoCivil(upd.estadoCivil());
        pessoa.setNome(upd.nome());
        pessoa.setProfissao(upd.profissao());
        pessoa.setTipo(upd.tipo());

        atualizarEndereco(pessoa.getEndereco(), upd.endereco());

        return pessoaRespository.save(pessoa);
    }

    public PessoaResponse findById(Long idPessoa) {
        Pessoa pessoa = pessoaRespository.findById(idPessoa)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + idPessoa));

        return converterParaPessoaResponse(pessoa);
    }

    // Métodos Auxiliares

    private Specification<Pessoa> criarEspecificacao(PessoaFilter filtros) {
        return (root, query, cb) -> {
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
            return cb.and(condicoes.toArray(new Predicate[0]));
        };
    }

    private Endereco criarEndereco(EnderecoReq enderecoReq) {
        return new Endereco(
                enderecoReq.cep(), enderecoReq.estado(), enderecoReq.cidade(),
                enderecoReq.rua(), enderecoReq.bairro(), enderecoReq.numero()
        );
    }

    private void atualizarEndereco(Endereco endereco, @NotNull EnderecoReq enderecoUpd) {
        endereco.setCep(enderecoUpd.cep());
        endereco.setEstado(enderecoUpd.estado());
        endereco.setCidade(enderecoUpd.cidade());
        endereco.setRua(enderecoUpd.rua());
        endereco.setBairro(enderecoUpd.bairro());
        endereco.setNumero(enderecoUpd.numero());
    }

    private PessoaResponse converterParaPessoaResponse(Pessoa pessoa) {
        EnderecoResponse enderecoResponse = EnderecoMapper.INSTANCE.toEnderecoResponse(pessoa.getEndereco());
        return PessoaMapper.INSTANCE.toPessoaResponse(pessoa, enderecoResponse);
    }
}
