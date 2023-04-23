
package com.myportfolioAP.gk.Dto;

import javax.validation.constraints.NotBlank;


public class EstudiosDto {
@NotBlank
private String nombreEst;
@NotBlank
private String descripcionEst;
@NotBlank
private String urlImg;

    public EstudiosDto() {
    }

    public EstudiosDto(String nombreEst, String descripcionEst, String urlImg) {
        this.nombreEst = nombreEst;
        this.descripcionEst = descripcionEst;
        this.urlImg = urlImg;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public String getDescripcionEst() {
        return descripcionEst;
    }

    public void setDescripcionEst(String descripcionEst) {
        this.descripcionEst = descripcionEst;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }



}
