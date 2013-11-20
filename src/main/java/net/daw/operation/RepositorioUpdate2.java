/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.RepositorioBean;
import net.daw.dao.RepositorioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.RepositorioParam;

/**
 *
 * @author al037294
 */
public class RepositorioUpdate2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        switch (oContexto.getSearchingFor()) {
            case "lenguaje": {
                oContexto.setVista("jsp/lenguaje/list.jsp");
                oContexto.setClase("lenguaje");
                oContexto.setMetodo("list");
                oContexto.setFase("1");
                oContexto.setSearchingFor("lenguaje");
                oContexto.setClaseRetorno("repositorio");
                oContexto.setMetodoRetorno("new");
                oContexto.setFaseRetorno("1");
                oContexto.removeParam("id_lenguaje");
                LenguajeList1 oOperacion = new LenguajeList1();
                return oOperacion.execute(request, response);
            }
            default:
                oContexto.setVista("jsp/mensaje.jsp");
                RepositorioBean oRepositorioBean = new RepositorioBean();
                RepositorioDao oRepositorioDao = new RepositorioDao(oContexto.getEnumTipoConexion());
                RepositorioParam oRepositorioParam = new RepositorioParam(request);
                oRepositorioBean = oRepositorioParam.loadId(oRepositorioBean);
                oRepositorioBean = oRepositorioDao.get(oRepositorioBean);
                try {
                    oRepositorioBean = oRepositorioParam.load(oRepositorioBean);
                } catch (NumberFormatException e) {
                    return "Tipo de dato incorrecto en uno de los campos del formulario";
                }
                try {
                    oRepositorioDao.set(oRepositorioBean);
                } catch (Exception e) {
                    throw new ServletException("RepositorioController: Update Error: Phase 2: " + e.getMessage());
                }

                String strMensaje = "Se ha cambiado la información de repositorio con id=" + Integer.toString(oRepositorioBean.getId()) + "<br />";
                //strMensaje += "<a href=\"Controller?class=compra&method=list&filter=id_cliente&filteroperator=equals&filtervalue=" + oCompraBean.getCliente().getId() + "\">Ver compras de este cliente</a><br />";
                //strMensaje += "<a href=\"Controller?class=compra&method=view&id=" + oCompraBean.getId() + "\">Ver compra creada en el formulario</a><br />";
                return strMensaje;

        }

    }
}
