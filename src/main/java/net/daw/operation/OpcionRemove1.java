package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.OpcionBean;
import net.daw.helper.Contexto;
import net.daw.parameter.OpcionParam;

public class OpcionRemove1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/confirmForm.jsp");        
        OpcionBean oOpcionBean = new OpcionBean();        
        OpcionParam oOpcionParam = new OpcionParam(request);
        oOpcionBean = oOpcionParam.loadId(oOpcionBean);
        return "Borrar el opcion " + oOpcionBean.getId();
    }
}
