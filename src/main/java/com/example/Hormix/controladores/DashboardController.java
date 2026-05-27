package com.example.Hormix.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hormix.services.DashboardService;
import com.example.Hormix.dto.DashboardDTO;

@RestController
@RequestMapping("/hormixapi/v1/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats/{idUsuario}")
    public DashboardDTO getDashboardStats(
            @PathVariable Integer idUsuario) {

        return dashboardService.getDashboardStats(idUsuario);
    }
}