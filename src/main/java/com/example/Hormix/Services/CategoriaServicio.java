package com.example.Hormix.services;

import java.util.List;
import java.util.Optional;

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

    // servicio para guardar una categoria
    public Categoria guardaCategoria(Categoria datosCategoria) {
        if (datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank()
                || datosCategoria.getNombre().isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre de la categoria es obligatorio");
        }

        if (datosCategoria.getDescripcion().length() < 7) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La descripcion de la categoria es muy corta");
        }

        // despues de las validaciones, intento guardar los datos que me enviaron
        return repositorio.save(datosCategoria);

    }

    // servicio para listar todas las categorias en BD
    public List<Categoria> listarCategorias() {
        return repositorio.findAll();
    }

    // servicio para eliminar un usuario en BD
    public boolean eliminarCategoria(Integer id) {

        Optional<Categoria> categoriaBuscada = repositorio.findById(id);

        if (categoriaBuscada.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La categoria no existe");
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }

    // servicio para modificar una categoria en BD
    public Categoria modificarCategoria(Integer id, Categoria datosCategoria) {
        Optional<Categoria> categoriaBuscada = repositorio.findById(id);
        if (categoriaBuscada.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La categoria no existe");
        } else {
            Categoria categoriaModificada = categoriaBuscada.get();
            // defino que campos voy a editar
            categoriaModificada.setNombre(datosCategoria.getNombre());
            categoriaModificada.setDescripcion(datosCategoria.getDescripcion());
            return repositorio.save(categoriaModificada);
        }
    }

    //servicio para buscar un usuario por BD
    public Categoria buscar_por_id(Integer id){
        Optional<Categoria> categoriaBuscada=repositorio.findById(id);
        if(categoriaBuscada.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La categoria no existe");
        } else{
            return categoriaBuscada.get();
        }
    }
}
