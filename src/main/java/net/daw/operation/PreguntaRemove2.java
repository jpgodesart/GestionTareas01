package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.PreguntaBean;
import net.daw.dao.PreguntaDao;
import net.daw.helper.Contexto;
import net.daw.parameter.PreguntaParam;

public class PreguntaRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp"); 
        PreguntaBean oPreguntaBean = new PreguntaBean();   
        PreguntaParam oPreguntaParam = new PreguntaParam(request);
        oPreguntaBean = oPreguntaParam.loadId(oPreguntaBean);
        try {
            PreguntaDao oPreguntaDAO = new PreguntaDao(oContexto.getEnumTipoConexion());
            oPreguntaDAO.remove(oPreguntaBean);
        } catch (Exception e) {
            throw new ServletException("PreguntaController: Remove Error: " + e.getMessage());
        }
        String Mensaje = ("Se ha eliminado la información del pregunta con id=" + Integer.toString(oPreguntaBean.getId()));
        return Mensaje;
    }

}
