package com.example.Hormix.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Hormix.modelos.Categoria;
import com.example.Hormix.repositories.ICategoriaRepositorio;

@Service
public class CategoriaServicio {

    @Autowired
    private ICategoriaRepositorio repositorio;

    public Categoria guardaCategoria(Categoria datosCategoria){
         if (datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank()
        || datosCategoria.getNombre().isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoria es obligatorio"
            ); 
    }

    if (datosCategoria.getDescripcion().length() < 7) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "La descripcion de la categoria es muy corta"
        );
     }

     return repositorio.save(datosCategoria);
        
    
    }
        // servicio para listar todas las categorias en BD
    public List<Categoria> listarCategorias(){
        return repositorio.findAll();   


    }

}
