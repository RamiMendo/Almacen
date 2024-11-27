package com.ramitax.controller;

import com.ramitax.model.entity.Articulo;
import com.ramitax.model.dto.ArticuloDTO;
import com.ramitax.service.ArticuloService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping(path = "/findAll", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"ARTICULOS"}
    )
    private ResponseEntity<Page<Articulo>> getAllArticulos(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Articulo> articuloPage = articuloService.findAll(pageable);

        return new ResponseEntity<>(articuloPage, HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"ARTICULOS"}
    )
    private @ResponseBody Articulo saveArticulo(@RequestBody ArticuloDTO articuloDTO){
        return articuloService.save(articuloDTO);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"ARTICULOS"}
    )
    private @ResponseBody Articulo updateArticulo(@RequestBody Articulo articulo){
        return articuloService.update(articulo);
    }

    @DeleteMapping(path = "/delete", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"ARTICULOS"}
    )
    private ResponseEntity<Void> deleteArticulo(Articulo articulo){
        articuloService.delete(articulo);
        return ResponseEntity.noContent().build();
    }
}
