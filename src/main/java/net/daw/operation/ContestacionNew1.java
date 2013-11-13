/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ContestacionBean;
import net.daw.dao.UsuarioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ContestacionParam;

/**
 *
 * @author rafa
 */
public class ContestacionNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        ContestacionParam oContestacionParam = new ContestacionParam(request);
        ContestacionBean oContestacionBean = new ContestacionBean();
        UsuarioDao oUsuarioDao = new UsuarioDao(oContexto.getEnumTipoConexion());
        PreguntaDao oPreguntaDao = new PreguntaDao(oContexto.getEnumTipoConexion());
        Opcion oOpcionDao = new OpcionDao(oContexto.getEnumTipoConexion());
        
        
        try {
            oContestacionBean = oContestacionParam.load(oContestacionBean);
            oContestacionBean.setUsuario(oUsuarioDao.get(oContestacionBean.getUsuario()));
            oContestacionBean = oContestacionParam.load(oContestacionBean);
            oContestacionBean.setPregunta(oPreguntaDao.get(oContestacionBean.getPregunta()));
            oContestacionBean = oContestacionParam.load(oContestacionBean);
            oContestacionBean.setOpcion(oOpcionDao.get(oContestacionBean.getOpcion()));
            oContestacionBean = oContestacionParam.load(oContestacionBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        oContexto.setVista("jsp/contestacion/form.jsp");
        return oContestacionBean;
    }

}
