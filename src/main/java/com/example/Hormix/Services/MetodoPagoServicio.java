package com.example.Hormix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Hormix.modelos.MetodoPago;
import com.example.Hormix.repositories.IMetodoPagoRepositorio;

@Service
public class MetodoPagoServicio {

    @Autowired
    private IMetodoPagoRepositorio repositorio;

    // servicio para guardar metodo de pago
    public MetodoPago guardar_metodoPago(MetodoPago datosMetodoPago) {
        // Validar operacion
        if (datosMetodoPago.getNombre() == null || datosMetodoPago.getNombre().isBlank()
                || datosMetodoPago.getNombre().isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El metodo de pago es obligatorio");
        }
        if (datosMetodoPago.getFranquicia() == null || datosMetodoPago.getFranquicia().isBlank()
                || datosMetodoPago.getFranquicia().isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El metodo de pago es obligatorio");

        }
        // despues de las validaciones, intento guardar los datos que me enviaron
        return repositorio.save(datosMetodoPago);

    }

    // Servicio para listar todos los metodos de pago en BD
    public List<MetodoPago> Listar_MetodoPagos() {
        return repositorio.findAll();
    }

    // servicio para eliminar un metodo de pago en BD
    public boolean eliminar_metodoPago(Integer id) {

        Optional<MetodoPago> metodoPagoBuscado = repositorio.findById(id);

        if (metodoPagoBuscado.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El metodo de pago no existe");
        } else {
            repositorio.deleteById(id);
            return true;
        }
    }

    // servicio para modificar un metodo de pago en BD
    public MetodoPago modificar_metodoPago(Integer id, MetodoPago datos) {
        Optional<MetodoPago> metodoPagoBuscado = repositorio.findById(id);

        if (metodoPagoBuscado.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El metodo de pago no existe");
        } else {
            MetodoPago metodoPagoExistente = metodoPagoBuscado.get();
            // defino que campos voy a editar
            // cambiemos el metodo de pago
            metodoPagoExistente.setNombre(datos.getNombre());
            return repositorio.save(metodoPagoExistente);
        }
    }

    // servicio para buscar un metodo de pago en BD
    public MetodoPago buscar_por_id(Integer id) {
        Optional<MetodoPago> metodoPagoBuscado = repositorio.findById(id);
        if (metodoPagoBuscado.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El metodo de pago no existe");
        } else {
            return metodoPagoBuscado.get();
        }
    }
}
