package com.ramitax.repository;

import com.ramitax.model.entity.Pedido;
import com.ramitax.model.projection.PedidoDetalleView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, PedidoRepositoryCustom {

    @Query(value = "SELECT D.id_articulo, SUM(D.cantidad) AS cantidad FROM pedidos AS C INNER JOIN pedidos_detalle AS D ON C.id_pedido = D.id_pedido WHERE C.fecha <= :hasta AND C.fecha >= :desde GROUP BY D.id_articulo;", nativeQuery = true)
    List<PedidoDetalleView> totalizaPedidos(LocalDate desde, LocalDate hasta);

    Page<Pedido> pedidosFiltrados(Integer idCliente, LocalDate desde, LocalDate hasta, Integer estado, Pageable pageable);
}
