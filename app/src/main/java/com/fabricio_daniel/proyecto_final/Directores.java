package com.fabricio_daniel.proyecto_final;

public class Directores {
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private int Peliculas_id;

    public Directores() {
        this.id = 0;
        this.nombre = "";
        this.apellido_paterno = "";
        this.apellido_materno = "";
        this.Peliculas_id = 0;
    }

    public Directores(int id, String nombre, String apellido_paterno, String apellido_materno, int Peliculas_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.Peliculas_id = Peliculas_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getapellido_paterno() {
        return apellido_paterno;
    }

    public void setapellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido_materno() {
        return apellido_materno;
    }

    public void setapellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public int getPeliculas_id() {
        return Peliculas_id;
    }

    public void setPeliculas_id(int Peliculas_id) {
        this.Peliculas_id = Peliculas_id;
    }
}