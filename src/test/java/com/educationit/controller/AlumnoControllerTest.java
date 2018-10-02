/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educationit.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *The @BeforeClass and @AfterClass annotated methods will be run exactly 
 * once during your test run - at the very beginning and end of the test 
 * as a whole, before anything else is run. In fact, they're run before the test class is even constructed, 
 * which is why they must be declared static.
 * @author Usuario
 */
public class AlumnoControllerTest {
    
    public AlumnoControllerTest() {
    }
    
    /**
 *The @BeforeClass and @AfterClass annotated methods will be run exactly 
 * once during your test run - at the very beginning and end of the test 
 * as a whole, before anything else is run. In fact, they're run before the test class is even constructed, 
 * which is why they must be declared static.
 * @author Usuario
 */
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
  /*  The @Before and @After methods will be run before and after every test case,
    * so will probably be run multiple times during a test run.*/
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // *http://java-white-box.blogspot.com/2014/06/junit-asserts-como-comparar-resultados.html
     @Test
     public void hello() {}
}
