package com.example.Hormix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hormix.modelos.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository <Usuario, Integer> {

    //GUARDAR
    //BUSCAR POR ID
    //BUSCAR TODOS LOS REGISTROS
    //MODIFICAR POR ID
    //ELIMINAR POR ID

    //buscar por nombre exacto (lista)
    List<Usuario> findByNombre(String nombre);

    //buscar por documento (1)
    //Optional<Usuario> findById(String documento);


    //buscar por nombres que contengan nnn (lista)
    List<Usuario> findByNombreContaining(String nombre);

    
    //buscar por edad (lista)
    List<Usuario> findByEdad(Integer edad);

}
