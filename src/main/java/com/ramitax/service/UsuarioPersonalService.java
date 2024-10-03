package com.ramitax.service;

import com.ramitax.repository.UsuarioPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPersonalService {

    @Autowired
    private UsuarioPersonalRepository usuarioPersonalRepository;

}
