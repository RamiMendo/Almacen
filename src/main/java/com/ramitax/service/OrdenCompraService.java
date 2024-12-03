package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.OrdenMapper;
import com.ramitax.model.dto.OrdenCompraDTO;
import com.ramitax.model.entity.OrdenCompra;
import com.ramitax.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public Page<OrdenCompra> findAll(Pageable pageable) {
        return ordenCompraRepository.findAll(pageable);
    }

    public OrdenCompra findById(Long id) throws CustomException {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    public OrdenCompra save(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public void delete(OrdenCompra ordenCompra) {
        ordenCompraRepository.delete(ordenCompra);
    }

    public OrdenCompra update(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }
}
