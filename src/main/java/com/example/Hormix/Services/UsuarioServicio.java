package com.example.Hormix.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Hormix.modelos.Usuario;
import com.example.Hormix.repositories.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    //servicio para guardar un usuario
    public Usuario guardar_usuario(Usuario datosUsuario){
        //Validar la operacion que me estan pidiendo hacer
        if(datosUsuario.getNombre() == null || datosUsuario.getNombre().isBlank() 
            || datosUsuario.getNombre().isEmpty()){

                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre de usuario es obligatorio"
                );
        }
        
        if(datosUsuario.getDocumento().length()<5){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El documento es invalido"
            );
        }

        //Despues de las validaciones, intento guardar los datos que me enviaron
        return repositorio.save(datosUsuario);
        
    }

    //servicio para listar todos los usuarios en BD
    public List<Usuario> listar_Usuarios(){
        return repositorio.findAll();
    }

    //servicio para elimiar un usuario en BD
    public boolean eliminar_usuario(Integer id){

        Optional<Usuario> usuarioBuscado=repositorio.findById(id);

        if(usuarioBuscado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario no existe"
            );
        } else{
            repositorio.deleteById(id);
            return true;
        }
    }

    //servicio para modificar un usuario en BD
    public Usuario modificar_usuario(Integer id, Usuario datosNuevos){
        Optional<Usuario> usuarioBuscado=repositorio.findById(id);
        if(usuarioBuscado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario no existe");
        } else{
            Usuario usuarioExistente=usuarioBuscado.get();
            //defino que campos voy a editar
            //cambiemos el nombre
            usuarioExistente.setNombre(datosNuevos.getNombre());
            return repositorio.save(usuarioExistente);
        }

    }

    //servicio para buscar un usuario por BD
    public Usuario buscar_por_id(Integer id){
        Optional<Usuario> usuarioBuscado=repositorio.findById(id);
        if(usuarioBuscado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario no existe");
        } else{
            return usuarioBuscado.get();
        }
    }

}
