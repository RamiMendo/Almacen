package com.ramitax.controller;

import com.ramitax.model.Cliente;
import com.ramitax.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/findAll", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"CLIENTES"}
    )
    private ResponseEntity<Page<Cliente>> findAllClientes(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Cliente> pageCliente = clienteService.findAll(pageable);

        return new ResponseEntity<>(pageCliente, HttpStatus.OK);
    }

}
