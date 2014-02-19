/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.TareaBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.TareaDao;
import net.daw.helper.Contexto;
import net.daw.parameter.TareaParam;

/**
 *
 * @author rafa
 */
public class TareaNew2 implements Operation {

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

                case "estado": {
                    oContexto.setVista("jsp/estado/list.jsp");
                    oContexto.setClase("estado");
                    oContexto.setMetodo("list");
                    oContexto.setFase("1");
                    oContexto.setSearchingFor("estado");
                    oContexto.setClaseRetorno("tarea");
                    oContexto.setMetodoRetorno("new");
                    oContexto.setFaseRetorno("1");
                    oContexto.removeParam("id_estado");
                    EstadoList1 oOperacion = new EstadoList1();
                    return oOperacion.execute(request, response);
                }
                case "proyecto": {
                    oContexto.setVista("jsp/proyecto/list.jsp");
                    oContexto.setClase("proyecto");
                    oContexto.setMetodo("list");
                    oContexto.setFase("1");
                    oContexto.setSearchingFor("proyecto");
                    oContexto.setClaseRetorno("tarea");
                    oContexto.setMetodoRetorno("new");
                    oContexto.setFaseRetorno("1");
                    oContexto.removeParam("id_proyecto");
                    ProyectoList1 oOperacion = new ProyectoList1();
                    return oOperacion.execute(request, response);
                }
                default:
                    oContexto.setVista("jsp/mensaje.jsp");
                    TareaBean oTareaBean = new TareaBean();
                    TareaDao oTareaDao = new TareaDao(oContexto.getEnumTipoConexion());
                    TareaParam oTareaParam = new TareaParam(request);
                    oTareaBean = oTareaParam.loadId(oTareaBean);
                    try {
                        oTareaBean = oTareaParam.load(oTareaBean);
                    } catch (NumberFormatException e) {
                        return "Tipo de dato incorrecto en uno de los campos del formulario";
                    }
                    try {
                        oTareaDao.set(oTareaBean);
                    } catch (Exception e) {
                        throw new ServletException("TareaController: Update Error: Phase 2: " + e.getMessage());
                    }
                    String strMensaje = "Se ha añadido la información de tarea con id=" + Integer.toString(oTareaBean.getId()) + "<br />";
                    strMensaje += "<a href=\"Controller?class=tarea&method=list&filter=id_estado&filteroperator=equals&filtervalue=" + oTareaBean.getEstado().getId() + "\">Ver tareas de este estado</a><br />";
                    strMensaje += "<a href=\"Controller?class=tarea&method=view&id=" + oTareaBean.getId() + "\">Ver tarea creada</a><br />";
                    return strMensaje;

            }
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }

    }
}

