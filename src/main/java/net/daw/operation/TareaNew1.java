/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.TareaBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.UsuarioDao;
import net.daw.dao.EstadoDao;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.TareaParam;

/**
 *
 * @author rafa
 */
public class TareaNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        TareaParam oTareaParam = new TareaParam(request);
        TareaBean oTareaBean = new TareaBean();
        EstadoDao oEstadoDao = new EstadoDao(oContexto.getEnumTipoConexion());
        ProyectoDao oProyectoDao = new ProyectoDao(oContexto.getEnumTipoConexion());
        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {

            try {
                oTareaBean = oTareaParam.load(oTareaBean);
                oTareaBean = oTareaParam.load(oTareaBean);
                oTareaBean.setEstado(oEstadoDao.get(oTareaBean.getEstado()));
                oTareaBean = oTareaParam.load(oTareaBean);
                oTareaBean.setProyecto(oProyectoDao.get(oTareaBean.getProyecto()));
            } catch (NumberFormatException e) {
                oContexto.setVista("jsp/mensaje.jsp");
                return "Tipo de dato incorrecto en uno de los campos del formulario";
            }
            oContexto.setVista("jsp/contestacion/form.jsp");
            return oTareaBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }

    }
}

