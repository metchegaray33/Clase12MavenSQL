/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educationit.administrarconexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class AdministradorDeConexiones {

    private AdministradorDeConexiones() {
    }

     
    private static Connection con = null;
    /**
     * USO PATRON SINGLETON
     * @return 
     */
    public static Connection getConnection() {

        if (con == null) {

            try {
                // Establece el driver de conexion

                String dbDriver = "com.mysql.jdbc.Driver";
                String dbConnString = "jdbc:mysql://localhost/j2se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                String dbUser = "root";
                // Establece la contrase�a de la base de datos
                String dbPassword = "admin";
                Class.forName(dbDriver).newInstance();
                con = DriverManager.getConnection(dbConnString, dbUser, dbPassword);
                return con;

            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                //   ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }//fin del if con!=null;
       return con;
    }
}
