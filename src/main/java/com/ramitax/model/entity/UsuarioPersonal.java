package com.ramitax.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios_personal")
public class UsuarioPersonal extends Usuario {

    @ManyToMany
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "id_usuarios"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Rol> roles = new ArrayList<>();

}
