package com.portfoliochupitea.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String subtitulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @NotBlank
    private String telefono;
    @NotBlank
    private String ubicacion;
    
//    Constructores

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String subtitulo, String descripcion, String img, String telefono, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
        this.img = img;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }    
    
//    Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
