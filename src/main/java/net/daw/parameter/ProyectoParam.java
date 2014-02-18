/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.ProyectoBean;

/**
 *
 * @author rafa
 */
public class ProyectoParam {

    private final HttpServletRequest request;

    public ProyectoParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public ProyectoBean loadId(ProyectoBean oProyecto) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oProyecto.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oProyecto.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProyecto;
    }

    public ProyectoBean load(ProyectoBean oProyecto) throws NumberFormatException {
        try {
            if ((request.getParameter("nombre") != null)) {
                oProyecto.setNombre(request.getParameter("nombre"));
            }
            if ((request.getParameter("descripcion") != null)) {
                oProyecto.setDescripcion(request.getParameter("descripcion"));
            }


        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProyecto;
    }
}
