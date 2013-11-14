/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.VotoComentarioBean;
import net.daw.dao.VotoComentarioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.VotoComentarioParam;

/**
 *
 * @author Diana Ortega
 */
public class VotoComentarioNew2 implements Operation {
    
     @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        VotoComentarioBean oVotoComentarioBean = new VotoComentarioBean();
        VotoComentarioDao oVotoComentarioDao = new VotoComentarioDao(oContexto.getEnumTipoConexion());
        VotoComentarioParam oVotoComentarioParam = new VotoComentarioParam(request);
        oVotoComentarioBean = oVotoComentarioParam.loadId(oVotoComentarioBean);
        try {
            oVotoComentarioBean = oVotoComentarioParam.load(oVotoComentarioBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        try {
            oVotoComentarioDao.set(oVotoComentarioBean);
        } catch (Exception e) {
            throw new ServletException("VotoComentarioController: New Error: Phase 2: " + e.getMessage());
        }
        String strMensaje = "Se ha añadido la información del votoComentario con id=" + Integer.toString(oVotoComentarioBean.getId()) + "<br />";
        strMensaje += "<a href=\"Controller?class=votoComentario&method=view&id=" + oVotoComentarioBean.getId() + "\">Ver votoComentario creado en el formulario</a><br />";
        return strMensaje;
    }
    
}
