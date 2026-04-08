package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Producto;
import com.Ventas_in5cm.demo.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, Producto producto) {
        Producto existente = getProductoById(id);

        existente.setNombreProducto(producto.getNombreProducto());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setEstado(producto.getEstado());

        return productoRepository.save(existente);
    }

    @Override
    public void deleteProducto(Integer id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no existe");
        }
        productoRepository.deleteById(id);
    }
}