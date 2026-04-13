package com.example.Hormix.Services;

import java.lang.module.ResolutionException;
import java.util.List;

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
    //servicio para guardar metodo de pago
    public MetodoPago guardar_metodopago(MetodoPago datosMetodoPago){
        //Validar operacion 
        if (datosMetodoPago.getNombre() == null || datosMetodoPago.getNombre().isBlank()
        || datosMetodoPago.getNombre().isEmpty()) {
            
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El metodo de pago es obligatorio"
            );
        }
        if (datosMetodoPago.getFranquicia() == null || datosMetodoPago.getFranquicia().isBlank()
        || datosMetodoPago.getFranquicia().isEmpty()) {
            
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El metodo de pago es obligatorio"
            );
            
        }
        return repositorio.save(datosMetodoPago);

    }

    public List<MetodoPago> Listar_MetodoPagos(){
        return repositorio.findAll();
    }
}
