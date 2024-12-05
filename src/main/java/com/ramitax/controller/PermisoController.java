package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.entity.Permiso;
import com.ramitax.service.PermisoService;
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
@RequestMapping(path = "/permiso")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PERMISOS"}
    )
    public ResponseEntity<Page<Permiso>> findAll(@RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Permiso> permisos = permisoService.findAll(pageable);

        return new ResponseEntity<>(permisos, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PERMISOS"}
    )
    public @ResponseBody Permiso findById(@RequestParam Integer id) throws CustomException {
        return permisoService.findById(id);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PERMISOS"}
    )
    public @ResponseBody Permiso save(@RequestBody Permiso permiso) throws CustomException {
        return permisoService.save(permiso);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PERMISOS"}
    )
    public @ResponseBody Permiso update(@RequestBody Permiso permiso) throws CustomException {
        return permisoService.update(permiso);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PERMISOS"}
    )
    public ResponseEntity<Void> delete(@RequestBody Permiso permiso) throws CustomException {
        permisoService.delete(permiso);
        return ResponseEntity.noContent().build();
    }

}
