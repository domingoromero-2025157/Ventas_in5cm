package com.Ventas_in5cm.demo.Repository;

import com.Ventas_in5cm.demo.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Ventas, Integer> {
}