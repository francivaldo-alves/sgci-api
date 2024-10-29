package com.f3pro.sgci.schema;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EnderecoReq(

        String cep,
        @NotNull
        String estado,
        @NotNull
        String cidade,
        String rua,
        String bairro,

        Integer numero

) {
}
