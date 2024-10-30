package com.f3pro.sgci.schema;

import jakarta.validation.constraints.NotNull;

public record EnderecoResponse(

        String cep,
        String estado,
        String cidade,
        String rua,
        String bairro,
        Integer numero

) {
}