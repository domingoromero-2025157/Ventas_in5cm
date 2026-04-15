package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Ventas;

import java.util.List;

public interface VentaService {

    List<Ventas> getAllVentas();

    Ventas getVentasById(Integer id);

    Ventas saveVentas(Ventas venta);

    Ventas updateVentas(Integer id, Ventas venta);

    void deleteVentas(Integer id);
}