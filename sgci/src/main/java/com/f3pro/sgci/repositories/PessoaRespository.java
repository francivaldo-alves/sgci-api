package com.f3pro.sgci.repositories;

import com.f3pro.sgci.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRespository extends JpaRepository<Pessoa, Long> {
    Pessoa findPessoaByNome(String nome);
}
