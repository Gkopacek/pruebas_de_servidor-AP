package com.myportfolioAP.gk.Controller;

import com.myportfolioAP.gk.Dto.HardySoftSDTO;
import com.myportfolioAP.gk.Entity.HardySoftS;
import com.myportfolioAP.gk.Security.Controller.Mensaje;
import com.myportfolioAP.gk.Service.HardySoftS_Service;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "https://proyecto-final-ap-7a199.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class HardySoftS_Controller {
      @Autowired
      HardySoftS_Service HySS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HardySoftS>> list(){
        List<HardySoftS> list = HySS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody HardySoftSDTO dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(HySS.existsByNombre(dtoSkill.getNombre()))
            return new ResponseEntity(new Mensaje("la Skill ya existe"), HttpStatus.BAD_REQUEST);
        
        
         HardySoftS hardYsoft = new HardySoftS(dtoSkill.getNombre(), dtoSkill.getPorcentaje(), dtoSkill.getImg());
        HySS.save(hardYsoft);
        return new ResponseEntity(new Mensaje("la Skill fue agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HardySoftSDTO dtoSkill){
        if(!HySS.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(HySS.existsByNombre(dtoSkill.getNombre()) && HySS.getByNombre(dtoSkill.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("esta Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HardySoftS hardySoftS = HySS.getOne(id).get();
        hardySoftS.setNombre(dtoSkill.getNombre());
        hardySoftS.setPorcentaje((dtoSkill.getPorcentaje()));
        hardySoftS.setImg(dtoSkill.getImg());
        
        
        
        HySS.save(hardySoftS);
            return new ResponseEntity(new Mensaje("Skill modificada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!HySS.existsById(id)) return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        
        HySS.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
        }

@GetMapping("/detail/{id}")
    public ResponseEntity<HardySoftS> getById(@PathVariable("id") int id){
        if(!HySS.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HardySoftS hardySoftS = HySS.getOne(id).get();
        return new ResponseEntity(hardySoftS, HttpStatus.OK);
    }
}
