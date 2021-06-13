package com.fabricio_daniel.proyecto_final;

import java.util.Date;

public class Prestamos {
    private int id;
    private Date fecha_entrega;
    private Date fecha_salida;

    public Prestamos() {
        this.id = 0;
        this.fecha_entrega = new Date();
        this.fecha_salida = new Date();
    }

    public Prestamos(int id, Date fecha_entrega, Date fecha_salida) {
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

    public Date getfecha_salida() {
        return fecha_salida;
    }

    public void setfecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Date getfecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

}
