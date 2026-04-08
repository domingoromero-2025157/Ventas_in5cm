package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> getAllProductos();

    Producto getProductoById(Integer id);

    Producto saveProducto(Producto producto);

    Producto updateProducto(Integer id, Producto producto);

    void deleteProducto(Integer id);
}