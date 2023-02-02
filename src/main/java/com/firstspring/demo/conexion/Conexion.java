package com.firstspring.demo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection conexion = null;

    public Connection getconexion() {

        return conexion;

    }

    public void conect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String URL = "jdbc:mysql://localhost:3306/veterinariasas";
            conexion = DriverManager.getConnection(URL, "root", "");
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getCon() {
        return conexion;

    }
}
