package com.myportfolioAP.gk.Dto;

import javax.validation.constraints.NotBlank;


public class ExperienciaDto {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String urlImg;
    
    //constructor

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreE, String descripcionE, String urlImg) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlImg = urlImg;
    }
    
    //Setters y getters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

   
    
    
}
