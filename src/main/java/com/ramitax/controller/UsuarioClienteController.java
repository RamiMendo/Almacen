package com.ramitax.controller;

import com.ramitax.service.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioCliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;

}
