package com.example.Hormix.services;

import java.util.List;
import java.util.Optional;

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

    //servicio para eliminar un comercio en BD
    public boolean eliminar_comercio(Integer id){
        Optional<Comercio> comercioBuscado=repositorio.findById(id);
        if(comercioBuscado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El comercio no existe"
            );
        } else{
            repositorio.deleteById(id);
            return true;
        }
    }

    //Servicio para modificar un comercio en BD
    public Comercio modificar_comercio(Integer id, Comercio datosComercio){
        Optional<Comercio> comercioBuscado=repositorio.findById(id);
        if(comercioBuscado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El comercio no existe"
            );
        } else{
            Comercio comercioModificado=comercioBuscado.get();
            //defino que campos voy a editar
            comercioModificado.setNombre(datosComercio.getNombre());
            comercioModificado.setNit(datosComercio.getNit());
            comercioModificado.setGasto(datosComercio.getGasto());
            return repositorio.save(comercioModificado);
        }
    }

    //servicio para buscar un comercio por BD
    public Comercio buscar_por_id(Integer id){
        Optional<Comercio> comercioBuscado=repositorio.findById(id);
        if(comercioBuscado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El comercio no existe"
            );
        } else{
            return comercioBuscado.get();
        }
    }
}
