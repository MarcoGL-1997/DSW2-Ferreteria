package com.ferreteria.productos.service.impl;

import com.ferreteria.productos.client.InventarioClient;
import com.ferreteria.productos.exception.ResourceNotFoundException;
import com.ferreteria.productos.model.dto.ProductoDetalleResponse;
import com.ferreteria.productos.model.dto.ProductoRequest;
import com.ferreteria.productos.model.dto.ProductoResponse;
import com.ferreteria.productos.model.dto.feign.InventarioResponse;
import com.ferreteria.productos.model.entity.ProductoEntity;
import com.ferreteria.productos.model.mapper.ProductoMapper;
import com.ferreteria.productos.repository.ProductoRepository;
import com.ferreteria.productos.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper mapper;
    private final InventarioClient inventarioClient;

    public ProductoServiceImpl(ProductoRepository repository,
                               ProductoMapper mapper,
                               InventarioClient inventarioClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.inventarioClient = inventarioClient;
    }

    @Override
    public ProductoResponse create(ProductoRequest request) {

        ProductoEntity entity = mapper.toEntity(request);

        entity = repository.save(entity);

        return mapper.toResponse(entity);
    }

    @Override
    public List<ProductoResponse> findAll() {

        List<ProductoEntity> entities = repository.findAll();

        return mapper.toResponseList(entities);
    }

    @Override
    public ProductoResponse findById(Long id) {

        ProductoEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el producto con ID: " + id));

        return mapper.toResponse(entity);
    }

    @Override
    public ProductoResponse update(Long id, ProductoRequest request) {

        ProductoEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el producto con ID: " + id));

        entity.setNombre(request.getNombre());
        entity.setMarca(request.getMarca());
        entity.setPrecio(request.getPrecio());
        entity.setCategoria(request.getCategoria());

        entity = repository.save(entity);

        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {

        ProductoEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el producto con ID: " + id));

        repository.delete(entity);
    }

    @Override
    public ProductoDetalleResponse obtenerDetalleProducto(Long id) {

        ProductoEntity producto = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el producto con ID: " + id));

        InventarioResponse inventario =
                inventarioClient.obtenerInventarioPorProducto(id);

        ProductoDetalleResponse response = new ProductoDetalleResponse();

        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setMarca(producto.getMarca());
        response.setPrecio(producto.getPrecio());
        response.setCategoria(producto.getCategoria());

        if (inventario != null) {
            response.setStock(inventario.getStock());
        } else {
            response.setStock(0);
        }

        return response;
    }
}