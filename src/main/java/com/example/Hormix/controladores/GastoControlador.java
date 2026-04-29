package com.example.Hormix.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    //Guardar un nuevo gasto
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Gasto gasto){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(
                servicio.guardar_usuarioGasto(gasto)
            );
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                "Error al guardar el gasto");
        }
    }

    //Listar todos los gastos
    @GetMapping
    public ResponseEntity<?> controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Gastos()
        );
    }
}
