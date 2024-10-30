package com.f3pro.sgci.schema;

import com.f3pro.sgci.model.Endereco;
import com.f3pro.sgci.model.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EnderecoMapper {
	EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

	EnderecoResponse toEnderecoResponse(Endereco endereco);
}