package com.ramitax.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido extends Comprobante{

    @Column(nullable = false)
    private LocalDate fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido", orphanRemoval = true)
    private List<PedidoDetalle> pedidoDetalles;

    @Override
    public void imprime() {

    }

    @Override
    public void descarga() {

    }
}