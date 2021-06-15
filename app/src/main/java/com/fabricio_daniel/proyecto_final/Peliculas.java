package com.fabricio_daniel.proyecto_final;

public class Peliculas {
    private int id;
    private String codigo_pelicula;
    private String fecha_publicacion;
    private String nombre;

    public Peliculas() {
        this.id = 0;
        this.codigo_pelicula = "";
        this.fecha_publicacion = "";
        this.nombre = "";
    }

    public Peliculas(int id, String codigo_pelicula, String fecha_publicacion, String nombre) {
        this.id = id;
        this.codigo_pelicula = codigo_pelicula;
        this.fecha_publicacion = fecha_publicacion;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getCodigo_pelicula() {
        return codigo_pelicula;
    }

    public void setCodigo_pelicula(String codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}