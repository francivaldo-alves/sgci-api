package com.f3pro.sgci.controller;


import com.f3pro.sgci.manager.PessoaManager;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.schema.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pessoa")
@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaManager pessoaManager;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody PessoaReq req) {
        Pessoa pessoa = pessoaManager.createPessoa(req);
        return ResponseEntity.ok(pessoa);

    }

    @PutMapping("{idPessoa}")
    public ResponseEntity<Pessoa> updatePessoa(
            @Valid
            @PathVariable (required = true)Long idPessoa,
            @RequestBody PessoaUpd upd) {
        Pessoa pessoa = pessoaManager.updatePessoa(idPessoa, upd);
        return ResponseEntity.ok(pessoa);

    }

    @GetMapping
    public ResponseEntity<ResponsePagedCommom<PessoaResponse>> findAll(@Valid PessoaFilter filtros ) {
        return ResponseEntity.ok(pessoaManager.findAll(filtros));
    }
    @GetMapping("{idPessoa}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable (required = true) Long idPessoa){
        return ResponseEntity.ok(pessoaManager.findById(idPessoa));

    }

    @DeleteMapping("{idPessoa}")
    public ResponseEntity<Long> deletePessoa(@PathVariable Long idPessoa) {
        pessoaManager.deletePessoa(idPessoa);
        return ResponseEntity.ok().build();

    }

}
