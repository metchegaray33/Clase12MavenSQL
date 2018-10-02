/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educationit.entidades;

import com.educationit.administrarconexiones.AdministradorDeConexiones;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class AutoTest {
    
    public AutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void insertar() throws Exception {
         
         Connection conn = AdministradorDeConexiones.getConnection();
         int cantidad1= Auto.traerCantidadRegistros(conn);
         
         Auto a = new Auto();
         a.setId(102);
         a.setMarca("TOYOTA");
         a.setModelo("2018");
         a.setColor("ROJO");
         a.setPrecio(18000.0);
         a.setAltura(150);
         a.setAncho(180);
         a.setLargo(345);
         a.setEquipamiento("aqui va el equipamiento");       
                  
        try {
            a.insertar(conn);
            int cantidad2= Auto.traerCantidadRegistros(conn);    
            Assert.assertEquals(cantidad1+1,cantidad2);
            
        } catch (Exception ex) {
            Logger.getLogger(AutoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     }
}
