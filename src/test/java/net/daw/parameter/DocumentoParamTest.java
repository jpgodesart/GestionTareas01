package net.daw.parameter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.DocumentoBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Alvaro
 */
public class DocumentoParamTest {

    public DocumentoParamTest() {
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
    public void testsGetterSetters() throws IOException, Exception {
        System.out.println("test: DocumentoParam");

        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("titulo")).thenReturn("titulo");
        when(request.getParameter("contenido")).thenReturn("contenido");
        when(request.getParameter("fecha")).thenReturn("fecha");
        when(request.getParameter("nota")).thenReturn("10");
        //when(request.getParameter("id_usuario")).thenReturn("id_usuario");
        when(request.getParameter("etiquetas")).thenReturn("etiquetas");
        DocumentoBean oDocumentoBean = new DocumentoBean();
        DocumentoParam oDocumentoParam = new DocumentoParam(request);

        oDocumentoBean = oDocumentoParam.loadId(oDocumentoBean);

        assertEquals("getId: devuelve 1", oDocumentoBean.getId(), 1);

        oDocumentoBean = oDocumentoParam.load(oDocumentoBean);

        assertEquals("getNombre: devuelve titulo", oDocumentoBean.getTitulo(), "titulo");
        assertEquals("getNombre: devuelve contenido", oDocumentoBean.getContenido(), "contenido");
        assertEquals("getNombre: devuelve fecha", oDocumentoBean.getFecha(), "fecha");
        assertEquals("getNombre: devuelve nota", oDocumentoBean.getNota(), 10);
        //assertEquals("getNombre: devuelve id_usuario", oDocumentoBean.getTitulo(), "id_usuario");
        assertEquals("getNombre: devuelve etiquetas", oDocumentoBean.getEtiquetas(), "etiquetas");
    }

}
