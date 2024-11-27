package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.dto.ClienteDTO;
import com.ramitax.model.entity.Cliente;
import com.ramitax.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/findID", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"CLIENTES"}
    )
    private @ResponseBody Cliente findClienteById(@RequestParam Integer id) throws CustomException {
        return clienteService.findById(id);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"CLIENTES"}
    )
    private @ResponseBody Cliente save(@RequestBody ClienteDTO clienteDTO){
        return clienteService.save(clienteDTO);
    }
}
