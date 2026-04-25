package com.example.Hormix.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Hormix.modelos.Gasto;
import com.example.Hormix.repositories.IGastoRepositorio;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;

        //servicio para guardar un usuario


    public Gasto guardar_usuarioGasto(Gasto datosGasto){

        if(datosGasto.getDescripcion() == null || datosGasto.getDescripcion().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripcion del gasto es obligatoria"
            );
        }

                //Despues de las validaciones, intento guardar los datos que me enviaron

        
        if(datosGasto.getValor() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El valor del gasto debe ser mayor a cero"
            );
        }

        return repositorio.save(datosGasto);
    }

        //servicio para listar todos los usuarios en BD


    public List<Gasto> listar_Gastos(){
        return repositorio.findAll(); 
    }
        //servicio para elimiar un usuario en BD

    //servicio para modificar un usuario en BD

    //servicio para buscar un usuario por BD
}
