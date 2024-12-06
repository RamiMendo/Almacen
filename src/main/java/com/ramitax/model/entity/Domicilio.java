package com.ramitax.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_domicilio")
    private Integer id;

    @Column(nullable = false, length = 30)
    private String direccion;

    @Column(nullable = false, length = 25)
    private String localidad;

    @Column(nullable = false, length = 20)
    private String provincia;

    @Column(nullable = false, length = 15)
    private String pais;

}
