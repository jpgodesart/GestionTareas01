/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

/**
 *
 * @author al037213
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProyectoBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ProyectoParam;

public class ProyectoUpdate2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/mensaje.jsp");
        ProyectoBean oProyectoBean = new ProyectoBean();
        ProyectoDao oProyectoDao = new ProyectoDao(oContexto.getEnumTipoConexion());
        ProyectoParam oProyectoParam = new ProyectoParam(request);
        oProyectoBean = oProyectoParam.loadId(oProyectoBean);
        oProyectoBean = oProyectoParam.load(oProyectoBean);

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {
            try {
                oProyectoDao.set(oProyectoBean);
            } catch (Exception e) {
                throw new ServletException("ProyectoController: Update Error: Phase 2: " + e.getMessage());
            }
            return "Se ha modificado la información del proyecto con id=" + Integer.toString(oProyectoBean.getId());
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }
}
