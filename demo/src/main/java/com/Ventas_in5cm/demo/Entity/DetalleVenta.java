package com.Ventas_in5cm.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigoDetalleVenta;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull
    @Column(name = "subtotal")
    private Double subtotal;

    // 🔥 RELACIÓN CON PRODUCTO
    @ManyToOne
    @JoinColumn(name = "Productos_codigos_producto") // EXACTO como tu BD
    private Producto producto;

    // 🔥 RELACIÓN CON CLIENTE
    @ManyToOne
    @JoinColumn(name = "Clientes_dpi_cliente")
    private Cliente cliente;

    // 🔥 RELACIÓN CON USUARIO
    @ManyToOne
    @JoinColumn(name = "usuarios_codigo_usuario")
    private Usuario usuario;

    // 🔥 RELACIÓN CON VENTA
    @ManyToOne
    @JoinColumn(name = "Ventas_codigo_venta")
    private Venta venta;

    // GETTERS Y SETTERS

    public Integer getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}