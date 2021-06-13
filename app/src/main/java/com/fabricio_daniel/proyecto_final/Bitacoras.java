package com.fabricio_daniel.proyecto_final;

import java.util.Date;

public class Bitacoras {
    private int id;
    private int Empleados_id;
    private int Prestamos_id;
    private Date fecha_bitacora;


    public Bitacoras() {
        this.id = 0;
        this.Empleados_id = 0;
        this.Prestamos_id = 0;
        this.fecha_bitacora = new Date();

    }

    public Bitacoras(int id, int Empleados_id, int Prestamos_id, Date fecha_bitacora) {
        this.id = id;
        this.Empleados_id = Empleados_id;
        this.Prestamos_id = Prestamos_id;
        this.fecha_bitacora = fecha_bitacora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpleados_id() {
        return Empleados_id;
    }

    public void setEmpleados_id(int Empleados_id) {
        this.Empleados_id = Empleados_id;
    }

    public int getPrestamos_id() {
        return Prestamos_id;
    }

    public void setPrestamos_id(int Prestamos_id) {
        this.Prestamos_id = Prestamos_id;
    }

    public Date getfecha_fecha_bitacora() {
        return fecha_bitacora;
    }

    public void setfecha_bitacora(Date fecha_bitacora) {
        this.fecha_bitacora = fecha_bitacora;
    }
}
