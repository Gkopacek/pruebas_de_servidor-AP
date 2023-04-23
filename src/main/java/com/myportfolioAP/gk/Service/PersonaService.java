/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myportfolioAP.gk.Service;
import com.myportfolioAP.gk.Entity.Persona;
import com.myportfolioAP.gk.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guille
 */
@Service
@Transactional
public class PersonaService{
    @Autowired IPersonaRepository iPersonaR;
    
    public List<Persona> list(){
    return iPersonaR.findAll();
    }

public Optional<Persona> getOne(int id){
    return iPersonaR.findById(id);
    }

public Optional<Persona> getByNombreEst(String nombre){
    return iPersonaR.findByNombre(nombre);
    }

public void save(Persona persona){
    iPersonaR.save(persona);
}

public void delete(int id){
    iPersonaR.deleteById(id);
}

public boolean existsById(int id){
    return iPersonaR.existsById(id);
}

public boolean existsByNombreEst(String nombre){
    return iPersonaR.existsByNombre(nombre);
}
}


