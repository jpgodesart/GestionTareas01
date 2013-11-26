/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.RepositorioBean;
import net.daw.dao.LenguajeDao;
import net.daw.helper.Contexto;
import net.daw.parameter.RepositorioParam;

/**
 *
 * @author al037793
 */
public class RepositorioNew1 implements Operation{
    
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        RepositorioParam oRepositorioParam = new RepositorioParam(request);
        RepositorioBean oRepositorioBean = new RepositorioBean();
        LenguajeDao oLenguajeDao = new LenguajeDao(oContexto.getEnumTipoConexion());
        try {
            oRepositorioBean = oRepositorioParam.load(oRepositorioBean);
            oRepositorioBean.setLenguaje(oLenguajeDao.get(oRepositorioBean.getLenguaje()));
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno delos campos del formulario";
        }
        oContexto.setVista("jsp/repositorio/form.jsp");        
        return oRepositorioBean;
    }
    
}
