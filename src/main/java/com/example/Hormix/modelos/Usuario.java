package com.example.Hormix.modelos;

import java.util.List;

import com.example.Hormix.modelos.utils.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres_Completos", nullable = false, unique = false, length = 50)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, unique = false, length = 50)
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false)
    private TipoDocumento tipodoc;

    @Column(name = "documento", nullable = false, unique = true, length = 15)
    private String documento;

    @Column(name = "edad", nullable = true)
    private Integer edad;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "telefono", nullable = true, unique = false, length = 15)
    private String telefono;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "saldo_disponible", nullable = true, unique = true)
    private double saldoDisponible;

    @Column(name = "fecha_registro")
    private java.time.LocalDate fechaRegistro;

    //Creando la primera relacion con la tabla gastos
    //1 usuario muchos gastos
    
    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;


    //Relacion con la tabla metodoPago

    @OneToMany(mappedBy = "usuario")
    private List<MetodoPago> metodoPago;
    
    public Usuario() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDocumento tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public java.time.LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(java.time.LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    

    


}
