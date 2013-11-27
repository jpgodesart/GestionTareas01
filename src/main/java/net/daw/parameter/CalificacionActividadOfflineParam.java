/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.CalificacionActividadOfflineBean;

/**
 *
 * @author al037805
 */
public class CalificacionActividadOfflineParam {
    
    private final HttpServletRequest request;

    public CalificacionActividadOfflineParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public CalificacionActividadOfflineBean loadId(CalificacionActividadOfflineBean oCalificacionActividadOffline) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oCalificacionActividadOffline.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oCalificacionActividadOffline.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oCalificacionActividadOffline;
    }

    public CalificacionActividadOfflineBean load(CalificacionActividadOfflineBean oCalificacionActividadOffline) throws NumberFormatException, ParseException {
        try {
            if ((request.getParameter("descripcion") != null)) {
                oCalificacionActividadOffline.setDescripcion(request.getParameter("descripcion"));
            }
            if ((request.getParameter("fecha") != null)) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = formatoFecha.parse(request.getParameter("fecha"));
                oCalificacionActividadOffline.setFecha(fecha);
            }
            if ((request.getParameter("evaluacion") != null)) {
                oCalificacionActividadOffline.setEvaluacion(Integer.parseInt(request.getParameter("evaluacion")));
            }
            if ((request.getParameter("activo") != null)) {
                String activo = request.getParameter("activo");
                oCalificacionActividadOffline.setActivo( activo.equals("true") );
            }
            
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        } catch (ParseException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de fecha en parámetros incorrecto " + e.getMessage());
        }
        return oCalificacionActividadOffline;
    }
    
}
