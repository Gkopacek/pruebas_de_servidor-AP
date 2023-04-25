/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myportfolioAP.gk.Controller;

import com.myportfolioAP.gk.Dto.ProyectoDto;
import com.myportfolioAP.gk.Entity.Proyecto;
import com.myportfolioAP.gk.Security.Controller.Mensaje;
import com.myportfolioAP.gk.Service.ProyectoService;
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
@RequestMapping("/proyectos")
public class ProyectoController {
    @Autowired
    ProyectoService proService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>>list(){
        List<Proyecto> list = proService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
        if(StringUtils.isBlank(proyectoDto.getNombreProyect())){
            return new ResponseEntity(new Mensaje("El nombre del proyecto realizado es obligatorio"), HttpStatus.BAD_REQUEST);
        }
            
        if(proService.existsByNombreProyect(proyectoDto.getNombreProyect()))
            return new ResponseEntity(new Mensaje("El nombre que intentas colocar al proyecto ya esta usado"), HttpStatus.BAD_REQUEST);

        
        Proyecto proyecto = new Proyecto(proyectoDto.getNombreProyect(), proyectoDto.getDescripcionProyect(), proyectoDto.getImgProyect());
        proService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("proyecto añadido"), HttpStatus.OK);
        
    }
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto){
        if(!proService.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(proService.existsByNombreProyect(proyectoDto.getNombreProyect())&&proService.getByNombreProyect(proyectoDto.getNombreProyect()).get().getId() != id){
            return new ResponseEntity(new Mensaje("el nombre del proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(proyectoDto.getNombreProyect()))
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = proService.getOne(id).get();
        proyecto.setNombreProyect(proyectoDto.getNombreProyect());
        proyecto.setDescripcionProyect(proyectoDto.getDescripcionProyect());
        proyecto.setImgProyect(proyectoDto.getImgProyect());
        
        proService.save(proyecto);
        return new ResponseEntity(new Mensaje("Se modificó la informacion del proyecto"),HttpStatus.OK);
        
}
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id del proyecto no existe"), HttpStatus.BAD_GATEWAY);
        }
        proService.delete(id);
        return new ResponseEntity(new Mensaje("el proyecto se eliminó correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id del proyecto no existe"), HttpStatus.NOT_FOUND);
        }
            Proyecto proyecto = proService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
        

}

