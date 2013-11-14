/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.VotoComentarioBean;
import net.daw.helper.Contexto;
import net.daw.parameter.VotoComentarioParam;

/**
 *
 * @author Diana Ortega
 */
public class VotoComentarioNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        VotoComentarioParam oVotoComentarioParam = new VotoComentarioParam(request);
        VotoComentarioBean oVotoComentarioBean = new VotoComentarioBean();
        try {
            oVotoComentarioBean = oVotoComentarioParam.load(oVotoComentarioBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        oContexto.setVista("jsp/votocomentario/form.jsp");
        return oVotoComentarioBean;
    }
}
