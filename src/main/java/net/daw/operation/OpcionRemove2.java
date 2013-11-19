package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.OpcionBean;
import net.daw.dao.OpcionDao;
import net.daw.helper.Contexto;
import net.daw.parameter.OpcionParam;

public class OpcionRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp"); 
        OpcionBean oOpcionBean = new OpcionBean();   
        OpcionParam oOpcionParam = new OpcionParam(request);
        oOpcionBean = oOpcionParam.loadId(oOpcionBean);
        try {
            OpcionDao oOpcionDAO = new OpcionDao(oContexto.getEnumTipoConexion());
            oOpcionDAO.remove(oOpcionBean);
        } catch (Exception e) {
            throw new ServletException("OpcionController: Remove Error: " + e.getMessage());
        }
        String Mensaje = ("Se ha eliminado la información del opcion con id=" + Integer.toString(oOpcionBean.getId()));
        return Mensaje;
    }

}
