package com.ramitax.mapper;

import com.ramitax.model.dto.DomicilioDTO;
import com.ramitax.model.entity.Domicilio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomicilioMapper {

    Domicilio dtoToDomicilio(DomicilioDTO domicilioDTO);

    List<Domicilio> dtoListToList(List<DomicilioDTO> domiciliosDTO);

}
