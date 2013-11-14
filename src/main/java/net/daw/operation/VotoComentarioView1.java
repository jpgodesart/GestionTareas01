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
public class VotoComentarioView1 implements Operation{
    
  @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/votocomentario/form.jsp");        
        VotoComentarioBean oVotoComentarioBean;
        VotoComentarioDao oVotoComentarioDao;
        oVotoComentarioBean = new VotoComentarioBean();
        VotoComentarioParam oVotoComentarioParam = new VotoComentarioParam(request);
        oVotoComentarioBean = oVotoComentarioParam.loadId(oVotoComentarioBean);
        oVotoComentarioDao = new VotoComentarioDao(oContexto.getEnumTipoConexion());
        try {
            oVotoComentarioBean = oVotoComentarioDao.get(oVotoComentarioBean);
        } catch (Exception e) {
            throw new ServletException("VotoComentarioController: View Error: Phase 1: " + e.getMessage());
        }
        oVotoComentarioBean = oVotoComentarioParam.load(oVotoComentarioBean);
        return oVotoComentarioBean;
    }
}
