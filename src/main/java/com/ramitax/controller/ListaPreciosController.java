package com.ramitax.controller;

import com.ramitax.service.ListaPreciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listaPrecios")
public class ListaPreciosController {

    @Autowired
    private ListaPreciosService listaPreciosService;



}
