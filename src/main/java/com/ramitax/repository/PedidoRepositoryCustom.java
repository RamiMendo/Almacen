package com.ramitax.repository;

import com.ramitax.model.entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface PedidoRepositoryCustom {

    Page<Pedido> pedidosFiltrados(Integer idCliente, LocalDate desde, LocalDate hasta, Integer estado, Pageable pageable);

}
