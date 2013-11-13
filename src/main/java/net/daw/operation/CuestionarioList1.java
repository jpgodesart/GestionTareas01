/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operation;

/**
 *
 * @author al037213
 */

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.CuestionarioBean;
import net.daw.dao.CuestionarioDao;
import net.daw.helper.Contexto;

public class CuestionarioList1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/cuestionario/list.jsp");
        try {
            CuestionarioDao oCuestionarioDAO = new CuestionarioDao(oContexto.getEnumTipoConexion());
            Integer intPages = oCuestionarioDAO.getPages(oContexto.getNrpp(),null,null);
            if (oContexto.getPage() >= intPages) {
                oContexto.setPage(intPages);
            }
            ArrayList<CuestionarioBean> listado = (ArrayList<CuestionarioBean>) oCuestionarioDAO.getPage(oContexto.getNrpp(), oContexto.getPage(),null,null);
            ArrayList<String> vecindad = (ArrayList<String>) oCuestionarioDAO.getNeighborhood("<a href=\"Controller?class=cuestionario&method=list&rpp=" + oContexto.getNrpp() + "&page=", oContexto.getPage(), intPages, 2);
            ArrayList<Object> a = new ArrayList<>();
            a.add(listado);
            a.add(vecindad);
            return a;
        } catch (Exception e) {
            throw new ServletException("CuestionarioList1: View Error: " + e.getMessage());
        }
    }
}
