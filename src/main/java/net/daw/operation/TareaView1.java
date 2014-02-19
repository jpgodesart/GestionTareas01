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
import net.daw.dao.UsuarioDao;
import net.daw.dao.TareaDao;
import net.daw.dao.ProyectoDao;
import net.daw.dao.EstadoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.TareaParam;

/**
 *
 * @author rafa
 */
public class TareaView1 implements Operation {

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
        EstadoDao oEstadoDao = new EstadoDao(oContexto.getEnumTipoConexion());
        ProyectoDao oProyectoDao = new ProyectoDao(oContexto.getEnumTipoConexion());

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)
                || tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Alumno)) {
            try {
                oTareaBean = oTareaDao.get(oTareaBean);
                oTareaBean.setEstado(oEstadoDao.get(oTareaBean.getEstado()));
                oTareaBean.setProyecto(oProyectoDao.get(oTareaBean.getProyecto()));
            } catch (Exception e) {
                throw new ServletException("UsuarioController: View Error: Phase 1: " + e.getMessage());
            }

            return oTareaBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";
        }
    }
}