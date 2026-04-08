package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.DetalleVenta;
import java.util.List;

public interface DetalleVentaService {

    List<DetalleVenta> getAll();

    DetalleVenta getById(Integer id);

    DetalleVenta save(DetalleVenta detalleVenta);

    DetalleVenta update(Integer id, DetalleVenta detalleVenta);

    void delete(Integer id);
}