package com.example.Hormix.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Hormix.modelos.Comercio;
import com.example.Hormix.repositories.IComercioRepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;

    //Servicio para guardar un comercio
    public Comercio guardar_usuario(Comercio datosComercio){
        //validar la operacion que me estan pidiendo hacer
        if(datosComercio.getNombre() == null || datosComercio.getNombre().isBlank()
        || datosComercio.getNombre().isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }
        if(datosComercio.getNit().length()<5){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El Nit es invalido"
            );
        }

        //Despues de las validaciones, intento guardar los datos que me enviaron
        return repositorio.save(datosComercio);
    }

    //Servicio para listar todos los comercios en BD
    public List<Comercio> listar_Comercios(){
        return repositorio.findAll();
    }

}
