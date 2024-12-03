package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.ArticuloMapper;
import com.ramitax.model.entity.Articulo;
import com.ramitax.model.dto.ArticuloDTO;
import com.ramitax.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService{

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ArticuloMapper articuloMapper;

    public Page<Articulo> findAll(Pageable pageable) {
        return articuloRepository.findAll(pageable);
    }

    public Articulo findById(Integer id) throws CustomException {
        return articuloRepository.findById(id).orElse(null);
    }

    public Articulo save(ArticuloDTO articuloDTO) {
        Articulo articulo = articuloMapper.dtoToArticulo(articuloDTO);
        return articuloRepository.save(articulo);
    }

    public void delete(Articulo articulo) {
        articuloRepository.delete(articulo);
    }

    public Articulo update(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

}