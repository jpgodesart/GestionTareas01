/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.IncidenciaBean;

/**
 *
 * @author Jacobo
 */
public class IncidenciaParam {
    
    private HttpServletRequest request;

    public IncidenciaParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public IncidenciaBean loadId(IncidenciaBean oIncidenciaBean) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oIncidenciaBean.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oIncidenciaBean.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oIncidenciaBean;
    }

    public IncidenciaBean load(IncidenciaBean oIncidenciaBean) throws NumberFormatException {
        try {
            if ((request.getParameter("id_usuario") != null)) {
                oIncidenciaBean.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            }
            if ((request.getParameter("resumen") != null)) {
                oIncidenciaBean.setResumen(request.getParameter("resumen"));
            }
            if ((request.getParameter("cambios") != null)) {
                oIncidenciaBean.setCambios(request.getParameter("cambios"));
            }
            if ((request.getParameter("id_estado") != null)) {
                oIncidenciaBean.setId_estado(Integer.parseInt(request.getParameter("id_estado")));
            }
            if ((request.getParameter("id_repositorio") != null)) {
                oIncidenciaBean.setId_repositorio(Integer.parseInt(request.getParameter("id_repositorio")));
            }
            if ((request.getParameter("fechaalta") != null)) {
                //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                oIncidenciaBean.setFechaAlta(request.getParameter("fechaalta"));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        } /*catch (ParseException ex) {
            Logger.getLogger(IncidenciaParam.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return oIncidenciaBean;
    }
}
