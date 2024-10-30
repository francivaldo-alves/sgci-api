package com.f3pro.sgci.schema;

import com.f3pro.sgci.model.EstadoCivilEnum;
import com.f3pro.sgci.model.TipoPessoaEnum;
import jakarta.validation.constraints.NotNull;

public record PessoaResponse(
        String nome,
        EnderecoResponse endereco,
        TipoPessoaEnum tipo,
        String documento,
        String profissao,
        EstadoCivilEnum estadoCivil
) {

}
