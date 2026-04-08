package com.Ventas_in5cm.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_productos")
    private Integer codigoProductos;

    @NotBlank(message = "El nombre no debe ir vacío")
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull(message = "El precio no debe ir vacío")
    @Column(name = "precio")
    private Double precio;

    @NotNull(message = "El stock no debe ir vacío")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "El estado no debe ir vacío")
    @Column(name = "estado")
    private Integer estado;

    // GETTERS Y SETTERS

    public Integer getCodigoProductos() {
        return codigoProductos;
    }

    public void setCodigoProductos(Integer codigoProductos) {
        this.codigoProductos = codigoProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}