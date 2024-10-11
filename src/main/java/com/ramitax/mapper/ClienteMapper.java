package com.ramitax.mapper;

import com.ramitax.model.entity.Cliente;
import com.ramitax.model.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {

    Cliente dtoToCliente(ClienteDTO dto);

}
