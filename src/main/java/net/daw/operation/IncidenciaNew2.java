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

import net.daw.bean.IncidenciaBean;
import net.daw.dao.IncidenciaDao;
import net.daw.helper.Contexto;
import net.daw.parameter.IncidenciaParam;

public class IncidenciaNew2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        IncidenciaBean oIncidenciaBean = new IncidenciaBean();
        IncidenciaDao oIncidenciaDao = new IncidenciaDao(oContexto.getEnumTipoConexion());
        IncidenciaParam oIncidenciaParam = new IncidenciaParam(request);
        IncidenciaBean = oIncidenciaParam.loadId(IncidenciaBean);
        try {
            IncidenciaBean = oIncidenciaParam.load(IncidenciaBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        try {
            IncidenciaDao.set(IncidenciaBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha añadido la información del cliente con id=" + Integer.toString(oIncidenciaBean.getId());
    }
}
