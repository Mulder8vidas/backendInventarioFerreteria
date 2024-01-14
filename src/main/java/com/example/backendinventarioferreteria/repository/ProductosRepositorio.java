package com.example.backendinventarioferreteria.repository;
import com.example.backendinventarioferreteria.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepositorio extends JpaRepository<Productos,Long> {
    @Query("""
            select p from Productos p
            where upper(p.nombre) like upper(concat('%', ?1, '%')) or upper(p.marca) like upper(concat('%', ?2, '%'))""")
    List<Productos> findByNombreContainsIgnoreCaseOrMarcaContainsIgnoreCase(String nombre, String marca);
}
