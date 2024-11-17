package com.f3pro.sgci.factory;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.model.EstadoCivilEnum;
import com.f3pro.sgci.model.Pessoa;
import com.f3pro.sgci.model.TipoPessoaEnum;
import com.f3pro.sgci.schema.EnderecoReq;
import com.f3pro.sgci.schema.PessoaReq;

public class PessoaFactory {

    public static Pessoa getPessoa(Endereco endereco) {
        return new Pessoa(
                endereco,
                "Francivaldo Alves",
                TipoPessoaEnum.PESSOA_FISICA,
                "064225234",
                "Analista de sistema",
                EstadoCivilEnum.CASADO

        );
    }

    public static PessoaReq getPessoaReq(EnderecoReq enderecoReq) {
        return new PessoaReq("Francivaldo",
                enderecoReq,
                TipoPessoaEnum.PESSOA_FISICA,
                "064225234",
                "Analista de sistema",
                EstadoCivilEnum.CASADO);
    }
}
