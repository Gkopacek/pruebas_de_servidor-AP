package com.myportfolioAP.gk.Controller;

import com.myportfolioAP.gk.Dto.ExperienciaDto;
import com.myportfolioAP.gk.Entity.Experiencia;
import com.myportfolioAP.gk.Security.Controller.Mensaje;
import com.myportfolioAP.gk.Service.ExperienciaService;
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
@RequestMapping("explaboral")
@CrossOrigin(origins = "https://proyecto-final-ap-7a199.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ExperienciaService expS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = expS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto dtoExpe){
        if(StringUtils.isBlank(dtoExpe.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expS.existsByNombreE(dtoExpe.getNombreE()))
            return new ResponseEntity(new Mensaje("la experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        
         Experiencia experiencia = new Experiencia(dtoExpe.getNombreE(), dtoExpe.getDescripcionE(), dtoExpe.getUrlImg());
        expS.save(experiencia);
        return new ResponseEntity(new Mensaje("la Experiencia fue agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto dtoExpe){
        if(!expS.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(expS.existsByNombreE(dtoExpe.getNombreE()) && expS.getByNombreE(dtoExpe.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("esta Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExpe.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = expS.getOne(id).get();
        experiencia.setNombreE(dtoExpe.getNombreE());
        experiencia.setDescripcionE((dtoExpe.getDescripcionE()));
        experiencia.setUrlImg(dtoExpe.getUrlImg());
        
        
        
        expS.save(experiencia);
            return new ResponseEntity(new Mensaje("Experiencia modificada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!expS.existsById(id)) return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        
        expS.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
        }

@GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expS.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expS.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

}
