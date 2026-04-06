package com.example.Hormix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hormix.modelos.MetodoPago;

@Repository
public interface IMetodoPagoRepositorio extends JpaRepository <MetodoPago, Integer>{

}
