package com.ramitax.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "proveedores")
@AttributeOverride(name = "cuit", column = @Column(name = "cuil"))
@JsonIgnoreProperties("ordenesCompra")
public class Proveedor extends Entidad{

    @Column(nullable = false, length = 35)
    private String domicilio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
    private List<OrdenCompra> ordenesCompra;

}
