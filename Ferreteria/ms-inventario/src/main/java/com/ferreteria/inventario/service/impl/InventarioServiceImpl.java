package com.ferreteria.inventario.service.impl;

import com.ferreteria.inventario.exception.ResourceNotFoundException;
import com.ferreteria.inventario.model.dto.InventarioRequest;
import com.ferreteria.inventario.model.dto.InventarioResponse;
import com.ferreteria.inventario.model.dto.ProductoInventarioResponse;
import com.ferreteria.inventario.model.entity.InventarioEntity;
import com.ferreteria.inventario.model.mapper.InventarioMapper;
import com.ferreteria.inventario.repository.InventarioRepository;
import com.ferreteria.inventario.service.InventarioService;
import com.ferreteria.inventario.client.ProductoClient;
import com.ferreteria.inventario.model.dto.ProductoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository repository;
    private final InventarioMapper mapper;
    private final ProductoClient productoClient;

    public InventarioServiceImpl(InventarioRepository repository,
                                 InventarioMapper mapper, ProductoClient productoClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.productoClient = productoClient;
    }

    @Override
    public InventarioResponse create(InventarioRequest request) {

        InventarioEntity entity = mapper.toEntity(request);

        entity = repository.save(entity);

        return mapper.toResponse(entity);
    }

    @Override
    public List<InventarioResponse> findAll() {

        List<InventarioEntity> entities = repository.findAll();

        return mapper.toResponseList(entities);
    }

    @Override
    public InventarioResponse findById(Long id) {

        InventarioEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el inventario con ID: " + id));

        return mapper.toResponse(entity);
    }

    @Override
    public InventarioResponse findByProductoId(Long productoId) {

        ProductoResponse producto = productoClient.findById(productoId);

        InventarioEntity entity = repository.findByProductoId(productoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe inventario para el producto con ID: " + productoId));

        return mapper.toResponse(entity);
    }

    @Override
    public InventarioResponse update(Long id, InventarioRequest request) {

        InventarioEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el inventario con ID: " + id));

        entity.setProductoId(request.getProductoId());
        entity.setStock(request.getStock());

        entity = repository.save(entity);

        return mapper.toResponse(entity);
    }

    @Override
    public void delete(Long id) {

        InventarioEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el inventario con ID: " + id));

        repository.delete(entity);
    }

    @Override
    public ProductoInventarioResponse obtenerDetalleProducto(Long productoId) {


        ProductoResponse producto = productoClient.findById(productoId);


        InventarioEntity inventario = repository.findByProductoId(productoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe inventario para el producto con ID: " + productoId));


        ProductoInventarioResponse response = new ProductoInventarioResponse();

        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setMarca(producto.getMarca());
        response.setPrecio(producto.getPrecio());
        response.setCategoria(producto.getCategoria());
        response.setStock(inventario.getStock());

        return response;
    }


}