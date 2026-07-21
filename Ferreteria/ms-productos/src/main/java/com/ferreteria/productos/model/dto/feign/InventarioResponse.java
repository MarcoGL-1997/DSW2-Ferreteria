package com.ferreteria.productos.model.dto.feign;

public class InventarioResponse {

    private Long id;
    private Long productoId;
    private Integer stock;

    public InventarioResponse() {
    }

    public InventarioResponse(Long id, Long productoId, Integer stock) {
        this.id = id;
        this.productoId = productoId;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}