package com.ramitax.mapper;

import com.ramitax.model.dto.FacturaDetalleDTO;
import com.ramitax.model.entity.FacturaDetalle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturaDetalleMapper {

    FacturaDetalle dtoToFacturaDetalle(FacturaDetalleDTO dto);

    List<FacturaDetalle> dtoListToFacturaDetalle(List<FacturaDetalleDTO> dtoList);

}
