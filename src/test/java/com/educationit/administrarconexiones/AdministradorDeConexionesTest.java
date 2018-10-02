/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educationit.administrarconexiones;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class AdministradorDeConexionesTest {
    
    public AdministradorDeConexionesTest() {
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
    // @Test
    // public void hello() {}
    @Test
    public void getConnection(){
        
        try {
                       
            Assert.assertNotNull(AdministradorDeConexiones.getConnection());
            
        } catch (Exception ex) {
            fail("exception no esperada:" + ex.getMessage());
          //  Logger.getLogger(AdministradorDeConexionesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
