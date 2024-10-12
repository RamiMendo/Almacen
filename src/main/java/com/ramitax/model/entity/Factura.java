package com.ramitax.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ramitax.enumerated.MedioPago;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    private MedioPago medioPago;

    @Column(nullable = false)
    private Boolean firmaConforme;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "factura_pedidos",
            joinColumns = @JoinColumn(name = "id_factura"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido")
    )
    private List<Pedido> pedidos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> facturasDetalle;

    @Override
    public void imprime() {
        String ext = PDF;
    }

    @Override
    public void descarga() {

    }
}
