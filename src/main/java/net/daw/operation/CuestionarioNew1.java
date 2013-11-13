package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.CuestionarioBean;
import net.daw.helper.Contexto;
import net.daw.parameter.CuestionarioParam;

public class CuestionarioNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        CuestionarioParam oCuestionarioParam = new CuestionarioParam(request);
        CuestionarioBean oCuestionarioBean = new CuestionarioBean();       
        try {
            oCuestionarioBean = oCuestionarioParam.load(oCuestionarioBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        oContexto.setVista("jsp/cuestionario/form.jsp");
        return oCuestionarioBean;
    }

}
