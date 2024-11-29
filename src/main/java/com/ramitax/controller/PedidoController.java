package com.ramitax.controller;

import com.ramitax.model.enumerated.Estado;
import com.ramitax.exception.CustomException;
import com.ramitax.model.dto.PedidoDTO;
import com.ramitax.model.entity.Pedido;
import com.ramitax.model.projection.PedidoDetalleView;
import com.ramitax.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(path = "/findAll", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PEDIDOS"}
    )
    private ResponseEntity<Page<Pedido>> findAll(@RequestParam Integer page, @RequestParam Integer idCliente,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta,
                                                 @RequestParam Estado estado) {
        Pageable pageable = PageRequest.of(page, 7);
        Page<Pedido> pedidoPage = pedidoService.findAll(idCliente, desde, hasta, estado.getCodigo(), pageable);

        return new ResponseEntity<>(pedidoPage, HttpStatus.OK);
    }

    @GetMapping(path = "/findID", produces = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PEDIDOS"}
    )
    private @ResponseBody Pedido findById(@RequestParam Long id) throws CustomException {
        return pedidoService.findById(id);
    }

    @GetMapping(path = "/totalizador", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            description = "",
            tags = {"PEDIDOS"}
    )
    private @ResponseBody List<PedidoDetalleView> totalizador(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta) {
        return pedidoService.totalizaPedidos(desde, hasta);
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PEDIDOS"}
    )
    private @ResponseBody Pedido save(@RequestBody PedidoDTO dto) throws SQLException {
        return pedidoService.save(dto);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PEDIDOS"}
    )
    private @ResponseBody Pedido update(@RequestBody Pedido pedido){
        return pedidoService.update(pedido);
    }

    @DeleteMapping(path = "/delete", consumes = "application/json")
    @Operation(summary = "",
            description = "",
            tags = {"PEDIDOS"}
    )
    private ResponseEntity<Void> delete(@RequestBody Pedido pedido){
        pedidoService.delete(pedido);
        return ResponseEntity.ok().build();
    }
}
