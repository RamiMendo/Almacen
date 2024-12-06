package com.ramitax.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "proveedores")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id_proveedor")),
        @AttributeOverride(name = "cuit", column = @Column(name = "cuil"))})
@JsonIgnoreProperties("ordenesCompra")
public class Proveedor extends Entidad{

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
    private List<OrdenCompra> ordenesCompra;

}
