package com.Ventas_in5cm.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotBlank(message = "El username no debe ir vacío")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "El password no debe ir vacío")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "El email no debe ir vacío")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "El rol no debe ir vacío")
    @Column(name = "rol")
    private String rol;

    @NotNull(message = "El estado no debe ir vacío")
    @Column(name = "estado")
    private Integer estado;

    // GETTERS Y SETTERS

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}