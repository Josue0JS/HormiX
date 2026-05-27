package com.example.Hormix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hormix.modelos.Gasto;

@Repository
public interface IGastoRepositorio extends JpaRepository<Gasto, Integer> {

    
    // TOTAL DE GASTOS
    @Query("""
        SELECT SUM(g.valor)
        FROM Gasto g
        WHERE g.idUsuario = :idUsuario
    """)
    Double getTotalExpenses(@Param("idUsuario") Integer idUsuario);



    // GASTOS POR CATEGORÍA
    @Query("""
        SELECT g.categoria, SUM(g.valor)
        FROM Gasto g
        WHERE g.idUsuario = :idUsuario
        GROUP BY g.categoria
        ORDER BY SUM(g.valor) DESC
    """)
    List<Object[]> getExpensesByCategory(@Param("idUsuario") Integer idUsuario);



    // GASTOS POR MES
    @Query("""
        SELECT MONTH(g.fecha), SUM(g.valor)
        FROM Gasto g
        WHERE g.idUsuario = :idUsuario
        GROUP BY MONTH(g.fecha)
        ORDER BY MONTH(g.fecha)
    """)
    List<Object[]> getMonthlyExpenses(@Param("idUsuario") Integer idUsuario);



    // ÚLTIMOS 5 GASTOS
    List<Gasto> findTop5ByIdUsuarioOrderByFechaDesc(Integer idUsuario);

}
