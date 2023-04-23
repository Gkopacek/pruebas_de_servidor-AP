package com.myportfolioAP.gk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "El nombre no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 3, max = 50, message = "El nombre de la categoria no cumple con la longitud")
    private String categoria;
    
    @NotNull
    private String bio;
    
    @NotNull
    @Size(min = 3, max = 50, message = "El apellido no cumple con la longitud")
    private String apellido;
    
    
    private String img;

    public Persona() {
    }
    
    public Persona(String nombre, String apellido, String categoria, String bio, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.bio = bio;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    

    
    
    
}
