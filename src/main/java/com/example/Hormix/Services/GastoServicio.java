package com.example.Hormix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hormix.repositories.IGastoRepositorio;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;
}
