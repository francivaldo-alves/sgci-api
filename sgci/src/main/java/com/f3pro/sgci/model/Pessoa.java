package com.f3pro.sgci.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    @NotNull
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "EN_TIPO")
    private TipoPessoaEnum tipo;

    @NotNull
    @Size(max = 255)
    @Column(name = "DOCUMENTO", unique = true)
    private String documento;

    @NotNull
    @Size(max = 255)
    @Column(name = "TX_PROFISSAO")
    private String profissao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "EN_ESTADO_CIVIL")
    private EstadoCivilEnum estadoCivil;


    public  Pessoa(){}

    public Pessoa(Endereco endereco, String nome, TipoPessoaEnum tipo, String documento, String profissao, EstadoCivilEnum estadoCivil) {
        this.endereco = endereco;
        this.nome = nome;
        this.tipo = tipo;
        this.documento = documento;
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull Endereco endereco) {
        this.endereco = endereco;
    }

    public @NotNull @Size(max = 255) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Size(max = 255) String nome) {
        this.nome = nome;
    }

    public @NotNull TipoPessoaEnum getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull TipoPessoaEnum tipo) {
        this.tipo = tipo;
    }

    public @NotNull @Size(max = 255) String getDocumento() {
        return documento;
    }

    public void setDocumento(@NotNull @Size(max = 255) String documento) {
        this.documento = documento;
    }

    public @NotNull @Size(max = 255) String getProfissao() {
        return profissao;
    }

    public void setProfissao(@NotNull @Size(max = 255) String profissao) {
        this.profissao = profissao;
    }

    public @NotNull EstadoCivilEnum getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(@NotNull EstadoCivilEnum estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
