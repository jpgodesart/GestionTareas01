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
public class MetadocumentosBeanTest {
    
    public MetadocumentosBeanTest() {
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
        System.out.println("test: MetadocumentosBean");
        MetadocumentosBean oMetadocumentosBean = new MetadocumentosBean();
        
        oMetadocumentosBean.setId(1);
        assertEquals("getId: devuelve 1", oMetadocumentosBean.getId(), 1);
        
        oMetadocumentosBean.setOrden(7);
        assertEquals("getNombre: devuelve 7", oMetadocumentosBean.getOrden(), 7);
        
    }
}
