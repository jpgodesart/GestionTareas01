/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.IncidenciaBean;

/**
 *
 * @author al037431
 */
public class IncidenciaParam {

    private HttpServletRequest request;

    public IncidenciaParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public IncidenciaBean loadId(IncidenciaBean oIncidencia) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oIncidencia.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oIncidencia.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oIncidencia;
    }

    public IncidenciaBean load(IncidenciaBean oIncidencia) throws NumberFormatException {
        try {
            if ((request.getParameter("id") != null)) {
                oIncidencia.setId(Integer.parseInt(request.getParameter("id")));
            }
            if ((request.getParameter("resumen") != null)) {
                oIncidencia.setResumen(request.getParameter("resumen"));
            }
            if ((request.getParameter("cambios") != null)) {
                oIncidencia.setCambios(request.getParameter("cambios"));
            }
            if ((request.getParameter("id_estado") != null)) {
                oIncidencia.setId_estado(Integer.parseInt(request.getParameter("id_estado")));
            }
            if ((request.getParameter("id_repositorio") != null)) {
                oIncidencia.setId_repositorio(Integer.parseInt(request.getParameter("id_repositorio")));
            }
            if ((request.getParameter("id_usuario") != null)) {
                oIncidencia.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            }
            if ((request.getParameter("fechaAlta") != null)) {
                oIncidencia.setFechaAlta(request.getParameter("fechaAlta"));
            }
            if ((request.getParameter("fechaResolucion") != null)) {
                oIncidencia.setFechaResolucion(request.getParameter("fechaResolucion"));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oIncidencia;
    }
}
