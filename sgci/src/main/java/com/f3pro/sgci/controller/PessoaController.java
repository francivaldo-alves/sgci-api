package com.f3pro.sgci.controller;


import com.f3pro.sgci.manager.PessoaManager;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.schema.PessoaReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
   private PessoaManager pessoaManager;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody PessoaReq req){
      Pessoa pessoa = pessoaManager.createPessoa(req);
      return ResponseEntity.ok(pessoa);

    }
    @DeleteMapping("{idPessoa}")
    public ResponseEntity<Long> deletePessoa(@PathVariable Long idPessoa){
        pessoaManager.deletePessoa(idPessoa);
        return ResponseEntity.ok().build();

    }

}
