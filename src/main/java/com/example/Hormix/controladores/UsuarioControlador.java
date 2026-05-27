package com.example.Hormix.controladores;

import com.example.Hormix.modelos.Usuario;
import com.example.Hormix.services.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hormixapi/v1/usuarios")
public class UsuarioControlador {

    //inyectar el servicio correspondiente
    @Autowired
    private UsuarioServicio servicio;

    //para cada servicio ofrecido se debe programar una funcion
    //esa funcion recibira las peticiones del pedido y respondera

    //funcion controladora del servicio de guardar usuario
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );

    }

    //funcion controladora del servicio de listar todos los usuarios
    @GetMapping 
    public ResponseEntity<?> controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Usuarios()
        );
    }

    //funcion controladora del servicio modificar
    @PostMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id,@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_usuario(id, datos)
        );
    }

    //funcion controladora del sercivio eliminar
    @DeleteMapping("/{id}")
     public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_usuario(id)
        );
    }

    //funcion controladora del servicio buscarPorId
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.buscar_por_id(id)
        );
    }
    
}
