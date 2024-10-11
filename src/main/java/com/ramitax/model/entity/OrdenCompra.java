package com.ramitax.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes_compras")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrdenCompra extends Comprobante{

    @Column(nullable = false)
    private LocalDate fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;

    @Override
    public void imprime() {

    }

    @Override
    public void descarga() {

    }
}
