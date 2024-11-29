package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.dto.OrdenDTO;
import com.ramitax.model.entity.OrdenCompra;
import com.ramitax.service.OrdenCompraService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ORDENES COMPRA"}
    )
    private ResponseEntity<Page<OrdenCompra>> getAllOrdenCompras(@RequestParam Integer page, @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrdenCompra> ordenCompra = ordenCompraService.findAll(pageable);

        return new ResponseEntity<>(ordenCompra, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ORDENES COMPRA"}
    )
    private @ResponseBody OrdenCompra findById(@RequestParam Long id) throws CustomException {
        return ordenCompraService.findById(id);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"ORDENES COMPRA"}
    )
    private @ResponseBody OrdenCompra save(@RequestBody OrdenDTO dto){
        return ordenCompraService.save(dto);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"ORDENES COMPRA"}
    )
    private @ResponseBody OrdenCompra update(@RequestBody OrdenCompra ordenCompra){
        return ordenCompraService.update(ordenCompra);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ORDENES COMPRA"}
    )
    private ResponseEntity<Void> delete(OrdenCompra ordenCompra){
        ordenCompraService.delete(ordenCompra);
        return ResponseEntity.ok().build();
    }
}
