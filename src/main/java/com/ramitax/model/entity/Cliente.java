package com.ramitax.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "clientes")
@JsonIgnoreProperties({"pedidos", "usuario"})
public class Cliente extends Entidad{

    @Column(nullable = false, length = 8)
    private String dni;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinTable(name = "clientes_domicilios",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_domicilio")
    )
    private List<Domicilio> domicilios;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

}