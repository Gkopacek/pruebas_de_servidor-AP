package com.myportfolioAP.gk.Controller;

import com.myportfolioAP.gk.Dto.PersonaDto;
import com.myportfolioAP.gk.Entity.Persona;
import com.myportfolioAP.gk.Security.Controller.Mensaje;
import com.myportfolioAP.gk.Service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://proyecto-final-ap-7a199.web.app"})
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    PersonaService pService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>>list(){
         List<Persona> list = pService.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    /*@PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
         if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(pService.existsByNombreEst(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);
    
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getCategoria(), personaDto.getBio(), personaDto.getImg());
        pService.save(persona);
        
        return new ResponseEntity(new Mensaje("persona creada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto personaDto){
        if(!pService.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(pService.existsByNombreEst(personaDto.getNombre()) && pService.getByNombreEst(personaDto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = pService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setCategoria(personaDto.getCategoria());
        persona.setBio(personaDto.getBio());
        persona.setImg(personaDto.getImg());
        
        pService.save(persona);
        return new ResponseEntity(new Mensaje("datos de la persona modificados"), HttpStatus.OK);
        }
    
     /*@DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!pService.existsById(id)) return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);

    pService.delete(id);

    return new ResponseEntity(new Mensaje("estudio eliminado"), HttpStatus.OK);
    }*/

@GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!pService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = pService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    
    


}           
