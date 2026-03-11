package com.example.Hormix.modelos;

import com.example.Hormix.modelos.utils.Estados;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, unique = false, length = 100)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = true, unique = false)
    private java.time.LocalDate fechaCreacion;
    
    @Column(name = "responsable", nullable = true, unique = false, length = 100)
    private String responsable;
    
    @Column(name = "justificacion", nullable = true, unique = false, length = 200)
    private String justificacion;
    
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    
    @Column(name = "presupuesto_limite")
    private double presupuestoLimite;
    
    @Column(name = "gasto_actual")
    private double gastoActual;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estados estado;
    
    @Column(name = "tipo", length = 100)
    private String tipo;

    //Relacion con la tabla gastos
    // muchos a 1 gastos
    @ManyToOne()
    @JoinColumn(name = "fk_gasto", referencedColumnName = "id")
    private Gasto gasto;

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


    public Estados getEstado() {
        return estado;
    }


    public void setEstado(Estados estado) {
        this.estado = estado;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    


}
