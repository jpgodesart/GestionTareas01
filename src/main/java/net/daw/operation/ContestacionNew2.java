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
public class ContestacionNew2 implements Operation {

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
                oContexto.setMetodoRetorno("new");
                oContexto.setFaseRetorno("1");
                oContexto.removeParam("id_usuario");
                UsuarioList1 oOperacion = new UsuarioList1();
                return oOperacion.execute(request, response);
            }
            case "cliente": {
                oContexto.setVista("jsp/cliente/list.jsp");
                oContexto.setClase("cliente");
                oContexto.setMetodo("list");
                oContexto.setFase("1");
                oContexto.setSearchingFor("cliente");
                oContexto.setClaseRetorno("contestacion");
                oContexto.setMetodoRetorno("new");
                oContexto.setFaseRetorno("1");
                oContexto.removeParam("id_cliente");
                ClienteList1 oOperacion = new ClienteList1();
                return oOperacion.execute(request, response);
            }
            default:
                oContexto.setVista("jsp/mensaje.jsp");
                ContestacionBean oContestacionBean = new ContestacionBean();
                ContestacionDao oContestacionDao = new ContestacionDao(oContexto.getEnumTipoConexion());
                ContestacionParam oContestacionParam = new ContestacionParam(request);
                oContestacionBean = oContestacionParam.loadId(oContestacionBean);
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
                String strMensaje = "Se ha añadido la información de contestacion con id=" + Integer.toString(oContestacionBean.getId()) + "<br />";
                strMensaje += "<a href=\"Controller?class=contestacion&method=list&filter=id_cliente&filteroperator=equals&filtervalue=" + oContestacionBean.getCliente().getId() + "\">Ver contestacions de este cliente</a><br />";
                strMensaje += "<a href=\"Controller?class=contestacion&method=view&id=" + oContestacionBean.getId() + "\">Ver contestacion creada</a><br />";
                return strMensaje;

        }
    }
}
