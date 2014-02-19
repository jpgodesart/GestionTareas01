/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.TareaBean;

/**
 *
 * @author rafa
 */
public class TareaParam {

    private final HttpServletRequest request;

    public TareaParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public TareaBean loadId(TareaBean oTarea) throws ServletException {
        try {
            if (request.getParameter("id") != null) {
                oTarea.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oTarea.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Controller: Error: loadId: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oTarea;

    }

    public TareaBean load(TareaBean oTarea) throws NumberFormatException, ParseException {
        try {
            if ((request.getParameter("nombre") != null)) {
                oTarea.setNombre(request.getParameter("nombre"));
            }
            if ((request.getParameter("descripcion") != null)) {
                oTarea.setDescripcion(request.getParameter("descripcion"));
            }
            if ((request.getParameter("id_estado") != null)) {
                oTarea.getEstado().setId(Integer.parseInt(request.getParameter("id_estado")));
            }
            if ((request.getParameter("id_proyecto") != null)) {
                oTarea.getProyecto().setId(Integer.parseInt(request.getParameter("id_proyecto")));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("TareaParam: Error: load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oTarea;
    }
}

