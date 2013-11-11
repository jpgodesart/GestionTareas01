/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.LenguajeBean;

/**
 *
 * @author Alvaro
 */
public class LenguajeParam {

    private HttpServletRequest request;

    public LenguajeParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public LenguajeBean loadId(LenguajeBean oLenguajeBean) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oLenguajeBean.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oLenguajeBean.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oLenguajeBean;
    }

    public LenguajeBean load(LenguajeBean oLenguajeBean) throws NumberFormatException {
        try {
            if ((request.getParameter("nombre") != null)) {
                oLenguajeBean.setNombre(request.getParameter("nombre"));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oLenguajeBean;
    }

}
