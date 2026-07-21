package com.ferreteria.inventario.repository;

import com.ferreteria.inventario.model.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {

    Optional<InventarioEntity> findByProductoId(Long productoId);

}