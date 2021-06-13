package com.fabricio_daniel.proyecto_final;

import java.util.Date;

public class Notas {
    private int id;
    private int Clientes_id;
    private int Empleados_id;
    private double monto;
    private Date fecha_expedicion;


    public Notas() {
        this.id = 0;
        this.Clientes_id = 0;
        this.Empleados_id = 0;
        this.monto = 0.0;
        this.fecha_expedicion = new Date();

    }

    public Notas(int id, int Clientes_id, int Empleados_id, double monto, Date fecha_expedicion) {
        this.id = id;
        this.Clientes_id = Clientes_id;
        this.Empleados_id = Empleados_id;
        this.monto = monto;
        this.fecha_expedicion = fecha_expedicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientes_id() {
        return Clientes_id;
    }

    public void setClientes_id(int Clientes_id) {
        this.Clientes_id = Clientes_id;
    }

    public int getEmpleados_id() {
        return Empleados_id;
    }

    public void setEmpleados_id(int Empleados_id) {
        this.Empleados_id = Empleados_id;
    }

    public double getmonto() {
        return monto;
    }

    public void setmonto(double monto) {
        this.monto = monto;
    }

    public Date getfecha_fecha_expedicion() {
        return fecha_expedicion;
    }

    public void setfecha_expedicion(Date fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }
}