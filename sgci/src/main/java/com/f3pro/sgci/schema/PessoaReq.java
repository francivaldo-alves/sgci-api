package com.f3pro.sgci.schema;

import com.f3pro.sgci.model.EstadoCivilEnum;
import com.f3pro.sgci.model.TipoPessoaEnum;
import jakarta.validation.constraints.NotNull;

public record PessoaReq(

        @NotNull
        String nome,

        @NotNull
        EnderecoReq endereco,

        @NotNull
        TipoPessoaEnum tipo,

        @NotNull
        String documento,

        @NotNull
        String profissao,

        @NotNull
        EstadoCivilEnum estadoCivil
) {

}
