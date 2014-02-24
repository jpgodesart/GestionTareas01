/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.UsutareaBean;

/**
 *
 * @author rafa
 */
public class UsutareaParam {

    private final HttpServletRequest request;

    public UsutareaParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public UsutareaBean loadId(UsutareaBean oUsutarea) throws ServletException {
        try {
            if (request.getParameter("id") != null) {
                oUsutarea.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oUsutarea.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Controller: Error: loadId: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oUsutarea;

    }

    public UsutareaBean load(UsutareaBean oUsutarea) throws NumberFormatException, ParseException {
        try {
            
            if ((request.getParameter("id_usuario") != null)) {
                oUsutarea.getUsuario().setId(Integer.parseInt(request.getParameter("id_usuario")));
            }
            if ((request.getParameter("id_tarea") != null)) {
                oUsutarea.getTarea().setId(Integer.parseInt(request.getParameter("id_tarea")));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("UsutareaParam: Error: load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oUsutarea;
    }
}

