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

import com.example.Hormix.Services.MetodoPagoServicio;
import com.example.Hormix.modelos.MetodoPago;

@RestController
@RequestMapping("/hormixapi/v1/metodopago")
public class MetodoPagoControlador {

    // inyectar el servicio correspondiente
    @Autowired
    private MetodoPagoServicio servicio;

    // para cada servicio ofrecido se debe programar una funcion
    // esa funcion recibira las peticiones del pedido y respondera

    // funcion controladora del servicio de guardar metodo de pago
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody MetodoPago datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.guardar_metodoPago(datos));
    }

    //funcion controladora del servicio modificar
    @PostMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id,@RequestBody MetodoPago datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_metodoPago(id, datos)
        );
    }

    //funcion controladora del servicio eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_metodoPago(id)
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
 