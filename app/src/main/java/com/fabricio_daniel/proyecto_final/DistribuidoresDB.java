package com.fabricio_daniel.proyecto_final;

import java.util.ArrayList;
import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DistribuidoresDB {
    public ArrayList<Distribuidores> getDistribuidores() {
        ArrayList<Distribuidores> datos = new ArrayList<>();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Distribuidores");
                Distribuidores elemento;

                while(resultado.next()){
                    elemento = new Distribuidores(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("telefono"), resultado.getString("email"), resultado.getInt("Peliculas_id"));
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

    public Distribuidores getDistribuidor(int id){
        Distribuidores dato = new Distribuidores();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Distribuidores WHERE id = " + id);

                if(resultado.next()){
                    dato.setId(resultado.getInt("id"));
                    dato.setNombre(resultado.getString("nombre"));
                    dato.setTelefono(resultado.getString("telefono"));
                    dato.setEmail(resultado.getString("email"));
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

    public boolean insertDistribuidor(Distribuidores dato){
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "INSERT INTO Distribuidores (nombre, telefono, email, Peliculas_id) VALUES (?,?,?,?)";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);

                sentencia.setString(1, dato.getNombre());
                sentencia.setString(2, dato.getTelefono());
                sentencia.setString(3, dato.getEmail());
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

    public boolean updateDistribuidor(Distribuidores dato) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "UPDATE Distribuidores SET nombre = ?, telefono = ?, email = ?, Peliculas_id = ? WHERE id = ?";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);
                sentencia.setString(1, dato.getNombre());
                sentencia.setString(2, dato.getTelefono());
                sentencia.setString(3, dato.getEmail());
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

    public boolean deleteDistribuidor(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "DELETE FROM Distribuidores WHERE id = ?";

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