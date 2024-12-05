package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.entity.Rol;
import com.ramitax.service.RolService;
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
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ROLES"}
    )
    public ResponseEntity<Page<Rol>> findAll(@RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Rol> rols = rolService.findAll(pageable);

        return new ResponseEntity<>(rols, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ROLES"}
    )
    public @ResponseBody Rol findById(@RequestParam Integer id) throws CustomException {
        return rolService.findById(id);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ROLES"}
    )
    public @ResponseBody Rol save(@RequestParam Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ROLES"}
    )
    public @ResponseBody Rol update(@RequestParam Rol rol) {
        return rolService.update(rol);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"ROLES"}
    )
    public ResponseEntity<Void> delete(@RequestParam Rol rol) {
        rolService.delete(rol);
        return ResponseEntity.noContent().build();
    }

}
