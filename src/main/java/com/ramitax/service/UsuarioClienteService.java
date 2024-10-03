package com.ramitax.service;

import com.ramitax.model.UsuarioCliente;
import com.ramitax.repository.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public Page<UsuarioCliente> findAll(Pageable pageable) {
        return usuarioClienteRepository.findAll(pageable);
    }

    public UsuarioCliente findById(Long id) {
        return usuarioClienteRepository.findById(id).get();
    }

    public UsuarioCliente save(UsuarioCliente usuarioCliente) {
        return usuarioClienteRepository.save(usuarioCliente);
    }

    public void delete(UsuarioCliente usuarioCliente) {
        usuarioClienteRepository.delete(usuarioCliente);
    }

    public UsuarioCliente update(UsuarioCliente usuarioCliente) {
        return usuarioClienteRepository.save(usuarioCliente);
    }

}
