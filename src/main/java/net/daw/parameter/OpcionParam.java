/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author al037721
 */
package net.daw.parameter;

import javax.servlet.http.HttpServletRequest;
import net.daw.bean.OpcionBean;

/**
 *
 * @author rafa
 */
public class OpcionParam {

    private final HttpServletRequest request;

    public OpcionParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public OpcionBean loadId(OpcionBean oOpcion) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oOpcion.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oOpcion.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oOpcion;
    }

    public OpcionBean load(OpcionBean oOpcion) throws NumberFormatException {
        try {
            if ((request.getParameter("descripcion") != null)) {
                oOpcion.setDescripcion(request.getParameter("descripcion"));
            }
            if ((request.getParameter("id_pregunta") != null)) {
                oOpcion.setId_pregunta(Integer.parseInt(request.getParameter("id_pregunta")));
            }
            if ((request.getParameter("correcta") != null)) {
                oOpcion.setCorrecta(Boolean.getBoolean(request.getParameter("correcta")));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        } 
        return oOpcion;
    }
}

