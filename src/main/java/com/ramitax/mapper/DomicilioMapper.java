package com.ramitax.mapper;

import com.ramitax.model.dto.DomicilioDTO;
import com.ramitax.model.entity.Domicilio;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DomicilioMapper {

    Domicilio dtoToDomicilio(DomicilioDTO domicilioDTO);

    List<Domicilio> dtoListToList(List<DomicilioDTO> domiciliosDTO);

}
