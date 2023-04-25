/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myportfolioAP.gk.Dto;

import javax.validation.constraints.NotBlank;



public class ProyectoDto {
    @NotBlank
    private String nombreProyect;
    
    @NotBlank
    private String descripcionProyect;
    
    @NotBlank
    private String imgProyect;

    public ProyectoDto() {
    }

    
public ProyectoDto(String nombreProyect, String descripcionProyect, String imgProyect){
    this.nombreProyect = nombreProyect;
    this.descripcionProyect = descripcionProyect;
    this.imgProyect = imgProyect;
}

    public String getNombreProyect() {
        return nombreProyect;
    }

    public void setNombreProyect(String nombreProyect) {
        this.nombreProyect = nombreProyect;
    }

    public String getDescripcionProyect() {
        return descripcionProyect;
    }

    public void setDescripcionProyect(String descripcionProyect) {
        this.descripcionProyect = descripcionProyect;
    }

    public String getImgProyect() {
        return imgProyect;
    }

    public void setImgProyect(String imgProyect) {
        this.imgProyect = imgProyect;
    }
    


}

