/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myportfolioAP.gk.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myportfolioAP.gk.Entity.Proyecto;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombreProyect(String NombreProyect);
    
    public boolean existsByNombreProyect(String NombreProyect);
}




