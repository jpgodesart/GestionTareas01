/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.RequerimientoBean;
import net.daw.dao.RequerimientoDao;
import net.daw.helper.Contexto;
import net.daw.helper.Pagination;

/**
 *
 * @author al037342
 */
public class RequerimientoList1 implements Operation {
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/requerimiento/list.jsp");
        try {
            RequerimientoDao oRequerimientoDAO = new RequerimientoDao(oContexto.getEnumTipoConexion());
            Integer intPages = oRequerimientoDAO.getPages(oContexto.getNrpp(), oContexto.getAlFilter(), oContexto.getHmOrder());
            if (oContexto.getPage() >= intPages) {
                oContexto.setPage(intPages);
            }
            if (oContexto.getPage() < 1) {
                oContexto.setPage(1);
            }
            ArrayList<RequerimientoBean> listado = oRequerimientoDAO.getPage(oContexto.getNrpp(), oContexto.getPage(), oContexto.getAlFilter(), oContexto.getHmOrder());
            String strUrl = "<a href=\"Controller?" + oContexto.getSerializedParamsExceptPage() + "&page=";            
            ArrayList<String> vecindad = Pagination.getButtonPad(strUrl, oContexto.getPage(), intPages, 2);
            ArrayList<Object> a = new ArrayList<>();
            a.add(listado);
            a.add(vecindad);
            return a;
        } catch (Exception e) {
            throw new ServletException("RequerimientoList1: View Error: " + e.getMessage());
        }
    }
}