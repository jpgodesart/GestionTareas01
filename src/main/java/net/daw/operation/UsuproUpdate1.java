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
public class UsuproUpdate1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/usupro/form.jsp");
        UsuproBean oUsuproBean;
        UsuproDao oUsuproDao;
        oUsuproBean = new UsuproBean();
        UsuproParam oUsuproParam = new UsuproParam(request);
        oUsuproBean = oUsuproParam.loadId(oUsuproBean);
        oUsuproDao = new UsuproDao(oContexto.getEnumTipoConexion());
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {
            try {
                oUsuproBean = oUsuproDao.get(oUsuproBean);
            } catch (Exception e) {
                throw new ServletException("UsuproController: Update Error: Phase 1: " + e.getMessage());
            }
            try {
                oUsuproBean = oUsuproParam.load(oUsuproBean);
            } catch (NumberFormatException e) {
                oContexto.setVista("jsp/mensaje.jsp");
                return "Tipo de dato incorrecto en uno de los campos del formulario";
            }
            return oUsuproBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }
}

