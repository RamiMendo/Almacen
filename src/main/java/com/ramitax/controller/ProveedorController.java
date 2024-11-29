package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.dto.ProveedorDTO;
import com.ramitax.model.entity.Proveedor;
import com.ramitax.service.ProveedorService;
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
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping(path = "/findAll", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PROVEEDORES"}
    )
    private ResponseEntity<Page<Proveedor>> findAllProveedores(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Proveedor> proveedores = proveedorService.findAll(pageable);

        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PROVEEDORES"}
    )
    private @ResponseBody Proveedor findById(@RequestParam Integer id) throws CustomException {
        return proveedorService.findById(id);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PROVEEDORES"}
    )
    private @ResponseBody Proveedor save(@RequestBody ProveedorDTO dto) {
        return proveedorService.save(dto);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PROVEEDORES"}
    )
    private @ResponseBody Proveedor update(@RequestBody Proveedor proveedor) {
        return proveedorService.update(proveedor);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PROVEEDORES"}
    )
    private ResponseEntity<Void> delete(@RequestBody Proveedor proveedor) {
        proveedorService.delete(proveedor);
        return ResponseEntity.noContent().build();
    }
}
