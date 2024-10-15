package com.ramitax.mapper;

import com.ramitax.model.entity.Cliente;
import com.ramitax.model.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DomicilioMapper.class})
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente dtoToCliente(ClienteDTO dto);

}
