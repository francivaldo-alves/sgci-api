package com.f3pro.sgci.schema;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.f3pro.sgci.model.Pessoa;



@Mapper
public interface PessoaMapper {
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

	@Mapping(source = "enderecoResponse", target = "endereco")
	PessoaResponse toPessoaResponse(Pessoa pessoa, EnderecoResponse enderecoResponse);
}