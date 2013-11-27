/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.RepositorioBean;
import net.daw.dao.RepositorioDao;
import net.daw.helper.Contexto;
import net.daw.parameter.RepositorioParam;

/**
 *
 * @author Ana 
 */
public class RepositorioUpdate1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/repositorio/form.jsp");
        RepositorioBean oRepositorioBean;
        RepositorioDao oRepositorioDao;
        oRepositorioBean = new RepositorioBean();
        RepositorioParam oRepositorioParam = new RepositorioParam(request);
        oRepositorioBean = oRepositorioParam.loadId(oRepositorioBean);
        oRepositorioDao = new RepositorioDao(oContexto.getEnumTipoConexion());
        try {
            oRepositorioBean = oRepositorioDao.get(oRepositorioBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 1: " + e.getMessage());
        }
        try{
        oRepositorioBean = oRepositorioParam.load(oRepositorioBean);
         }catch (NumberFormatException e){
             oContexto.setVista("jsp/mensaje.jsp");
             return "Tipo de dato incorrecto en uno de los campos del formulario";
         }
        return oRepositorioBean;
    }

}
