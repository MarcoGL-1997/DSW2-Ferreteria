package com.ferreteria.inventario.service;

import com.ferreteria.inventario.model.dto.InventarioRequest;
import com.ferreteria.inventario.model.dto.InventarioResponse;
import com.ferreteria.inventario.model.dto.ProductoInventarioResponse;

import java.util.List;

public interface InventarioService {

    InventarioResponse create(InventarioRequest request);

    List<InventarioResponse> findAll();

    InventarioResponse findById(Long id);

    InventarioResponse findByProductoId(Long productoId);

    InventarioResponse update(Long id, InventarioRequest request);

    void delete(Long id);

    ProductoInventarioResponse obtenerDetalleProducto(Long productoId);
}