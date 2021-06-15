package com.fabricio_daniel.proyecto_final;

import java.util.ArrayList;
import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PeliculasDB {
    public ArrayList<Peliculas> getPeliculas() {
        ArrayList<Peliculas> datos = new ArrayList<>();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Peliculas");
                Peliculas elemento;

                while(resultado.next()){
                    elemento = new Peliculas(resultado.getInt("id"), resultado.getString("codigo_pelicula"), resultado.getString("fecha_publicacion"), resultado.getString("nombre"));
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

    public Peliculas getPelicula(int id){
        Peliculas dato = new Peliculas();

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("SELECT * FROM Peliculas WHERE id = " + id);

                if(resultado.next()){
                    dato.setId(resultado.getInt("id"));
                    dato.setCodigo_pelicula(resultado.getString("codigo_pelicula"));
                    dato.setFecha_publicacion(resultado.getString("fecha_publicacion"));
                    dato.setNombre(resultado.getString("nombre"));
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

    public boolean insertPelicula(Peliculas dato){
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "INSERT INTO Peliculas (codigo_pelicula, fecha_publicacion, nombre) VALUES (?,?,?)";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);

                sentencia.setString(1, dato.getCodigo_pelicula());
                sentencia.setString(2, dato.getFecha_publicacion());
                sentencia.setString(3, dato.getNombre());

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

    public boolean updatePelicula(Peliculas dato) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "UPDATE Peliculas SET codigo_pelicula = ?, fecha_publicacion = ?, nombre = ? WHERE id = ?";

                PreparedStatement sentencia = conexion.prepareStatement(SQL);
                sentencia.setString(1, dato.getCodigo_pelicula());
                sentencia.setString(2, dato.getFecha_publicacion());
                sentencia.setString(3, dato.getNombre());
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

    public boolean deletePelicula(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tymc1seyb6a1mjkb","wikhbsxf5v36qk6m","sqg74tjjn2xcdr3s");

                String SQL = "DELETE FROM Peliculas WHERE id = ?";

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
