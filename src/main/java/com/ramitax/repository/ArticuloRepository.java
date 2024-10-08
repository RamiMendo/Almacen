package com.ramitax.repository;

import com.ramitax.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
}