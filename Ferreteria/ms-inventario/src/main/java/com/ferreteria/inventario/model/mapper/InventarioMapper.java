package com.ferreteria.inventario.model.mapper;

import com.ferreteria.inventario.model.dto.InventarioRequest;
import com.ferreteria.inventario.model.dto.InventarioResponse;
import com.ferreteria.inventario.model.entity.InventarioEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface InventarioMapper {

    InventarioEntity toEntity(InventarioRequest request);

    InventarioResponse toResponse(InventarioEntity entity);

    List<InventarioResponse> toResponseList(List<InventarioEntity> entities);

}