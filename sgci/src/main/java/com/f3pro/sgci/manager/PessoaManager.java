package com.f3pro.sgci.manager;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.repositories.PessoaRespository;
import com.f3pro.sgci.schema.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<PessoaResponse> findAll() {
        List<PessoaResponse> listResponse = new ArrayList<PessoaResponse>();

        List<Pessoa> listPessoaDB = pessoaRespository.findAll();
        listPessoaDB.forEach(item -> {
            EnderecoResponse enderecoResponse = EnderecoMapper.INSTANCE.toEnderecoResponse(item.getEndereco());
            PessoaResponse pessoaResponse = PessoaMapper.INSTANCE.toPessoaResponse(item, enderecoResponse);

            listResponse.add(pessoaResponse);


        });

        return listResponse;
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