package com.f3pro.sgci.manager;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.repositories.PessoaRespository;
import com.f3pro.sgci.schema.PessoaReq;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
}