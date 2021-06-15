package com.fabricio_daniel.proyecto_final;

import java.util.ArrayList;
import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrestamosDB {
    public ArrayList<Prestamos> getPrestamos() {
        ArrayList<Prestamos> datos = new ArrayList<>();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Prestamos");
                Prestamos elemento;

                while(resultado.next()){
                    elemento = new Prestamos(resultado.getInt("id"), resultado.getString("fecha_entrega"), resultado.getString("fecha_Salida"));
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

    public Prestamos getPrestamo(int id){
        Prestamos dato = new Prestamos();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Prestamos WHERE id = " + id);

                if(resultado.next()){
                    dato.setId(resultado.getInt("id"));
                    dato.setFecha_entrega(resultado.getString("fecha_entrega"));
                    dato.setFecha_salida(resultado.getString("fecha_salida"));
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

    public boolean insertPrestamo(Prestamos dato){
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "INSERT INTO Prestamos (fecha_entrega, fecha_salida) VALUES (?,?)";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);

                sentencia.setString(1, dato.getFecha_entrega());
                sentencia.setString(2, dato.getFecha_salida());

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

    public boolean updatePrestamo(Prestamos dato) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "UPDATE Prestamos SET fecha_entrega = ?, fecha_salida = ? WHERE id = ?";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);
                sentencia.setString(1, dato.getFecha_entrega());
                sentencia.setString(2, dato.getFecha_salida());
                sentencia.setInt(3, dato.getId());

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

    public boolean deletePrestamo(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "DELETE FROM Prestamos WHERE id = ?";

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
