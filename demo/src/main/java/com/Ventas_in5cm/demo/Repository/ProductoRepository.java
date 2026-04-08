package com.Ventas_in5cm.demo.Repository;

import com.Ventas_in5cm.demo.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}