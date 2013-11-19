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
public class ContestacionUpdate1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/contestacion/form.jsp");
        ContestacionBean oContestacionBean;
        ContestacionDao oContestacionDao;
        oContestacionBean = new ContestacionBean();
        ContestacionParam oContestacionParam = new ContestacionParam(request);
        oContestacionBean = oContestacionParam.loadId(oContestacionBean);
        oContestacionDao = new ContestacionDao(oContexto.getEnumTipoConexion());
        try {
            oContestacionBean = oContestacionDao.get(oContestacionBean);
        } catch (Exception e) {
            throw new ServletException("ContestacionController: Update Error: Phase 1: " + e.getMessage());
        }
        try {
            oContestacionBean = oContestacionParam.load(oContestacionBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        return oContestacionBean;
    }
}
