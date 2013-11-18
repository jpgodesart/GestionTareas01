package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.PreguntaBean;
import net.daw.dao.PreguntaDao;
import net.daw.dao.CuestionarioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.PreguntaParam;

public class PreguntaUpdate1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/pregunta/form.jsp");
        PreguntaBean oPreguntaBean;
        PreguntaDao oPreguntaDao;
        oPreguntaBean = new PreguntaBean();
        PreguntaParam oPreguntaParam = new PreguntaParam(request);
        oPreguntaBean = oPreguntaParam.loadId(oPreguntaBean);
        oPreguntaDao = new PreguntaDao(oContexto.getEnumTipoConexion());
        try {
            oPreguntaBean = oPreguntaDao.get(oPreguntaBean);
        } catch (Exception e) {
            throw new ServletException("PreguntaController: Update Error: Phase 1: " + e.getMessage());
        }

            try {
                oPreguntaBean = oPreguntaParam.load(oPreguntaBean);
            } catch (NumberFormatException e) {
                oContexto.setVista("jsp/mensaje.jsp");
                return "Tipo de dato incorrecto en uno de los campos del formulario";
            }

        CuestionarioDao oTipopreguntaDao = new CuestionarioDao(oContexto.getEnumTipoConexion());
        oPreguntaBean.setCuestionario(oTipopreguntaDao.get(oPreguntaBean.getCuestionario()));
        return oPreguntaBean;
    }
}
