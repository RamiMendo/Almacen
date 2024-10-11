package com.ramitax.mapper;

import com.ramitax.model.entity.Proveedor;
import com.ramitax.model.dto.ProveedorDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProveedorMapper {

    Proveedor dtoToProveedor(ProveedorDTO proveedorDTO);

}
