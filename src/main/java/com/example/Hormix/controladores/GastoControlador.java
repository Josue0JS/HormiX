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

import com.example.Hormix.Services.GastoServicio;
import com.example.Hormix.modelos.Gasto;

@RestController
@RequestMapping("/hormixapi/v1/gastos")
public class GastoControlador {


    @Autowired
    private GastoServicio servicio;

    //para cada servicio ofrecido se debe programar una funcion
    //esa funcion recibira las peticiones del pedido y respondera

    //Funcion controladora del servicio de guardar gasto
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Gasto datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_gasto(datos)
        );
    }

    //Funcion controladora del servicio de listar todos los gastos
    @GetMapping
    public ResponseEntity<?> controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Gastos()
        );
    }

    //funcion controladora del sevicio modificar gasto
    @PostMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id,@RequestBody Gasto datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_gasto(id, datos)
        );
    }

    //Funcion controladora del servicio eliminar gasto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_gasto(id)
        );
    }

    //funcion controladora del servicio de buscar gasto por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.buscar_por_id(id)
        );
    }
}
