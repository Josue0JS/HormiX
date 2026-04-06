package com.example.Hormix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hormix.modelos.Comercio;

@Repository
public interface IComercioRepositorio extends JpaRepository <Comercio, Integer> {

    //GUARDAR
    //BUSCAR POR ID
    //BUSCAR TODOS LOS REGISTROS
    //MODIFICAR POR ID
    //ELIMINAR POR ID
}
