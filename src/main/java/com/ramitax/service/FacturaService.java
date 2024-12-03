package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.FacturaMapper;
import com.ramitax.model.dto.FacturaDTO;
import com.ramitax.model.entity.Factura;
import com.ramitax.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Page<Factura> findAll(Pageable pageable) {
        return facturaRepository.findAll(pageable);
    }

    public Factura findById(Long id) throws CustomException {
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void delete(Factura factura) {
        facturaRepository.delete(factura);
    }

    public Factura update(Factura factura) {
        return facturaRepository.save(factura);
    }

}
