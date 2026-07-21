package com.ferreteria.productos.client;

import com.ferreteria.productos.model.dto.feign.InventarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-inventario")
public interface InventarioClient {

    @GetMapping("/api/inventario/producto/{productoId}")
    InventarioResponse obtenerInventarioPorProducto(
            @PathVariable("productoId") Long productoId);

}