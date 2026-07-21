package com.ferreteria.productos.service;

import com.ferreteria.productos.model.dto.ProductoDetalleResponse;
import com.ferreteria.productos.model.dto.ProductoRequest;
import com.ferreteria.productos.model.dto.ProductoResponse;

import java.util.List;

public interface ProductoService {

    ProductoResponse create(ProductoRequest request);

    List<ProductoResponse> findAll();

    ProductoResponse findById(Long id);

    ProductoResponse update(Long id, ProductoRequest request);

    void delete(Long id);

    ProductoDetalleResponse obtenerDetalleProducto(Long id);

}