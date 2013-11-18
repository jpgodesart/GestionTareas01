/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ContestacionBean;
import net.daw.dao.ContestacionDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ContestacionParam;

/**
 *
 * @author rafa
 */
public class ContestacionRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        ContestacionBean oContestacionBean = new ContestacionBean();
        ContestacionParam oContestacionParam = new ContestacionParam(request);
        oContestacionBean = oContestacionParam.loadId(oContestacionBean);
        try {
            ContestacionDao oContestacionDAO = new ContestacionDao(oContexto.getEnumTipoConexion());
            oContestacionDAO.remove(oContestacionBean);
        } catch (Exception e) {
            throw new ServletException("ContestacionController: Remove Error: " + e.getMessage());
        }
        String strMensaje = "Se ha eliminado la información de la contestacion con id=" + Integer.toString(oContestacionBean.getId()) + "<br />";
        strMensaje += "<a href=\"Controller?class=contestacion&method=list\">Ir al listado de contestacions</a><br />";
        String Mensaje = strMensaje;
        return Mensaje;
    }

}
