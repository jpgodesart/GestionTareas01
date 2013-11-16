package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.PreguntaBean;
import net.daw.helper.Contexto;
import net.daw.parameter.PreguntaParam;

public class PreguntaRemove1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/confirmForm.jsp");        
        PreguntaBean oPreguntaBean = new PreguntaBean();        
        PreguntaParam oPreguntaParam = new PreguntaParam(request);
        oPreguntaBean = oPreguntaParam.loadId(oPreguntaBean);
        return "Borrar el pregunta " + oPreguntaBean.getId();
    }
}
