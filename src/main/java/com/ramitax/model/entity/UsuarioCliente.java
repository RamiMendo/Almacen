package com.ramitax.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios_cliente")
public class UsuarioCliente extends Usuario{

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
