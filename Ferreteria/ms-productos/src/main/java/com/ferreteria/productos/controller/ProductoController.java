package com.ferreteria.productos.controller;

import com.ferreteria.productos.model.dto.ProductoDetalleResponse;
import com.ferreteria.productos.model.dto.ProductoRequest;
import com.ferreteria.productos.model.dto.ProductoResponse;
import com.ferreteria.productos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ProductoResponse create(@Valid @RequestBody ProductoRequest request) {
        return productoService.create(request);
    }

    @GetMapping
    public List<ProductoResponse> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ProductoResponse findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @GetMapping("/{id}/detalle")
    public ProductoDetalleResponse obtenerDetalle(@PathVariable Long id) {
        return productoService.obtenerDetalleProducto(id);
    }

    @PutMapping("/{id}")
    public ProductoResponse update(@PathVariable Long id,
                                   @Valid @RequestBody ProductoRequest request) {
        return productoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.delete(id);
    }
}