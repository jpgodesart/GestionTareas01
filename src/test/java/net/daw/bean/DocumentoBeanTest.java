/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.bean;

import java.util.Date;
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
public class DocumentoBeanTest {
    
    public DocumentoBeanTest() {
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
        System.out.println("test: DocumentoBean");
        DocumentoBean oDocumentoBean = new DocumentoBean();
        
        oDocumentoBean.setId(1);
        assertEquals("getId: devuelve 1", oDocumentoBean.getId(), 1);
        
        oDocumentoBean.setTitulo("titulo");
        assertEquals("getNombre: devuelve titulo", oDocumentoBean.getTitulo(), "titulo");
        
        oDocumentoBean.setContenido("contenido");
        assertEquals("getNombre: devuelve contenido", oDocumentoBean.getContenido(), "contenido");
        
        Date fecha = new Date();
        oDocumentoBean.setFecha(fecha);
        assertEquals("getNombre: devuelve fecha", oDocumentoBean.getFecha(), fecha);
        
        oDocumentoBean.setNota(5);
        assertEquals("getNombre: devuelve 5", oDocumentoBean.getNota(), 5);
        
        //oDocumentoBean.setUsuario("titulo");
        //assertEquals("getNombre: devuelve nombre", oDocumentoBean.getTitulo(), "titulo");
        
        oDocumentoBean.setEtiquetas("etiquetas");
        assertEquals("getNombre: devuelve etiquetas", oDocumentoBean.getEtiquetas(), "etiquetas");
        
    }
}
