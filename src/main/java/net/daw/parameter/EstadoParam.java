/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.EstadoBean;

/**
 *
 * @author rafa
 */
public class EstadoParam {

    private final HttpServletRequest request;

    public EstadoParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public EstadoBean loadId(EstadoBean oEstado) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oEstado.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oEstado.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oEstado;
    }

    public EstadoBean load(EstadoBean oEstado) throws NumberFormatException{
        try {
            if ((request.getParameter("nombre") != null)) {
                oEstado.setNombre(request.getParameter("nombre"));
            }

            
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        } 
        return oEstado;
    }
}