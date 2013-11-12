/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operation;

/**
 *
 * @author al037213
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.CuestionarioBean;
import net.daw.dao.CuestionarioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.CuestionarioParam;

public class CuestionarioUpdate2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");   
        CuestionarioBean oCuestionarioBean = new CuestionarioBean();
        CuestionarioDao oCuestionarioDao = new CuestionarioDao(oContexto.getEnumTipoConexion());
        CuestionarioParam oCuestionarioParam = new CuestionarioParam(request);
        oCuestionarioBean = oCuestionarioParam.loadId(oCuestionarioBean);
        oCuestionarioBean = oCuestionarioParam.load(oCuestionarioBean);
        try {
            oCuestionarioDao.set(oCuestionarioBean);
        } catch (Exception e) {
            throw new ServletException("CuestionarioController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha modificado la información del cuestionario con id=" + Integer.toString(oCuestionarioBean.getId());
    }
}
