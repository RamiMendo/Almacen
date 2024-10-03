package com.ramitax.service;

import com.ramitax.model.Articulo;
import com.ramitax.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public Page<Articulo> findAll(Pageable pageable) {
        return articuloRepository.findAll(pageable);
    }

    public Articulo findById(Integer id) {
        return articuloRepository.findById(id).get();
    }

    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public void delete(Articulo articulo) {
        articuloRepository.delete(articulo);
    }

    public Articulo update(Articulo articulo) {
        return articuloRepository.save(articulo);
    }





}