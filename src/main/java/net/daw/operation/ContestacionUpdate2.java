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
public class ContestacionUpdate2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        switch (oContexto.getSearchingFor()) {
            case "usuario": {
                oContexto.setVista("jsp/usuario/list.jsp");
                oContexto.setClase("usuario");
                oContexto.setMetodo("list");
                oContexto.setFase("1");
                oContexto.setSearchingFor("usuario");
                oContexto.setClaseRetorno("contestacion");
                oContexto.setMetodoRetorno("update");
                oContexto.setFaseRetorno("1");
                oContexto.removeParam("id_usuario");
                UsuarioList1 oOperacion = new UsuarioList1();
                return oOperacion.execute(request, response);
            }
            case "pregunta": {
                oContexto.setVista("jsp/pregunta/list.jsp");
                oContexto.setClase("pregunta");
                oContexto.setMetodo("list");
                oContexto.setFase("1");
                oContexto.setSearchingFor("pregunta");
                oContexto.setClaseRetorno("contestacion");
                oContexto.setMetodoRetorno("update");
                oContexto.setFaseRetorno("1");
                oContexto.removeParam("id_pregunta");
                PreguntaList1 oOperacion = new PreguntaList1();
                return oOperacion.execute(request, response);
            }
            case "opcion": {
                oContexto.setVista("jsp/opcion/list.jsp");
                oContexto.setClase("opcion");
                oContexto.setMetodo("list");
                oContexto.setFase("1");
                oContexto.setSearchingFor("opcion");
                oContexto.setClaseRetorno("contestacion");
                oContexto.setMetodoRetorno("update");
                oContexto.setFaseRetorno("1");
                oContexto.removeParam("id_opcion");
                OpcionList1 oOperacion = new OpcionList1();
                return oOperacion.execute(request, response);
            }
            default:
                oContexto.setVista("jsp/mensaje.jsp");
                ContestacionBean oContestacionBean = new ContestacionBean();
                ContestacionDao oContestacionDao = new ContestacionDao(oContexto.getEnumTipoConexion());
                ContestacionParam oContestacionParam = new ContestacionParam(request);
                oContestacionBean = oContestacionParam.loadId(oContestacionBean);
                oContestacionBean = oContestacionDao.get(oContestacionBean);
                try {
                    oContestacionBean = oContestacionParam.load(oContestacionBean);
                } catch (NumberFormatException e) {
                    return "Tipo de dato incorrecto en uno de los campos del formulario";
                }
                try {
                    oContestacionDao.set(oContestacionBean);
                } catch (Exception e) {
                    throw new ServletException("ContestacionController: Update Error: Phase 2: " + e.getMessage());
                }
                String strMensaje = "Se ha modificado la información de la contestacion con id=" + Integer.toString(oContestacionBean.getId()) + "<br />";
                strMensaje += "<a href=\"Controller?class=contestacion&method=view&id=" + oContestacionBean.getId() + "\">Ver contestacion modificada</a><br />";
                return strMensaje;
        }
    }

}
