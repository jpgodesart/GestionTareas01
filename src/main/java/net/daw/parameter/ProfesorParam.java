/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.parameter;

import javax.servlet.http.HttpServletRequest;
import net.daw.bean.ProfesorBean;

/**
 *
 * @author Pedro Benito
 */
public class ProfesorParam {
     private HttpServletRequest request;

    public ProfesorParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public ProfesorBean loadId(ProfesorBean oProfesor) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oProfesor.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oProfesor.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProfesor;
    }

    public ProfesorBean load(ProfesorBean oProfesor) throws NumberFormatException {
        try {
            if ((request.getParameter("id_usuario") != null)) {
                oProfesor.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            }
            if ((request.getParameter("nombre") != null)) {
                oProfesor.setNombre(request.getParameter("nombre"));
            }
            if ((request.getParameter("ape1") != null)) {
                oProfesor.setApe1(request.getParameter("ape1"));
            }
            if ((request.getParameter("ape2") != null)) {
                oProfesor.setApe2(request.getParameter("ape2"));
            }
            if ((request.getParameter("email") != null)) {
                oProfesor.setEmail(request.getParameter("email"));
            }
             if ((request.getParameter("login") != null)) {
                oProfesor.getUsuario().setLogin(request.getParameter("login"));
            }
             if ((request.getParameter("password") != null)) {
                oProfesor.getUsuario().setPassword(request.getParameter("password"));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProfesor;
    }
}
