package com.fabricio_daniel.proyecto_final;

public class Fichas {
    private int id;
    private int Peliculas_id;
    private int Prestamos_id;


    public Fichas() {
        this.id = 0;
        this.Peliculas_id = 0;
        this.Prestamos_id = 0;

    }

    public Fichas(int id, int Peliculas_id, int Prestamos_id) {
        this.id = id;
        this.Peliculas_id = Peliculas_id;
        this.Prestamos_id = Prestamos_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeliculas_id() {
        return Peliculas_id;
    }

    public void setPeliculas_id(int Peliculas_id) {
        this.Peliculas_id = Peliculas_id;
    }

    public int getPrestamos_id() {
        return Prestamos_id;
    }

    public void setPrestamos_id(int Prestamos_id) {
        this.Prestamos_id = Prestamos_id;
    }
}