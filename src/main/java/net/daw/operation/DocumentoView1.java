/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import java.util.regex.MatchResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.DocumentoBean;
import net.daw.dao.DocumentoDao;
import net.daw.helper.Contexto;
import net.daw.helper.TextParser;
import net.daw.parameter.DocumentoParam;

/**
 *
 * @author al037294
 */
public class DocumentoView1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/documento/view.jsp");

        String str = "[http://github.com|Github] hola =miau= [http://intel.com|Intel]  hola ====jujujuj==== [http://google.es|Google]";
        
        DocumentoBean oDocumentoBean;
        DocumentoDao oDocumentoDao;
        oDocumentoBean = new DocumentoBean();
        DocumentoParam oDocumentoParam = new DocumentoParam(request);
        oDocumentoBean = oDocumentoParam.loadId(oDocumentoBean);
        oDocumentoDao = new DocumentoDao(oContexto.getEnumTipoConexion());
        try {
            oDocumentoBean = oDocumentoDao.get(oDocumentoBean);
            oDocumentoBean.setContenidoParse(TextParser.toHtml(oDocumentoBean.getContenido()));
        } catch (Exception e) {
            throw new ServletException("DocumentoController: View Error: Phase 1: " + e.getMessage());
        }
        oDocumentoBean = oDocumentoParam.load(oDocumentoBean);
        return oDocumentoBean;
    }
}
