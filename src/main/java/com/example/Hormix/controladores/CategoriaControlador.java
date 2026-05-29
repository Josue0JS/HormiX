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

import com.example.Hormix.modelos.Categoria;
import com.example.Hormix.services.CategoriaServicio;

@RestController
@RequestMapping("/hormixapi/v1/categorias")
public class CategoriaControlador {

    // inyectar el servicio correspondiente
    @Autowired
    private CategoriaServicio servicio;

    // para cada servicio ofrecido se debe programar una funcion
    // esa funcion recibira las peticiones del pedido y respondera

    // funcion controladora del servicio de guardar categoria
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Categoria datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.guardaCategoria(datos));
    }

    // funcion controladora del servicio de listar todas las categorias
    @GetMapping
    public ResponseEntity<?> controladorListarTodo() {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.listarCategorias());
    }

    // funcion controladora del servicio modificar categoria
    @PostMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Categoria datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.modificarCategoria(id, datos));
    }

    // funcion controladora del servicio eliminar categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.eliminarCategoria(id));
    }

    // funcion controladora del servicio buscarPorId categoria
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                servicio.buscar_por_id(id));
    }
}
