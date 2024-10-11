package com.ramitax.repository;

import com.ramitax.model.entity.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {
}
