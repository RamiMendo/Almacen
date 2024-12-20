package com.ramitax.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ramitax.model.enumerated.MedioPago;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
@JsonIgnoreProperties("pedidos")
@AttributeOverride(name = "id", column = @Column(name = "id_factura"))
public class Factura extends Comprobante{

    @Column(nullable = false)
    private Double importe;

    @Column(nullable = false)
    private Double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    private MedioPago medioPago;

    @Column(nullable = false)
    private Boolean firmaConforme;

    @Nullable
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "factura-detalle")
    private List<FacturaDetalle> facturasDetalle;
}
