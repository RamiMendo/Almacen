package com.ramitax.controller;

import com.ramitax.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

}
