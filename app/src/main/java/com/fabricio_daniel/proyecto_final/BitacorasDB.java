package com.fabricio_daniel.proyecto_final;

import java.util.ArrayList;
import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BitacorasDB {
    public ArrayList<Bitacoras> getBitacoras() {
        ArrayList<Bitacoras> datos = new ArrayList<>();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Bitacoras");
                Bitacoras elemento;

                while(resultado.next()){
                    elemento = new Bitacoras(resultado.getInt("id"), resultado.getInt("Empleados_id"), resultado.getInt("Prestamos_id"), resultado.getDate("fecha_bitacora"));
                    datos.add(elemento);
                }

                conexion.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };

        Thread newThread = new Thread(task);

        newThread.start();

        while(newThread.isAlive()) { }

        return datos;
    }

    public Bitacoras getBitacora(int id){
        Bitacoras dato = new Bitacoras();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Bitacoras WHERE id = " + id);

                if(resultado.next()){
                    dato.setId(resultado.getInt("id"));
                    dato.setEmpleados_id(resultado.getInt("Empleados_id"));
                    dato.setPrestamos_id(resultado.getInt("Prestamos_id"));
                    dato.setFecha_bitacora(resultado.getDate("fecha_bitacora"));
                } else {
                    throw new Exception();
                }

                conexion.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };

        Thread newThread = new Thread(task);

        newThread.start();

        while(newThread.isAlive()) { }

        return dato;
    }

    public boolean insertBitacora(Bitacoras dato){
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "INSERT INTO Bitacoras (Empleados_id, Prestamos_id, fecha_bitacora) VALUES (?,?,?)";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);

                sentencia.setInt(1, dato.getEmpleados_id());
                sentencia.setInt(2, dato.getPrestamos_id());
                sentencia.setDate(3, (Date) dato.getFecha_bitacora());

                sentencia.execute();

                resultado.set(true);

                conexion.close();

            } catch (Exception exception) {
                exception.printStackTrace();
                resultado.set(false);
            }
        };

        Thread newThread = new Thread(task);

        newThread.start();

        while(newThread.isAlive()) { }

        return resultado.get();
    }

    public boolean updateBitacora(Bitacoras dato) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "UPDATE Bitacoras SET Empleados_id = ?, Prestamos_id = ?, fecha_bitacora = ? WHERE id = ?";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);
                sentencia.setInt(1, dato.getEmpleados_id());
                sentencia.setInt(2, dato.getPrestamos_id());
                sentencia.setDate(3, (Date) dato.getFecha_bitacora());
                sentencia.setInt(4, dato.getId());

                sentencia.execute();

                resultado.set(true);

                conexion.close();

            } catch (Exception exception) {
                exception.printStackTrace();
                resultado.set(false);
            }
        };

        Thread newThread = new Thread(task);

        newThread.start();

        while(newThread.isAlive()) { }

        return resultado.get();
    }

    public boolean deleteBitacora(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "DELETE FROM Bitacoras WHERE id = ?";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);

                sentencia.setInt(1, id);

                sentencia.execute();

                resultado.set(true);

                conexion.close();

            } catch (Exception exception) {
                exception.printStackTrace();
                resultado.set(false);
            }

        };

        Thread newThread = new Thread(task);

        newThread.start();

        while(newThread.isAlive()) { }

        return resultado.get();
    }
}
