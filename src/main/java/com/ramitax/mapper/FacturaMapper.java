package com.ramitax.mapper;

import com.ramitax.model.dto.FacturaDTO;
import com.ramitax.model.entity.Factura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FacturaDetalleMapper.class})
public interface FacturaMapper {

    Factura dtoToEntity(FacturaDTO facturaDTO);

}
