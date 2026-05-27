package com.example.Hormix.services;

import java.util.List;
import java.util.Optional;

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

    // servicio para guardar un usuario

    public Gasto guardar_gasto(Gasto datosGasto) {

        if (datosGasto.getNombre() == null || datosGasto.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre y la descripcion del gasto son obligatorios");
        }

        // Despues de las validaciones, intento guardar los datos que me enviaron

        if (datosGasto.getValor() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El valor del gasto debe ser mayor a cero");
        }

        return repositorio.save(datosGasto);
    }

    // servicio para listar todos los gastos en BD

    public List<Gasto> listar_Gastos() {
        return repositorio.findAll();
    }

    // servicio para eliminar un gasto en BD
    public boolean eliminar_gasto(Integer id) {
        Optional<Gasto> gastoBuscado = repositorio.findById(id);
        if (gastoBuscado.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El gasto no existe");
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }

    // servicio para modificar un gasto en BD
    public Gasto modificar_gasto(Integer id, Gasto datosGasto) {

    Optional<Gasto> gastoBuscado = repositorio.findById(id);

    if (gastoBuscado.isEmpty()) {

        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El gasto no existe");

    } else {

        Gasto gastoExistente = gastoBuscado.get();

        // Campos editables
        gastoExistente.setNombre(datosGasto.getNombre());
        gastoExistente.setDescripcion(datosGasto.getDescripcion());
        gastoExistente.setValor(datosGasto.getValor());
        gastoExistente.setFecha(datosGasto.getFecha());

        // ESTOS FALTABAN
        gastoExistente.setMetodoPago(datosGasto.getMetodoPago());
        gastoExistente.setCategoria(datosGasto.getCategoria());
        gastoExistente.setIcono(datosGasto.getIcono());
        gastoExistente.setIdUsuario(datosGasto.getIdUsuario());
        gastoExistente.setRecurrente(datosGasto.isRecurrente());
        gastoExistente.setEstado(datosGasto.getEstado());

        return repositorio.save(gastoExistente);
    }
}

    // servicio para buscar un gasto por BD
    public Gasto buscar_por_id(Integer id) {
        Optional<Gasto> gastoBuscado = repositorio.findById(id);
        if (gastoBuscado.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El gasto no existe");
        } else {
            return gastoBuscado.get();
        }
    }
}
