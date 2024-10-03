package com.ramitax.controller;

import com.ramitax.service.UsuarioPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioPersonal")
public class UsuarioPersonalController {

    @Autowired
    private UsuarioPersonalService usuarioPersonalService;

}
