package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.OrdenMapper;
import com.ramitax.model.dto.OrdenCompraDTO;
import com.ramitax.model.entity.OrdenCompra;
import com.ramitax.model.enumerated.Estado;
import com.ramitax.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    public Page<OrdenCompra> findAll(Pageable pageable) {
        return ordenCompraRepository.findAll(pageable);
    }

    public OrdenCompra findById(Long id) throws CustomException {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    public OrdenCompra save(OrdenCompraDTO ordenDTO) {
        OrdenCompra ordenCompra = ordenMapper.dtoToOrden(ordenDTO);
        ordenCompra.setFecha(LocalDate.now());
        ordenCompra.setEstado(Estado.PENDIENTE);
        ordenCompra.getOrdenCompraDetalle().forEach(d -> {
            d.setOrden(ordenCompra);
            d.setCantidadRecibidad(0);
        });

        Double importe = ordenCompra.getOrdenCompraDetalle().stream()
                        .map(d -> (d.getPrecioCompra()*d.getCantidadSolicitada()))
                        .mapToDouble(Double::doubleValue)
                        .sum();

        ordenCompra.setImporte(importe);
        ordenCompra.setSaldo(importe);

        return ordenCompraRepository.save(ordenCompra);
    }

    public void delete(OrdenCompra ordenCompra) {
        ordenCompraRepository.delete(ordenCompra);
    }

    public OrdenCompra update(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }
}
