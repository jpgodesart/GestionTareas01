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
import net.daw.dao.UsuarioDao;
import net.daw.dao.UsutareaDao;
import net.daw.dao.TareaDao;
import net.daw.dao.UsuarioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.UsutareaParam;

/**
 *
 * @author rafa
 */
public class UsutareaView1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/usutarea/form.jsp");
        UsutareaBean oUsutareaBean;
        UsutareaDao oUsutareaDao;
        oUsutareaBean = new UsutareaBean();
        UsutareaParam oUsutareaParam = new UsutareaParam(request);
        oUsutareaBean = oUsutareaParam.loadId(oUsutareaBean);
        oUsutareaDao = new UsutareaDao(oContexto.getEnumTipoConexion());
        UsuarioDao oUsuarioDao = new UsuarioDao(oContexto.getEnumTipoConexion());
        TareaDao oTareaDao = new TareaDao(oContexto.getEnumTipoConexion());

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)
                || tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Alumno)) {
            try {
                oUsutareaBean = oUsutareaDao.get(oUsutareaBean);
                oUsutareaBean.setUsuario(oUsuarioDao.get(oUsutareaBean.getUsuario()));
                oUsutareaBean.setTarea(oTareaDao.get(oUsutareaBean.getTarea()));
            } catch (Exception e) {
                throw new ServletException("UsuarioController: View Error: Phase 1: " + e.getMessage());
            }

            return oUsutareaBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";
        }
    }
}