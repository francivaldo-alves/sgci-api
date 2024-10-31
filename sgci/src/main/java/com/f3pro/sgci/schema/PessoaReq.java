package com.f3pro.sgci.schema;

import com.f3pro.sgci.model.EstadoCivilEnum;
import com.f3pro.sgci.model.TipoPessoaEnum;
import jakarta.validation.constraints.NotNull;

public class PessoaReq {

        @NotNull
        private String nome;

        @NotNull
        private EnderecoReq endereco;

        @NotNull
        private TipoPessoaEnum tipo;

        @NotNull
        private String documento;

        @NotNull
        private String profissao;

        @NotNull
        private EstadoCivilEnum estadoCivil;

        // Construtor
        public PessoaReq(String nome, EnderecoReq endereco, TipoPessoaEnum tipo, String documento, String profissao, EstadoCivilEnum estadoCivil) {
                this.nome = nome;
                this.endereco = endereco;
                this.tipo = tipo;
                this.documento = documento;
                this.profissao = profissao;
                this.estadoCivil = estadoCivil;
        }

        // Getters e Setters
        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
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

        public String getProfissao() {
                return profissao;
        }

        public void setProfissao(String profissao) {
                this.profissao = profissao;
        }

        public EstadoCivilEnum getEstadoCivil() {
                return estadoCivil;
        }

        public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
                this.estadoCivil = estadoCivil;
        }
}
