
package com.myportfolioAP.gk.Service;

import com.myportfolioAP.gk.Entity.Experiencia;
import com.myportfolioAP.gk.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository iexpR;

public List<Experiencia> list(){
    return iexpR.findAll();
    }

public Optional<Experiencia> getOne(int id){
    return iexpR.findById(id);
    }

public Optional<Experiencia> getByNombreE(String nombreE){
    return iexpR.findByNombreE(nombreE);
    }

public void save(Experiencia experiencia){
    iexpR.save(experiencia);
}

public void delete(int id){
    iexpR.deleteById(id);
}

public boolean existsById(int id){
    return iexpR.existsById(id);
}

public boolean existsByNombreE(String nombreE){
    return iexpR.existsByNombreE(nombreE);
}
}


