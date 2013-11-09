/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author al037431
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.IncidenciasBean;
import net.daw.dao.IncidenciasDao;
import net.daw.helper.Contexto;
import net.daw.parameter.IncidenciasParam;

public class IncidenciasNew2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        IncidenciasBean oIncidenciaBean = new IncidenciasBean();
        IncidenciasDao oIncidenciaDao = new IncidenciasDao(oContexto.getEnumTipoConexion());
        IncidenciasParam oIncidenciaParam = new IncidenciasParam(request);
        oIncidenciaBean = oIncidenciaParam.loadId(oIncidenciaBean);
        try {
            oIncidenciaBean = oIncidenciaParam.load(oIncidenciaBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        try {
            oIncidenciaDao.set(oIncidenciaBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha añadido la información del cliente con id=" + Integer.toString(oIncidenciaBean.getId());
    }
}
