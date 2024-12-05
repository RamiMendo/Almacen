package com.ramitax.controller;

import com.ramitax.exception.CustomException;
import com.ramitax.model.entity.Usuario;
import com.ramitax.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"USUARIOS"}
    )
    public ResponseEntity<Page<Usuario>> findAll(@RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 7);
        Page<Usuario> usuarios = usuarioService.findAll(pageable);

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"USUARIOS"}
    )
    public @ResponseBody Usuario findById(@RequestParam Integer id) throws CustomException {
        return usuarioService.findById(id);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"USUARIOS"}
    )
    public @ResponseBody Usuario save(@RequestParam Usuario usuario) throws CustomException {
        return usuarioService.save(usuario);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"USUARIOS"}
    )
    public @ResponseBody Usuario update(@RequestParam Usuario usuario) throws CustomException {
        return usuarioService.update(usuario);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"USUARIOS"}
    )
    public ResponseEntity<Void> delete(@RequestParam Usuario usuario) throws CustomException {
        usuarioService.delete(usuario);
        return ResponseEntity.noContent().build();
    }
}
