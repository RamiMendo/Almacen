package com.ramitax.mapper;

import com.ramitax.model.Articulo;
import com.ramitax.model.dto.ArticuloDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticuloMapper {

    ArticuloMapper INSTANCE = Mappers.getMapper(ArticuloMapper.class);

    Articulo articuloDtoToArticulo(ArticuloDTO dto);
}
