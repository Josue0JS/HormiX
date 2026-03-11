package com.example.Hormix.modelos;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "fecha")
    private java.time.LocalDate fecha;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "icono", length = 100)
    private String icono;
    
    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "metodo_pago", nullable = false, length = 100)
    private String metodoPago;

    @Column(name = "recurrente", nullable = false)
    private boolean recurrente;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estados estado;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;



    //Relacion con la tabla usuario
    //1 gasto 1 usuario
    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    //Relacion con la tabla categoria
    @OneToMany(mappedBy = "gasto")
    private List<Categoria> categorias;

    //relacion con la tabla comercio
    @OneToMany(mappedBy = "gasto")
    private List<Comercio> comercios;

    public Gasto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.time.LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(java.time.LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    
}
