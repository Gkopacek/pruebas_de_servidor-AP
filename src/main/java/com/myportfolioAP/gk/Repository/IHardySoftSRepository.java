
package com.myportfolioAP.gk.Repository;

import com.myportfolioAP.gk.Entity.HardySoftS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHardySoftSRepository extends JpaRepository<HardySoftS, Integer> {
    public Optional<HardySoftS> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
