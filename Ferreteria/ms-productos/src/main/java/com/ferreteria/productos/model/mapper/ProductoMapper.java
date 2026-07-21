package com.ferreteria.productos.model.mapper;

import com.ferreteria.productos.model.dto.ProductoRequest;
import com.ferreteria.productos.model.dto.ProductoResponse;
import com.ferreteria.productos.model.entity.ProductoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface ProductoMapper {

    ProductoEntity toEntity(ProductoRequest request);

    ProductoResponse toResponse(ProductoEntity entity);

    List<ProductoResponse> toResponseList(List<ProductoEntity> entities);

}