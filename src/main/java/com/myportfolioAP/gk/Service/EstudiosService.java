
package com.myportfolioAP.gk.Service;

import com.myportfolioAP.gk.Entity.Estudios;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import com.myportfolioAP.gk.Repository.IEstudiosRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstudiosService {
    @Autowired
    IEstudiosRepository iEstudiosR;
    
    public List<Estudios> list(){
    return iEstudiosR.findAll();
    }

public Optional<Estudios> getOne(int id){
    return iEstudiosR.findById(id);
    }

public Optional<Estudios> getByNombreEst(String nombreEst){
    return iEstudiosR.findByNombreEst(nombreEst);
    }

public void save(Estudios estudios){
    iEstudiosR.save(estudios);
}

public void delete(int id){
    iEstudiosR.deleteById(id);
}

public boolean existsById(int id){
    return iEstudiosR.existsById(id);
}

public boolean existsByNombreEst(String nombreEst){
    return iEstudiosR.existsByNombreEst(nombreEst);
}
}

    

