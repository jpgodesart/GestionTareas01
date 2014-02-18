package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProyectoBean;
import net.daw.bean.UsuarioBean;
import net.daw.helper.Contexto;
import net.daw.parameter.ProyectoParam;

public class ProyectoNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");

        //Parte para saber el tipo de usuario
        UsuarioBean oUsuarioBean;
        oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
        java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
        //

        ProyectoParam oProyectoParam = new ProyectoParam(request);
        ProyectoBean oProyectoBean = new ProyectoBean();

        //Validacion
        if (tipoUsuario.equals(net.daw.helper.Enum.TipoUsuario.Profesor)) {

            try {
                oProyectoBean = oProyectoParam.load(oProyectoBean);
            } catch (NumberFormatException e) {
                oContexto.setVista("jsp/mensaje.jsp");
                return "Tipo de dato incorrecto en uno de los campos del formulario";
            }
            oContexto.setVista("jsp/proyecto/form.jsp");
            return oProyectoBean;
        } else {
            //Mostramos el MENSAJE
            oContexto.setVista("jsp/mensaje.jsp");
            return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";

        }
    }
}

