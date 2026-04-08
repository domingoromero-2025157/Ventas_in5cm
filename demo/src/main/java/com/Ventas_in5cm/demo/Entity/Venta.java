package com.Ventas_in5cm.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @NotNull(message = "El campo no debe ir vacío")
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @NotNull(message = "El campo no debe ir vacío")
    @Column(name = "total")
    private Float total;

    @NotNull(message = "El campo no debe ir vacío")
    @Column(name = "estado")
    private Integer estado;

    @NotNull(message = "El campo no debe ir vacío")
    @Column(name = "clientes_dpi_cliente")
    private Integer clientesDpiCliente;

    @NotNull(message = "El campo no debe ir vacío")
    @Column(name = "usuarios_codigo_usuario")
    private Integer usuariosCodigoUsuario;

    // GETTERS Y SETTERS

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getClientesDpiCliente() {
        return clientesDpiCliente;
    }

    public void setClientesDpiCliente(Integer clientesDpiCliente) {
        this.clientesDpiCliente = clientesDpiCliente;
    }

    public Integer getUsuariosCodigoUsuario() {
        return usuariosCodigoUsuario;
    }

    public void setUsuariosCodigoUsuario(Integer usuariosCodigoUsuario) {
        this.usuariosCodigoUsuario = usuariosCodigoUsuario;
    }
}