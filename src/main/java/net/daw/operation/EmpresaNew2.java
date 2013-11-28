package net.daw.operation;

/**
 *
 * @author AntonioNP
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.EmpresaBean;
import net.daw.dao.EmpresaDao;
import net.daw.helper.Contexto;
import net.daw.parameter.EmpresaParam;


public class EmpresaNew2 implements Operation{
     @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        EmpresaBean oEmpresaBean = new EmpresaBean();
        EmpresaDao oEmpresaDao = new EmpresaDao(oContexto.getEnumTipoConexion());
        EmpresaParam oEmpresaParam = new EmpresaParam(request);
        oEmpresaBean = oEmpresaParam.loadId(oEmpresaBean);
        
        try {
            oEmpresaBean = oEmpresaParam.load(oEmpresaBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        try {
            oEmpresaDao.set(oEmpresaBean);
        } catch (Exception e) {
            throw new ServletException("EmpresaController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha añadido la información del empresa con id= " + Integer.toString(oEmpresaBean.getId());
    }
}
       