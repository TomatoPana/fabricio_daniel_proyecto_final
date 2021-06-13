package com.fabricio_daniel.proyecto_final;

public class Clientes {
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String domicilio;
    private String telefono;

    public Clientes() {
        this.id = 0;
        this.nombre = "";
        this.apellido_paterno = "";
        this.apellido_materno = "";
        this.domicilio = "";
        this.telefono = "";
    }

    public Clientes(int id, String nombre, String apellido_paterno, String apellido_materno, String domicilio, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public int getId() {
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

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
