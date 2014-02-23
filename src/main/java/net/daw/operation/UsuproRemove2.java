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
public class UsuproRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/mensaje.jsp");
        UsuproBean oUsuproBean = new UsuproBean();
        UsuproParam oUsuproParam = new UsuproParam(request);
        oUsuproBean = oUsuproParam.loadId(oUsuproBean);

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {

            try {
                UsuproDao oUsuproDAO = new UsuproDao(oContexto.getEnumTipoConexion());
                oUsuproDAO.remove(oUsuproBean);
            } catch (Exception e) {
                throw new ServletException("UsuproController: Remove Error: " + e.getMessage());
            }
            String strMensaje = "Se ha eliminado la información de la usupro con id=" + Integer.toString(oUsuproBean.getId()) + "<br />";
            strMensaje += "<a href=\"Controller?class=usupro&method=list\">Ir al listado de usupros</a><br />";
            String Mensaje = strMensaje;
            return Mensaje;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }

}
