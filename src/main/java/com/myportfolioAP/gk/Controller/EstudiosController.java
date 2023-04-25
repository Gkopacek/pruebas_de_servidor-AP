/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myportfolioAP.gk.Controller;

import com.myportfolioAP.gk.Dto.EstudiosDto;
import com.myportfolioAP.gk.Entity.Estudios;
import com.myportfolioAP.gk.Security.Controller.Mensaje;
import com.myportfolioAP.gk.Service.EstudiosService;
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
@RequestMapping("/estudios")
public class EstudiosController {
    @Autowired
    EstudiosService eService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>>list(){
         List<Estudios> list = eService.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    //public ResponseEntity<?> create(@RequestBody ExperienciaDto dtoExpe)
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EstudiosDto estudiosDto){
         if(StringUtils.isBlank(estudiosDto.getNombreEst()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(eService.existsByNombreEst(estudiosDto.getNombreEst()))
            return new ResponseEntity(new Mensaje("el estudio ya existe"), HttpStatus.BAD_REQUEST);
    
        Estudios estudios = new Estudios(estudiosDto.getNombreEst(), estudiosDto.getDescripcionEst(), estudiosDto.getUrlImg());
        eService.save(estudios);
        
        return new ResponseEntity(new Mensaje("estudio añadido"), HttpStatus.OK);
    }
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EstudiosDto estudiosDto){
        if(!eService.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(eService.existsByNombreEst(estudiosDto.getNombreEst()) && eService.getByNombreEst(estudiosDto.getNombreEst()).get().getId() != id){
            return new ResponseEntity(new Mensaje("este estudio ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(estudiosDto.getNombreEst()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudios estudios = eService.getOne(id).get();
        estudios.setNombreEst(estudiosDto.getNombreEst());
        estudios.setDescripcionEst(estudiosDto.getDescripcionEst());
        estudios.setUrlImg(estudiosDto.getUrlImg());
        
        eService.save(estudios);
        return new ResponseEntity(new Mensaje("estudio modificado"), HttpStatus.OK);
        }
    
     @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!eService.existsById(id)) return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);

    eService.delete(id);

    return new ResponseEntity(new Mensaje("estudio eliminado"), HttpStatus.OK);
    }

@GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){
        if(!eService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudios estudios = eService.getOne(id).get();
        return new ResponseEntity(estudios, HttpStatus.OK);
    }

}
