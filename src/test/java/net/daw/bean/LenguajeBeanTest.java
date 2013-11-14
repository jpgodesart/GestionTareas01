/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.bean;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alvaro
 */
public class LenguajeBeanTest {
    
    public LenguajeBeanTest() {
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

    @Test
    public void testsGetterSetters() {
        System.out.println("test: LenguajeBean");
        LenguajeBean oLenguajeBean = new LenguajeBean();
        
        oLenguajeBean.setId(1);
        assertEquals("getId: devuelve 1", oLenguajeBean.getId(), 1);
        
        oLenguajeBean.setNombre("nombre");
        assertEquals("getNombre: devuelve nombre", oLenguajeBean.getNombre(), "nombre");
        
    }
}
