package com.f3pro.sgci.factory;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.schema.EnderecoReq;

public class EnderecoFactory {

    public static Endereco  getEndereco(){

        return new Endereco(
                "06455000",
                "sp",
                "Vargem Grande Pta",
                "Rua Joao XX",
                "sao judas",
                955
        );
    }

    public static EnderecoReq getEnderecoReq(){

        return new EnderecoReq(
                "06455000",
                "sp",
                "Vargem Grande Pta",
                "Rua Joao XX",
                "sao judas",
                955
        );
    }
}
