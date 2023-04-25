/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myportfolioAP.gk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyect;
    private String descripcionProyect;
    private String imgProyect;

    
    public Proyecto() {
    }
    
    public Proyecto(String nombreProyect, String descripcionProyect, String imgProyect){
        this.nombreProyect = nombreProyect;
        this.descripcionProyect = descripcionProyect;
        this.imgProyect = imgProyect;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombreProyect(){
        return nombreProyect;
    }
    
    public void setNombreProyect(String nombreProyect){
        this.nombreProyect = nombreProyect;
    }
    
    public String getDescripcionProyect(){
        return descripcionProyect;
    }
    
    public void setDescripcionProyect(String descripcionProyect){
        this.descripcionProyect = descripcionProyect;
    }
    
    public String getImgProyect(){
        return imgProyect;
    }
    
    public void setImgProyect(String imgProyect){
        this.imgProyect = imgProyect;
    }
}

    
