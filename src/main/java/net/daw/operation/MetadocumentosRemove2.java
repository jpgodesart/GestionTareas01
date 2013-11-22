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
public class MetadocumentosRemove2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        MetadocumentosBean oMetadocumentosBean = new MetadocumentosBean();
        MetadocumentosParam oMetadocumentosParam = new MetadocumentosParam(request);
        oMetadocumentosBean = oMetadocumentosParam.loadId(oMetadocumentosBean);
        try {
            MetadocumentosDao oMetadocumentosDAO = new MetadocumentosDao(oContexto.getEnumTipoConexion());
            oMetadocumentosDAO.remove(oMetadocumentosBean);
        } catch (Exception e) {
            throw new ServletException("MetadocumentosController: Remove Error: " + e.getMessage());
        }
        String strMensaje = "Se ha eliminado la información de la metadocumentos con id=" + Integer.toString(oMetadocumentosBean.getId()) + "<br />";
        strMensaje += "<a href=\"Controller?class=metadocumentos&method=list\">Ir al listado de metadocumentoss</a><br />";
        String Mensaje = strMensaje;
        return Mensaje;
    }
}
