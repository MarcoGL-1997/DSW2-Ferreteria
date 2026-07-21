package com.ferreteria.inventario.controller;

import com.ferreteria.inventario.model.dto.InventarioRequest;
import com.ferreteria.inventario.model.dto.InventarioResponse;
import com.ferreteria.inventario.service.InventarioService;
import com.ferreteria.inventario.model.dto.ProductoInventarioResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public InventarioResponse create(@Valid @RequestBody InventarioRequest request) {
        return inventarioService.create(request);
    }

    @GetMapping
    public List<InventarioResponse> findAll() {
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public InventarioResponse findById(@PathVariable Long id) {
        return inventarioService.findById(id);
    }

    @PutMapping("/{id}")
    public InventarioResponse update(@PathVariable Long id,
                                     @Valid @RequestBody InventarioRequest request) {
        return inventarioService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventarioService.delete(id);
    }

    @GetMapping("/producto/{productoId}")
    public InventarioResponse findByProductoId(@PathVariable Long productoId) {

        return inventarioService.findByProductoId(productoId);
    }

    @GetMapping("/producto/{productoId}/detalle")
    public ProductoInventarioResponse obtenerDetalleProducto(
            @PathVariable Long productoId) {

        return inventarioService.obtenerDetalleProducto(productoId);
    }
}