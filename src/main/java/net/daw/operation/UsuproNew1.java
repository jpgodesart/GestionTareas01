/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.UsuproBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.UsuarioDao;
import net.daw.dao.UsuarioDao;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.UsuproParam;

/**
 *
 * @author rafa
 */
public class UsuproNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        UsuproParam oUsuproParam = new UsuproParam(request);
        UsuproBean oUsuproBean = new UsuproBean();
        UsuarioDao oUsuarioDao = new UsuarioDao(oContexto.getEnumTipoConexion());
        ProyectoDao oProyectoDao = new ProyectoDao(oContexto.getEnumTipoConexion());
        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {

            try {
                oUsuproBean = oUsuproParam.load(oUsuproBean);
                oUsuproBean = oUsuproParam.load(oUsuproBean);
                oUsuproBean.setUsuario(oUsuarioDao.get(oUsuproBean.getUsuario()));
                oUsuproBean = oUsuproParam.load(oUsuproBean);
                oUsuproBean.setProyecto(oProyectoDao.get(oUsuproBean.getProyecto()));
            } catch (NumberFormatException e) {
                oContexto.setVista("jsp/mensaje.jsp");
                return "Tipo de dato incorrecto en uno de los campos del formulario";
            }
            oContexto.setVista("jsp/usupro/form.jsp");
            return oUsuproBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }

    }
}

