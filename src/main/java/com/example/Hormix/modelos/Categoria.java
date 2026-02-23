package com.example.Hormix.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private java.time.LocalDate fechaCreacion;
    private String responsable;
    private String justificacion;
    private String descripcion;
    private double presupuestoLimite;
    private double gastoActual;
    private String estado;
    private String tipo;


    public Categoria() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public java.time.LocalDate getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(java.time.LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public String getResponsable() {
        return responsable;
    }


    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }


    public String getJustificacion() {
        return justificacion;
    }


    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPresupuestoLimite() {
        return presupuestoLimite;
    }


    public void setPresupuestoLimite(double presupuestoLimite) {
        this.presupuestoLimite = presupuestoLimite;
    }


    public double getGastoActual() {
        return gastoActual;
    }


    public void setGastoActual(double gastoActual) {
        this.gastoActual = gastoActual;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    


}
