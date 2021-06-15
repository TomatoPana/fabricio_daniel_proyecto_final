package com.fabricio_daniel.proyecto_final;

import java.util.ArrayList;
import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DirectoresDB {
    public ArrayList<Directores> getDirectores() {
        ArrayList<Directores> datos = new ArrayList<>();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Directores");
                Directores elemento;

                while(resultado.next()){
                    elemento = new Directores(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("apellido_paterno"), resultado.getString("apellido_materno"), resultado.getInt("Peliculas_id"));
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

    public Directores getDirector(int id){
        Directores dato = new Directores();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Directores WHERE id = " + id);

                if(resultado.next()){
                    dato.setId(resultado.getInt("id"));
                    dato.setNombre(resultado.getString("nombre"));
                    dato.setApellido_paterno(resultado.getString("apellido_paterno"));
                    dato.setApellido_materno(resultado.getString("apellido_materno"));
                    dato.setPeliculas_id(resultado.getInt("Peliculas_id"));
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

    public boolean insertDirector(Directores dato){
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "INSERT INTO Directores (nombre, apellido_paterno, apellido_materno, Peliculas_id) VALUES (?,?,?,?)";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);

                sentencia.setString(1, dato.getNombre());
                sentencia.setString(2, dato.getApellido_paterno());
                sentencia.setString(3, dato.getApellido_materno());
                sentencia.setInt(4, dato.getPeliculas_id());

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

    public boolean updateDirector(Directores dato) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "UPDATE Directores SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, Peliculas_id = ? WHERE id = ?";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);
                sentencia.setString(1, dato.getNombre());
                sentencia.setString(2, dato.getApellido_paterno());
                sentencia.setString(3, dato.getApellido_materno());
                sentencia.setInt(4, dato.getPeliculas_id());
                sentencia.setInt(5, dato.getId());

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

    public boolean deleteDirector(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "DELETE FROM Directores WHERE id = ?";

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
