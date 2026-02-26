package com.mycompany.ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
    private static final String USER = "david_user"; 
    private static final String PASSWORD = "david_password";

    // Cambiamos el nombre de conectar() a getConexion()
    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver no encontrado", e);
        }
    }
}