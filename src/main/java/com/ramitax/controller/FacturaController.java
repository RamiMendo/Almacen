package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.dto.FacturaDTO;
import com.ramitax.model.entity.Factura;
import com.ramitax.service.FacturaService;
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
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping(path = "/findAll/{numPage}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"FACTURAS"}
    )
    private ResponseEntity<Page<Factura>> getAllFacturas(@PathVariable("numPage") Integer page, @PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Factura> facturas = facturaService.findAll(pageable);

        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"FACTURAS"}
    )
    private @ResponseBody Factura findById(@RequestParam Long id) throws CustomException {
        return facturaService.findById(id);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"FACTURAS"}
    )
    private @ResponseBody Factura save(@RequestBody FacturaDTO dto){
        return facturaService.save(dto);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"FACTURAS"}
    )
    private @ResponseBody Factura update(@RequestBody Factura factura){
        return facturaService.update(factura);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"FACTURAS"}
    )
    private ResponseEntity<Void> delete(@RequestBody Factura factura){
        facturaService.delete(factura);
        return ResponseEntity.noContent().build();
    }
}
