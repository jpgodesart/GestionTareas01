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
public class VotoComentarioUpdate1 implements Operation {

    /**
     *
     * @author Diana Ortega
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/votocomentario/form.jsp");
        VotoComentarioBean oVotoComentarioBean;
        VotoComentarioDao oVotoComentarioDao;
        oVotoComentarioBean = new VotoComentarioBean();
        VotoComentarioParam oClienteParam = new VotoComentarioParam(request);
        oVotoComentarioBean = oClienteParam.loadId(oVotoComentarioBean);
        oVotoComentarioDao = new VotoComentarioDao(oContexto.getEnumTipoConexion());
        try {
            oVotoComentarioBean = oVotoComentarioDao.get(oVotoComentarioBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 1: " + e.getMessage());
        }
        oVotoComentarioBean = oClienteParam.load(oVotoComentarioBean);
        return oVotoComentarioBean;
    }
}
