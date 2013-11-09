/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.IncidenciaBean;
import net.daw.dao.IncidenciaDao;
import net.daw.helper.Contexto;
import net.daw.parameter.IncidenciaParam;

/**
 *
 * @author Jacobo
 */
public class IncidenciaUpdate1 implements Operation {
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/incidencia/form.jsp");
        IncidenciaBean oIncidenciaBean;
        IncidenciaDao oIncidenciaDao;
        oIncidenciaBean = new IncidenciaBean();
        IncidenciaParam oClienteParam = new IncidenciaParam(request);
        oIncidenciaBean = oClienteParam.loadId(oIncidenciaBean);
        oIncidenciaDao = new IncidenciaDao(oContexto.getEnumTipoConexion());
        try {
            oIncidenciaBean = oIncidenciaDao.get(oIncidenciaBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 1: " + e.getMessage());
        }
        oIncidenciaBean = oClienteParam.load(oIncidenciaBean);
        return oIncidenciaBean;
    }
}
