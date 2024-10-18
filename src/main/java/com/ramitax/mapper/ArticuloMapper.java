package com.ramitax.mapper;

import com.ramitax.model.entity.Articulo;
import com.ramitax.model.dto.ArticuloDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticuloMapper {

    Articulo dtoToArticulo(ArticuloDTO dto);

}
