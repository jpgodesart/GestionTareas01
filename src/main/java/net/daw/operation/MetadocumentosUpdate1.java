/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.MetadocumentosBean;
import net.daw.dao.MetadocumentosDao;
import net.daw.helper.Contexto;
import net.daw.parameter.MetadocumentosParam;

/**
 *
 * @author Alvaro
 */
public class MetadocumentosUpdate1 implements Operation{
    
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/metadocumentos/form.jsp");
        MetadocumentosBean oMetadocumentosBean;
        MetadocumentosDao oMetadocumentosDao;
        oMetadocumentosBean = new MetadocumentosBean();
        MetadocumentosParam oMetadocumentosParam = new MetadocumentosParam(request);
        oMetadocumentosBean = oMetadocumentosParam.loadId(oMetadocumentosBean);
        oMetadocumentosDao = new MetadocumentosDao(oContexto.getEnumTipoConexion());
        try {
            oMetadocumentosBean = oMetadocumentosDao.get(oMetadocumentosBean);
        } catch (Exception e) {
            throw new ServletException("MetadocumentosController: Update Error: Phase 1: " + e.getMessage());
        }
        try {
            oMetadocumentosBean = oMetadocumentosParam.load(oMetadocumentosBean);
        } catch (NumberFormatException e) {
            oContexto.setVista("jsp/mensaje.jsp");
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        }
        return oMetadocumentosBean;
    }
}
