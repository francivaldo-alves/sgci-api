package com.f3pro.sgci.manager;

import com.f3pro.sgci.factory.EnderecoFactory;
import com.f3pro.sgci.factory.PessoaFactory;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.schema.EnderecoReq;
import com.f3pro.sgci.schema.PessoaReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
public class TestPessoaManager {


    @Test
    void contextLoads() {
    }


    @Autowired
    private PessoaManager pessoaManager;

    @Test
    void Create_Pessoa(){
        EnderecoReq enderecoReq = EnderecoFactory.getEnderecoReq();
        PessoaReq req = PessoaFactory.getPessoaReq(enderecoReq);
        Pessoa pessoa = pessoaManager.createPessoa(req);
         assertTrue(pessoa != null && pessoa.getId() > 0);


    }
    //createPesoa

    //findById

    //findAllPaged

    //deletePessoa
}
