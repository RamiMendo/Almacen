package com.ramitax.service;

import com.ramitax.exception.CustomException;
import com.ramitax.mapper.PedidoMapper;
import com.ramitax.model.dto.PedidoDTO;
import com.ramitax.model.entity.Pedido;
import com.ramitax.model.enumerated.Estado;
import com.ramitax.model.projection.PedidoDetalleView;
import com.ramitax.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    public Page<Pedido> findAll(Integer idCliente, LocalDate desde, LocalDate hasta, Integer estado, Pageable pageable) {
        return pedidoRepository.pedidosFiltrados(idCliente, desde, hasta, estado, pageable);
    }

    public Pedido findById(Long id) throws CustomException {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<PedidoDetalleView> totalizaPedidos(LocalDate desde, LocalDate hasta){
        return pedidoRepository.totalizaPedidos(desde, hasta);
    }

    public Pedido save(PedidoDTO dto) {
        Pedido pedido = pedidoMapper.dtoToPedido(dto);
        pedido.setFecha(LocalDate.now());
        pedido.setEstado(Estado.PENDIENTE);

        pedido.getPedidoDetalles().forEach(d -> {
            d.setPedido(pedido);
            d.setEntregado(0);
        });

        return pedidoRepository.save(pedido);
    }

    public void delete(Pedido pedido) {
        pedidoRepository.delete(pedido);
    }

    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

}
