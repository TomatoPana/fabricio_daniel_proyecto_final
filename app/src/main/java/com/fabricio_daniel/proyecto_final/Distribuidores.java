package com.fabricio_daniel.proyecto_final;

public class Distribuidores {
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private int Peliculas_id;

    public Distribuidores() {
        this.id = 0;
        this.nombre = "";
        this.telefono = "";
        this.email = "";
        this.Peliculas_id = 0;
    }

    public Distribuidores(int id, String nombre, String telefono, String email, int Peliculas_id) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.Peliculas_id = Peliculas_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettelefono() {
        return telefono;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public int getPeliculas_id() {
        return Peliculas_id;
    }

    public void setPeliculas_id(int Peliculas_id) {
        this.Peliculas_id = Peliculas_id;
    }
}


