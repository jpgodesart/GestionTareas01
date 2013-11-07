/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.RepositorioBean;
import net.daw.helper.Contexto;

/**
 *
 * @author al037793
 */
public class RepositorioNew2 implements Operation {
    
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        RepositorioBean oRepositorioBean = new RepositorioBean();
        ClienteDao oClienteDao = new ClienteDao(oContexto.getEnumTipoConexion());
        ClienteParam oClienteParam = new ClienteParam(request);
        oClienteBean = oClienteParam.loadId(oClienteBean);
        try {
            oClienteBean = oClienteParam.load(oClienteBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        try {
            oClienteDao.set(oClienteBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha añadido la información del cliente con id=" + Integer.toString(oClienteBean.getId());
    }
    
}
