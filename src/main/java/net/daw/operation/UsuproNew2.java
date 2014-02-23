/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.UsuproBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.UsuproDao;
import net.daw.helper.Contexto;
import net.daw.parameter.UsuproParam;

/**
 *
 * @author rafa
 */
public class UsuproNew2 implements Operation {

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
                    oContexto.setClaseRetorno("usupro");
                    oContexto.setMetodoRetorno("new");
                    oContexto.setFaseRetorno("1");
                    oContexto.removeParam("id_usuario");
                    UsuarioList1 oOperacion = new UsuarioList1();
                    return oOperacion.execute(request, response);
                }
                case "proyecto": {
                    oContexto.setVista("jsp/proyecto/list.jsp");
                    oContexto.setClase("proyecto");
                    oContexto.setMetodo("list");
                    oContexto.setFase("1");
                    oContexto.setSearchingFor("proyecto");
                    oContexto.setClaseRetorno("usupro");
                    oContexto.setMetodoRetorno("new");
                    oContexto.setFaseRetorno("1");
                    oContexto.removeParam("id_proyecto");
                    ProyectoList1 oOperacion = new ProyectoList1();
                    return oOperacion.execute(request, response);
                }
                default:
                    oContexto.setVista("jsp/mensaje.jsp");
                    UsuproBean oUsuproBean = new UsuproBean();
                    UsuproDao oUsuproDao = new UsuproDao(oContexto.getEnumTipoConexion());
                    UsuproParam oUsuproParam = new UsuproParam(request);
                    oUsuproBean = oUsuproParam.loadId(oUsuproBean);
                    try {
                        oUsuproBean = oUsuproParam.load(oUsuproBean);
                    } catch (NumberFormatException e) {
                        return "Tipo de dato incorrecto en uno de los campos del formulario";
                    }
                    try {
                        oUsuproDao.set(oUsuproBean);
                    } catch (Exception e) {
                        throw new ServletException("UsuproController: Update Error: Phase 2: " + e.getMessage());
                    }
                    String strMensaje = "Se ha añadido la información de usupro con id=" + Integer.toString(oUsuproBean.getId()) + "<br />";
                    strMensaje += "<a href=\"Controller?class=usupro&method=list&filter=id_usuario&filteroperator=equals&filtervalue=" + oUsuproBean.getUsuario().getId() + "\">Ver usupros de este usuario</a><br />";
                    strMensaje += "<a href=\"Controller?class=usupro&method=view&id=" + oUsuproBean.getId() + "\">Ver usupro creada</a><br />";
                    return strMensaje;

            }
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }

    }
}

