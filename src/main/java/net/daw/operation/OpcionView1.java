package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.OpcionBean;
import net.daw.dao.OpcionDao;
import net.daw.helper.Contexto;
import net.daw.parameter.OpcionParam;

/**
 *
 * @author rafael aznar
 */
public class OpcionView1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/opcion/form.jsp");        
        OpcionBean oOpcionBean;
        OpcionDao oOpcionDao;
        oOpcionBean = new OpcionBean();
        OpcionParam oOpcionParam = new OpcionParam(request);
        oOpcionBean = oOpcionParam.loadId(oOpcionBean);
        oOpcionDao = new OpcionDao(oContexto.getEnumTipoConexion());
        try {
            oOpcionBean = oOpcionDao.get(oOpcionBean);
        } catch (Exception e) {
            throw new ServletException("OpcionController: View Error: Phase 1: " + e.getMessage());
        }
        oOpcionBean = oOpcionParam.load(oOpcionBean);
        return oOpcionBean;
    }
}
