package com.example.Hormix.controladores;

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

import com.example.Hormix.modelos.Comercio;
import com.example.Hormix.services.ComercioServicio;

@RestController
@RequestMapping("/hormixapi/v1/comercios")
public class ComercioControlador {

    //inyectar el servicio correspondiente
    @Autowired
    private ComercioServicio servicio;

    //para cada servicio ofrecido se debe programar una funcion
    //esa funcion recibira las peticiones del pedido y respondera

    //funcion controladora del servicio de guardar comercio
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }

    //funcion controladora del servicio de listar todos los comercios
    @GetMapping
    public ResponseEntity<?> controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Comercios()
        );
    }

    //funcion controladora del servicio modificar comercio
    @PostMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@RequestBody Comercio datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_comercio(datos.getId(), datos)
        );
    }

    //funcion controladora del servicio eliminar comercio
    @DeleteMapping("/{id}")
     public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_comercio(id)
        );
    }

    //funcion controladora del servicio buscarPorId comercio
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.buscar_por_id(id)
        );
    }
}
