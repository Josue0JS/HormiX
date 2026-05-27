package com.example.Hormix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hormix.dto.DashboardDTO;
import com.example.Hormix.modelos.Gasto;
import com.example.Hormix.repositories.IGastoRepositorio;

@Service
public class DashboardService {

    @Autowired
    private IGastoRepositorio gastoRepository;

    public DashboardDTO getDashboardStats(Integer idUsuario) {

        DashboardDTO dashboard = new DashboardDTO();

        // Total gastos
        Double totalExpenses = gastoRepository.getTotalExpenses(idUsuario);

        // Categorías
        List<Object[]> categories =
                gastoRepository.getExpensesByCategory(idUsuario);

        // Gastos mensuales
        List<Object[]> monthlyExpenses =
                gastoRepository.getMonthlyExpenses(idUsuario);

        // Últimos movimientos
        List<Gasto> recentTransactions =
                gastoRepository.findTop5ByIdUsuarioOrderByFechaDesc(idUsuario);

        dashboard.setTotalExpenses(totalExpenses);
        dashboard.setCategories(categories);
        dashboard.setMonthlyExpenses(monthlyExpenses);
        dashboard.setRecentTransactions(recentTransactions);

        return dashboard;
    }
}
