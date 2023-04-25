/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myportfolioAP.gk.Service;

import com.myportfolioAP.gk.Entity.Proyecto;
import com.myportfolioAP.gk.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository iproR;

public List<Proyecto> list(){
    return iproR.findAll();
}

public Optional<Proyecto> getOne(int id){
    return iproR.findById(id);
}

public Optional<Proyecto> getByNombreProyect(String nombreProyect){
    return iproR.findByNombreProyect(nombreProyect);
}

public void save(Proyecto proyecto){
    iproR.save(proyecto);
}

public void delete(int id){
    iproR.deleteById(id);
}

public boolean existsById(int id){
    return iproR.existsById(id);
}

public boolean existsByNombreProyect(String nombreProyect){
    return iproR.existsByNombreProyect(nombreProyect);
}

}

