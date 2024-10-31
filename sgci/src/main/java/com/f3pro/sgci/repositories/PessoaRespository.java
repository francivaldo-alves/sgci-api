package com.f3pro.sgci.repositories;

import com.f3pro.sgci.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRespository extends JpaRepository<Pessoa, Long> {
    Pessoa findPessoaByNome(String nome);

    Page<Pessoa> findAll(Specification<Pessoa> filtrosCustomizados, Pageable pageable);
}
