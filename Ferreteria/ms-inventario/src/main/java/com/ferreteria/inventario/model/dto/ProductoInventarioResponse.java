package com.ferreteria.inventario.model.dto;

public class ProductoInventarioResponse {

    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private String categoria;
    private Integer stock;

    public ProductoInventarioResponse() {
    }

    public ProductoInventarioResponse(Long id,
                                      String nombre,
                                      String marca,
                                      Double precio,
                                      String categoria,
                                      Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}