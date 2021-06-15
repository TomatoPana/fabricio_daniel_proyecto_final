package com.fabricio_daniel.proyecto_final;

import java.util.Date;

public class Prestamos {
    private int id;
    private String fecha_entrega;
    private String fecha_salida;

    public Prestamos() {
        this.id = 0;
        this.fecha_entrega = "";
        this.fecha_salida = "";
    }

    public Prestamos(int id, String fecha_entrega, String fecha_salida) {
        this.id = id;
        this.fecha_entrega = fecha_entrega;
        this.fecha_salida = fecha_salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

}
