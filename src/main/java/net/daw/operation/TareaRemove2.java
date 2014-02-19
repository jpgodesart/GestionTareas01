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
public class TareaRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/mensaje.jsp");
        TareaBean oTareaBean = new TareaBean();
        TareaParam oTareaParam = new TareaParam(request);
        oTareaBean = oTareaParam.loadId(oTareaBean);

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {

            try {
                TareaDao oTareaDAO = new TareaDao(oContexto.getEnumTipoConexion());
                oTareaDAO.remove(oTareaBean);
            } catch (Exception e) {
                throw new ServletException("TareaController: Remove Error: " + e.getMessage());
            }
            String strMensaje = "Se ha eliminado la información de la tarea con id=" + Integer.toString(oTareaBean.getId()) + "<br />";
            strMensaje += "<a href=\"Controller?class=tarea&method=list\">Ir al listado de tareas</a><br />";
            String Mensaje = strMensaje;
            return Mensaje;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }

}
