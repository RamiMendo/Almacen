package com.ramitax.mapper;

import com.ramitax.model.entity.Empleado;
import com.ramitax.model.dto.EmpleadoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EmpleadoMapper{

    Empleado dtoToEmpleado(EmpleadoDTO empleadoDTO);

}
