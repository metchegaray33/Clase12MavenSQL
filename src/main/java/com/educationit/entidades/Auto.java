/*
 * Auto.java
 *
 */
package com.educationit.entidades;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Auto extends Vehiculo {

    // Atributos
    private Integer id;
    private StringProperty marca;
    private StringProperty modelo;
    private StringProperty color;
    private StringProperty equipamiento;
    private DoubleProperty precio;
    
    /**
     * Creates a new instance of Auto
     */
    public Auto() {
        this(null, null, null, 0, 0, 0, null, 0D);
    }

    public Auto(String marca, String modelo, String color, Integer largo, Integer ancho, Integer altura, String equipamiento, Double precio) {
        super(ancho, largo, altura);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.color = new SimpleStringProperty(color);
        this.equipamiento = new SimpleStringProperty(equipamiento);
        this.precio = new SimpleDoubleProperty(precio);
    }

    public String toString() {
        return marca.get() + " " + modelo.get() + " " + color.get() + " [" + super.toString() + "]";
    }

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public StringProperty modeloProperty() {
        return modelo;
    }

    public StringProperty marcaProperty() {
        return marca;
    }

    public StringProperty equipamientoProperty() {
        return equipamiento;
    }

    public String getEquipamiento() {
        return equipamiento.get();
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento.set(equipamiento);
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio.set(precio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     public static Auto obtenerSegunId(Connection conn, int id) throws Exception {
         
          String laConsulta = "SELECT * FROM autos where au_id=" + id;
          Statement stmtConsulta = conn.createStatement();
          ResultSet rs = stmtConsulta.executeQuery(laConsulta);
            // Informa la insercion a realizar
          System.out.println(">>SQL: " + laConsulta);
          Auto a = new Auto();
            // Muestra los datos
         while (rs.next()) {
             // Arma el objeto auto con los datos de la consulta
             
             a.setId(rs.getInt("au_id"));
             a.setMarca(rs.getString("au_marca"));
             a.setModelo(rs.getString("au_modelo"));
             a.setPrecio(rs.getDouble("au_precio"));
             a.setColor(rs.getString("au_color"));
             a.setLargo(rs.getInt("au_largo"));
             a.setAncho(rs.getInt("au_ancho"));
             a.setAltura(rs.getInt("au_altura"));
             a.setEquipamiento(rs.getString("au_equipamiento"));
         }
                
         return a;
     }
     
      public static Auto obtenerMaxId(Connection conn) throws Exception {
         
          String laConsulta = "SELECT max(au_id) FROM j2se.autos";
          Statement stmtConsulta = conn.createStatement();
          ResultSet rs = stmtConsulta.executeQuery(laConsulta);
            // Informa la insercion a realizar
          System.out.println(">>SQL: " + laConsulta);
          Auto a = new Auto();
            // Muestra los datos
         while (rs.next()) {
             // Arma el objeto auto con los datos de la consulta
             
             a.setId(rs.getInt("au_id"));          
         }
                
         return a;
     }
      
         public static int traerCantidadRegistros(Connection conn) throws Exception {
         
          String laConsulta = "SELECT count(*)as cantidad FROM j2se.autos";
          Statement stmtConsulta = conn.createStatement();
          ResultSet rs = stmtConsulta.executeQuery(laConsulta);
            // Informa la insercion a realizar
          System.out.println(">>SQL: " + laConsulta);
          int cantidad=0;
            // Muestra los datos
         while (rs.next()) {
             // Arma el objeto auto con los datos de la consulta
             
             cantidad=rs.getInt("cantidad");          
         }
                
         return cantidad;
     }
      
      
    public static ArrayList<Auto> obtenerTodos(Connection conn) throws Exception {
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM autos";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laConsulta);

        // Construye la coleccion de autos
        ArrayList autosList = new ArrayList();

        // Muestra los datos
        while (rs.next()) {
            // Arma el objeto auto con los datos de la consulta
            Auto a = new Auto();
            a.setId(rs.getInt("au_id"));
            a.setMarca(rs.getString("au_marca"));
            a.setModelo(rs.getString("au_modelo"));
            a.setPrecio(rs.getDouble("au_precio"));
            a.setColor(rs.getString("au_color"));
            a.setLargo(rs.getInt("au_largo"));
            a.setAncho(rs.getInt("au_ancho"));
            a.setAltura(rs.getInt("au_altura"));
            a.setEquipamiento(rs.getString("au_equipamiento"));

            // Agrega el auto a la coleccion
            autosList.add(a);
        }
        // Cierra el Statement
        stmtConsulta.close();

        // Retorna la coleccion
        return autosList;
    }

    public void insertar(Connection conn) throws Exception {
        // Arma la sentencia de inserción
        String laInsercion = "INSERT INTO autos (au_marca, au_modelo, au_precio, au_color, au_largo, au_ancho, au_altura, au_equipamiento) "
                + "VALUES ('" + getMarca() + "', '" + getModelo() + "', " + getPrecio() + ", '"
                + getColor() + "', " + getLargo() + ", " + getAncho() + ", " + getAltura() + ", '"
                + getEquipamiento() + "')";

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laInsercion);

        // Ejecuta la insercion
        Statement stmtInsercion = conn.createStatement();
        stmtInsercion.execute(laInsercion);

        // Cierra el Statement
        stmtInsercion.close();
    }

    public void actualizar(Connection conn) throws Exception {
        // Arma la sentencia de actualizacion
        String laActualizacion = "UPDATE autos "
                + "SET au_marca = ?, au_modelo = ?, "
                + "au_precio = ?, au_color = ?, "
                + "au_largo = ?, au_ancho = ?, "
                + "au_altura = ?, "
                + "au_equipamiento = ? "
                + "WHERE au_id = ?";

        // Informa la actualizacion a realizar
        System.out.println(">>SQL: " + laActualizacion);

        // Ejecuta la actualizacion
        PreparedStatement ps = conn.prepareStatement(laActualizacion);
        ps.setString(1, getMarca());
        ps.setString(2, getModelo());
        ps.setDouble(3, getPrecio());
        ps.setString(4, getColor());
        ps.setInt(5, getLargo());
        ps.setInt(6, getAncho());
        ps.setInt(7, getAltura());
        ps.setString(8, getEquipamiento());
        ps.setInt(9, getId());
        ps.execute();
        
        // Cierra el Statement
        ps.close();
        
       
    }

    public void eliminar(Connection conn) throws Exception {
        // Arma la sentencia de eliminacion
        String laEliminacion = "DELETE FROM autos WHERE au_id = " + getId();

        // Informa la eliminacion a realizar
        System.out.println(">>SQL: " + laEliminacion);

        // Ejecuta la eliminacion
        Statement stmtEliminacion = conn.createStatement();
        stmtEliminacion.execute(laEliminacion);

        // Cierra el Statement
        stmtEliminacion.close();
    }

}
