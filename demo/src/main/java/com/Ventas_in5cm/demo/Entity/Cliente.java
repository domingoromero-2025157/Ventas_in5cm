package com.Ventas_in5cm.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpi_cliente")
    private Integer dpiCliente;

    @NotBlank(message = "El nombre no debe ir vacío")
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @NotBlank(message = "El apellido no debe ir vacío")
    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @NotBlank(message = "La dirección no debe ir vacía")
    @Column(name = "direccion")
    private String direccion;

    @NotNull(message = "El estado no debe ir vacío")
    @Column(name = "estado")
    private Integer estado;

    // GETTERS Y SETTERS

    public Integer getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(Integer dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}