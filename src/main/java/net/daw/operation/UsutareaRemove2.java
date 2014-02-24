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
public class UsutareaRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/mensaje.jsp");
        UsutareaBean oUsutareaBean = new UsutareaBean();
        UsutareaParam oUsutareaParam = new UsutareaParam(request);
        oUsutareaBean = oUsutareaParam.loadId(oUsutareaBean);

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {

            try {
                UsutareaDao oUsutareaDAO = new UsutareaDao(oContexto.getEnumTipoConexion());
                oUsutareaDAO.remove(oUsutareaBean);
            } catch (Exception e) {
                throw new ServletException("UsutareaController: Remove Error: " + e.getMessage());
            }
            String strMensaje = "Se ha eliminado la información de la usutarea con id=" + Integer.toString(oUsutareaBean.getId()) + "<br />";
            strMensaje += "<a href=\"Controller?class=usutarea&method=list\">Ir al listado de usutareas</a><br />";
            String Mensaje = strMensaje;
            return Mensaje;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }

}
