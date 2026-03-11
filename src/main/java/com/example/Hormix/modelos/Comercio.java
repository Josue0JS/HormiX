package com.example.Hormix.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "comercio")
public class Comercio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nit", nullable = false, unique = true, length = 20)
    private String nit;

    @Column(name = "nombre", nullable = true, unique = false, length = 100)
    private String nombre;

    @Column(name = "actividad", nullable = true, unique = false, length = 100)
    private String actividad;

    @Column(name = "contacto", nullable = true, unique = false, length = 100)
    private String contacto;

    @Column(name = "direccion", nullable = true, unique = false, length = 200)
    private String direccion;

    @Column(name = "telefono", nullable = true, unique = false, length = 20)
    private String telefono;

    @Column(name = "correo", nullable = true, unique = false, length = 100)
    private String correo;

    @Column(name = "ciudad", nullable = true, unique = false, length = 100)
    private String ciudad;

    @Column(name = "activo", nullable = false)
    private boolean activo;


    //Relacion con la tabla gastos
    @JoinColumn(name = "fk_gasto", referencedColumnName = "id")
    private Gasto gasto;

    public Comercio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
