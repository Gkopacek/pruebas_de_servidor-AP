package com.myportfolioAP.gk.Service;

import com.myportfolioAP.gk.Entity.HardySoftS;
import com.myportfolioAP.gk.Repository.IHardySoftSRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardySoftS_Service {

    @Autowired IHardySoftSRepository ShYs;
    
    public List<HardySoftS> list(){
    return ShYs.findAll();
    }

public Optional<HardySoftS> getOne(int id){
    return ShYs.findById(id);
    }

public Optional<HardySoftS> getByNombre(String nombre){
    return ShYs.findByNombre(nombre);
    }

public void save(HardySoftS hardySoftS){
    ShYs.save(hardySoftS);
}

public void delete(int id){
    ShYs.deleteById(id);
}

public boolean existsById(int id){
    return ShYs.existsById(id);
}

public boolean existsByNombre(String nombre){
    return ShYs.existsByNombre(nombre);
}
}

