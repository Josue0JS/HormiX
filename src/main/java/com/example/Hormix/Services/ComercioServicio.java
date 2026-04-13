package com.example.Hormix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hormix.repositories.IComercioRepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;

}
