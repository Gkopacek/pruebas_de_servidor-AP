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
@CrossOrigin(origins = {"http://localhost:4200", "https://proyecto-final-ap-7a199.web.app"})
@RequestMapping("/skills")
public class HardySoftS_Controller {
      @Autowired
      HardySoftS_Service HySS;
      
    @GetMapping("/lista")
    public ResponseEntity<List<HardySoftS>> list(){
        List<HardySoftS> list = HySS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody HardySoftSDTO dtoSkill){
        System.out.println("se ejecuta la funcion crear desde el controlador de soft y hard skills");
        if(StringUtils.isBlank(dtoSkill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(HySS.existsByNombre(dtoSkill.getNombre()))
            return new ResponseEntity(new Mensaje("la Skill ya existe"), HttpStatus.BAD_REQUEST);
        
        if(dtoSkill.getPorcentaje()==101){
            return new ResponseEntity(new Mensaje("se esperaba un numero entero (0-100)"), HttpStatus.BAD_REQUEST);
        }
        
         HardySoftS hardYsoft = new HardySoftS(dtoSkill.getNombre(), dtoSkill.getPorcentaje(), dtoSkill.getImg());
        HySS.save(hardYsoft);
        return new ResponseEntity(new Mensaje("la Skill fue agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HardySoftSDTO dtoSkill){
        System.out.println("se ejecuta la funcion modificar desde el controlador de soft y hard skills");
        if(!HySS.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(HySS.existsByNombre(dtoSkill.getNombre()) && HySS.getByNombre(dtoSkill.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("esta Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
   
        /*        if(dtoSkill.getPorcentaje()==101){
        return new ResponseEntity(new Mensaje("se esperaba un numero entero (0-100)"), HttpStatus.BAD_REQUEST);
        }*/
        
        /*dtoSkill.getPorcentaje();*/
        
        /*String numeroPrueba = "prueba";*/
        
        /*dtoSkill.getPorcentaje()*/
        /*!Integer.class.isInstance(Integer.valueOf((porcentaje)))*/
        
        
        
        
        System.out.println(!Integer.class.isInstance(dtoSkill.getPorcentaje()));
        
        if(!Integer.class.isInstance(dtoSkill.getPorcentaje())){
            return new ResponseEntity(new Mensaje("se espera un numero entero"),HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoSkill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HardySoftS hardySoftS = HySS.getOne(id).get();
        hardySoftS.setNombre(dtoSkill.getNombre());
        hardySoftS.setPorcentaje(dtoSkill.getPorcentaje());
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
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        HardySoftS hardySoftS = HySS.getOne(id).get();
        return new ResponseEntity(hardySoftS, HttpStatus.OK);
    }
}
