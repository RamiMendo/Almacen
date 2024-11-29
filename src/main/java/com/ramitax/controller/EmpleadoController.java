package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.dto.EmpleadoDTO;
import com.ramitax.model.entity.Empleado;
import com.ramitax.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(path = "/findAll", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"EMPLEADOS"}
    )
    private ResponseEntity<Page<Empleado>> findAllEmpleados(@RequestParam Integer page, @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Empleado> empleadoPage = empleadoService.findAll(pageable);

        return new ResponseEntity<>(empleadoPage, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"EMPLEADOS"}
    )
    private @ResponseBody Empleado findById(@RequestParam Integer id) throws CustomException {
        return empleadoService.findById(id);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"EMPLEADOS"}
    )
    private @ResponseBody Empleado save(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.save(empleadoDTO);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"EMPLEADOS"}
    )
    private @ResponseBody Empleado update(@RequestBody Empleado empleado) {
        return empleadoService.update(empleado);
    }

    @DeleteMapping(path = "/delete", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"EMPLEADOS"}
    )
    private ResponseEntity<Void> delete(Empleado empleado) {
        empleadoService.delete(empleado);
        return ResponseEntity.noContent().build();
    }
}
