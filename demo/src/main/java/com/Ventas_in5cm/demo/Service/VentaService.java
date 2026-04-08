package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> getAllVentas();

    Venta getVentasById(Integer id);

    Venta saveVentas(Venta venta);

    Venta updateVentas(Integer id, Venta venta);

    void deleteVentas(Integer id);
}