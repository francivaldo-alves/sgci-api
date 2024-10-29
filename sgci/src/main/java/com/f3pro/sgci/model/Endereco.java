package com.f3pro.sgci.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Size(max = 8)
    @Column(name = "CEP")
    private String cep;

    @NotNull
    @Size(max = 255)
    @Column(name = "ESTADO")
    private String estado;

    @NotNull
    @Size(max = 255)
    @Column(name = "CIDADE")
    private String cidade;

    @Size(max = 255)
    @Column(name = "RUA")
    private String rua;

    @Size(max = 255)
    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "NUMERO")
    private Integer numero;

    public Endereco() {}

    public Endereco(String cep, String estado, String cidade, String rua, String bairro, Integer numero) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(max = 8) String getCep() {
        return cep;
    }

    public void setCep(@Size(max = 8) String cep) {
        this.cep = cep;
    }

    public @Size(max = 255) String getEstado() {
        return estado;
    }

    public void setEstado(@Size(max = 255) String estado) {
        this.estado = estado;
    }

    public @Size(max = 255) String getCidade() {
        return cidade;
    }

    public void setCidade(@Size(max = 255) String cidade) {
        this.cidade = cidade;
    }

    public @Size(max = 255) String getRua() {
        return rua;
    }

    public void setRua(@Size(max = 255) String rua) {
        this.rua = rua;
    }

    public @Size(max = 255) String getBairro() {
        return bairro;
    }

    public void setBairro(@Size(max = 255) String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}

