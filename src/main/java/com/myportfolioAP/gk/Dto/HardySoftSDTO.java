
package com.myportfolioAP.gk.Dto;

import javax.validation.constraints.NotBlank;


public class HardySoftSDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    @NotBlank
    private String img;

    
    HardySoftSDTO(String nombre, int porcentaje, String img){
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }
    
    /*        public HardySoftSDTO(String nombre, String porcentaje, String img) {
    try {
    this.nombre = nombre;
    this.porcentaje = Integer.parseInt(porcentaje);
    this.img = img;
    } catch (Exception e) {
    System.out.println("error:" + e);
    this.porcentaje = 101;
    }
    }*/
    
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    } 
    
}
