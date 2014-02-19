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
public class TareaUpdate1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/tarea/form.jsp");
        TareaBean oTareaBean;
        TareaDao oTareaDao;
        oTareaBean = new TareaBean();
        TareaParam oTareaParam = new TareaParam(request);
        oTareaBean = oTareaParam.loadId(oTareaBean);
        oTareaDao = new TareaDao(oContexto.getEnumTipoConexion());
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {
            try {
                oTareaBean = oTareaDao.get(oTareaBean);
            } catch (Exception e) {
                throw new ServletException("TareaController: Update Error: Phase 1: " + e.getMessage());
            }
            try {
                oTareaBean = oTareaParam.load(oTareaBean);
            } catch (NumberFormatException e) {
                oContexto.setVista("jsp/mensaje.jsp");
                return "Tipo de dato incorrecto en uno de los campos del formulario";
            }
            return oTareaBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }
}

