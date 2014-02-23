/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.UsuproBean;

/**
 *
 * @author rafa
 */
public class UsuproParam {

    private final HttpServletRequest request;

    public UsuproParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public UsuproBean loadId(UsuproBean oUsupro) throws ServletException {
        try {
            if (request.getParameter("id") != null) {
                oUsupro.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oUsupro.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Controller: Error: loadId: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oUsupro;

    }

    public UsuproBean load(UsuproBean oUsupro) throws NumberFormatException, ParseException {
        try {
            
            if ((request.getParameter("id_usuario") != null)) {
                oUsupro.getUsuario().setId(Integer.parseInt(request.getParameter("id_usuario")));
            }
            if ((request.getParameter("id_proyecto") != null)) {
                oUsupro.getProyecto().setId(Integer.parseInt(request.getParameter("id_proyecto")));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("UsuproParam: Error: load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oUsupro;
    }
}

