package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.CuestionarioBean;
import net.daw.dao.CuestionarioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.CuestionarioParam;

/**
 *
 * @author rafael aznar
 */
public class CuestionarioView1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/cuestionario/form.jsp");        
        CuestionarioBean oCuestionarioBean;
        CuestionarioDao oCuestionarioDao;
        oCuestionarioBean = new CuestionarioBean();
        CuestionarioParam oCuestionarioParam = new CuestionarioParam(request);
        oCuestionarioBean = oCuestionarioParam.loadId(oCuestionarioBean);
        oCuestionarioDao = new CuestionarioDao(oContexto.getEnumTipoConexion());
        try {
            oCuestionarioBean = oCuestionarioDao.get(oCuestionarioBean);
        } catch (Exception e) {
            throw new ServletException("CuestionarioController: View Error: Phase 1: " + e.getMessage());
        }
        oCuestionarioBean = oCuestionarioParam.load(oCuestionarioBean);
        return oCuestionarioBean;
    }
}
