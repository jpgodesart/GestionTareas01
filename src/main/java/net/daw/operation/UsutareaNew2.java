/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.UsutareaBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.UsutareaDao;
import net.daw.helper.Contexto;
import net.daw.parameter.UsutareaParam;

/**
 *
 * @author rafa
 */
public class UsutareaNew2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {
            switch (oContexto.getSearchingFor()) {

                case "usuario": {
                    oContexto.setVista("jsp/usuario/list.jsp");
                    oContexto.setClase("usuario");
                    oContexto.setMetodo("list");
                    oContexto.setFase("1");
                    oContexto.setSearchingFor("usuario");
                    oContexto.setClaseRetorno("usutarea");
                    oContexto.setMetodoRetorno("new");
                    oContexto.setFaseRetorno("1");
                    oContexto.removeParam("id_usuario");
                    UsuarioList1 oOperacion = new UsuarioList1();
                    return oOperacion.execute(request, response);
                }
                case "tarea": {
                    oContexto.setVista("jsp/tarea/list.jsp");
                    oContexto.setClase("tarea");
                    oContexto.setMetodo("list");
                    oContexto.setFase("1");
                    oContexto.setSearchingFor("tarea");
                    oContexto.setClaseRetorno("usutarea");
                    oContexto.setMetodoRetorno("new");
                    oContexto.setFaseRetorno("1");
                    oContexto.removeParam("id_tarea");
                    TareaList1 oOperacion = new TareaList1();
                    return oOperacion.execute(request, response);
                }
                default:
                    oContexto.setVista("jsp/mensaje.jsp");
                    UsutareaBean oUsutareaBean = new UsutareaBean();
                    UsutareaDao oUsutareaDao = new UsutareaDao(oContexto.getEnumTipoConexion());
                    UsutareaParam oUsutareaParam = new UsutareaParam(request);
                    oUsutareaBean = oUsutareaParam.loadId(oUsutareaBean);
                    try {
                        oUsutareaBean = oUsutareaParam.load(oUsutareaBean);
                    } catch (NumberFormatException e) {
                        return "Tipo de dato incorrecto en uno de los campos del formulario";
                    }
                    try {
                        oUsutareaDao.set(oUsutareaBean);
                    } catch (Exception e) {
                        throw new ServletException("UsutareaController: Update Error: Phase 2: " + e.getMessage());
                    }
                    String strMensaje = "Se ha añadido la información de usutarea con id=" + Integer.toString(oUsutareaBean.getId()) + "<br />";
                    strMensaje += "<a href=\"Controller?class=usutarea&method=list&filter=id_usuario&filteroperator=equals&filtervalue=" + oUsutareaBean.getUsuario().getId() + "\">Ver usutareas de este usuario</a><br />";
                    strMensaje += "<a href=\"Controller?class=usutarea&method=view&id=" + oUsutareaBean.getId() + "\">Ver usutarea creada</a><br />";
                    return strMensaje;

            }
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }

    }
}

