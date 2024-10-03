package com.ramitax.repository;

import com.ramitax.model.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {
}
