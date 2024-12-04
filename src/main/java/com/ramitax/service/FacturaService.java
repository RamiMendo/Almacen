package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.FacturaMapper;
import com.ramitax.model.dto.FacturaDTO;
import com.ramitax.model.entity.Factura;
import com.ramitax.model.enumerated.Estado;
import com.ramitax.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturaMapper facturaMapper;

    public Page<Factura> findAll(Pageable pageable) {
        return facturaRepository.findAll(pageable);
    }

    public Factura findById(Long id) throws CustomException {
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura save(FacturaDTO facturaDTO) {
        Factura factura = facturaMapper.dtoToEntity(facturaDTO);
        factura.setFecha(LocalDate.now());
        factura.setEstado(Estado.PENDIENTE);
        factura.setFirmaConforme(Boolean.FALSE);
        factura.getFacturasDetalle().forEach(d -> d.setFactura(factura));

        Double importe = factura.getFacturasDetalle().stream()
                .map(d -> ((d.getCantidad()*d.getPrecio())*(1 + (d.getDescuento()/100))))
                .mapToDouble(Double::doubleValue)
                .sum();

        factura.setSaldo(importe);
        factura.setImporte(importe);
        return facturaRepository.save(factura);
    }

    public void delete(Factura factura) {
        facturaRepository.delete(factura);
    }

    public Factura update(Factura factura) {
        return facturaRepository.save(factura);
    }

}
