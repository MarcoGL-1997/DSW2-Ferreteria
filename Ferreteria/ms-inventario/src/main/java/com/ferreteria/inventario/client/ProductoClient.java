package com.ferreteria.inventario.client;

import com.ferreteria.inventario.model.dto.ProductoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-productos")
public interface ProductoClient {

    @GetMapping("/api/productos/{id}")
    ProductoResponse findById(@PathVariable Long id);

}