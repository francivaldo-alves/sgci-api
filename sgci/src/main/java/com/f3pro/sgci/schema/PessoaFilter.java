package com.f3pro.sgci.schema;

import com.f3pro.sgci.model.TipoPessoaEnum;
import lombok.Getter;
import lombok.Setter;

public class PessoaFilter extends FilterPageable {

    private String nome;
    private String cep;
    private String estado;
    private String cidade;
    private EnderecoReq endereco;
    private TipoPessoaEnum tipo;
    private String documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public EnderecoReq getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoReq endereco) {
        this.endereco = endereco;
    }

    public TipoPessoaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoaEnum tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
