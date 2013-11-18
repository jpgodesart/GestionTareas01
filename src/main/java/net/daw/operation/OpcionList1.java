package net.daw.operation;

import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.OpcionBean;
import net.daw.dao.OpcionDao;
import net.daw.helper.Contexto;
import net.daw.helper.Pagination;

public class OpcionList1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/opcion/list.jsp");
        try {
            OpcionDao oOpcionDAO = new OpcionDao(oContexto.getEnumTipoConexion());
            Integer intPages = oOpcionDAO.getPages(oContexto.getNrpp(), oContexto.getAlFilter(), oContexto.getHmOrder());
            if (oContexto.getPage() >= intPages) {
                oContexto.setPage(intPages);
            }
            if (oContexto.getPage() < 1) {
                oContexto.setPage(1);   
            }
            ArrayList<OpcionBean> listado = (ArrayList<OpcionBean>) oOpcionDAO.getPage(oContexto.getNrpp(), oContexto.getPage(), oContexto.getAlFilter(), oContexto.getHmOrder());
            String strUrl = "<a href=\"Controller?" + oContexto.getSerializedParamsExceptPage() + "&page=";            
            //ArrayList<String> vecindad = (ArrayList<String>) oOpcionDAO.getNeighborhood(strUrl, oContexto.getPage(), intPages, 2);
            ArrayList<String> vecindad = Pagination.getButtonPad(strUrl, oContexto.getPage(), intPages, 2);
            ArrayList<Object> a = new ArrayList<>();
            a.add(listado);
            a.add(vecindad);
            return a;
        } catch (Exception e) {
            throw new ServletException("OpcionList1: View Error: " + e.getMessage());
        }
    }
}
