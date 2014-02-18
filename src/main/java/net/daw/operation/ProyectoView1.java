package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProyectoBean;
import net.daw.bean.UsuarioBean;
import net.daw.dao.ProyectoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ProyectoParam;

/**
 *
 * @author rafael aznar
 */
public class ProyectoView1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        oContexto.setVista("jsp/proyecto/form.jsp");
        ProyectoBean oProyectoBean;
        ProyectoDao oProyectoDao;
        oProyectoBean = new ProyectoBean();
        ProyectoParam oProyectoParam = new ProyectoParam(request);
        oProyectoBean = oProyectoParam.loadId(oProyectoBean);
        oProyectoDao = new ProyectoDao(oContexto.getEnumTipoConexion());

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)
                || tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Alumno)) {

            try {
                oProyectoBean = oProyectoDao.get(oProyectoBean);
            } catch (Exception e) {
                throw new ServletException("ProyectoController: View Error: Phase 1: " + e.getMessage());
            }
            oProyectoBean = oProyectoParam.load(oProyectoBean);
            return oProyectoBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";
        }
    }
}

