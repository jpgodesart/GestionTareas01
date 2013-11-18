package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.daw.bean.HiloBean;
import net.daw.bean.UsuarioBean;
import net.daw.helper.Contexto;
import net.daw.parameter.HiloParam;

public class HiloNew1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        HiloParam oHiloParam = new HiloParam(request);
        HiloBean oHiloBean = new HiloBean();
        UsuarioBean oUsuarioBean = new UsuarioBean();
        HttpSession oSession = request.getSession();
        
        try {
            oHiloBean = oHiloParam.load(oHiloBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        oContexto.setVista("jsp/hilo/form.jsp");
        return oHiloBean;
    }

}
