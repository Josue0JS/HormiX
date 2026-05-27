package com.example.Hormix.dto;

import java.util.List;

import com.example.Hormix.modelos.Gasto;

public class DashboardDTO {

    private Double totalExpenses;

    private List<Object[]> categories;

    private List<Object[]> monthlyExpenses;

    private List<Gasto> recentTransactions;

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public List<Object[]> getCategories() {
        return categories;
    }

    public void setCategories(List<Object[]> categories) {
        this.categories = categories;
    }

    public List<Object[]> getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(List<Object[]> monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public List<Gasto> getRecentTransactions() {
        return recentTransactions;
    }

    public void setRecentTransactions(List<Gasto> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }
}