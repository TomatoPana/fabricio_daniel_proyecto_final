package com.fabricio_daniel.proyecto_final;

public class Empleados {
    private int id;
    private String nomina;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String horario;
    private String telefono;

    public Empleados() {
        this.id = 0;
        this.nomina = "";
        this.nombre = "";
        this.apellido_paterno = "";
        this.apellido_materno = "";
        this.horario = "";
        this.telefono = "";
    }

    public Empleados(int id, String nomina, String nombre, String apellido_paterno, String apellido_materno, String horario, String telefono) {
        this.id = id;
        this.nomina = nomina;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.horario = horario;
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

    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}