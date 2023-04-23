
package com.myportfolioAP.gk.Repository;

import com.myportfolioAP.gk.Entity.Estudios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudiosRepository extends JpaRepository<Estudios, Integer> {
        public Optional<Estudios> findByNombreEst(String NombreEst);
    
    public boolean existsByNombreEst(String NombreEst);
}
