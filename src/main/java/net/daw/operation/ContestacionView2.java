
package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.helper.Contexto;

/**
 *
 * @author rafa
 */
public class ContestacionView2 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/contestacion/list.jsp");
        oContexto.setClase("contestacion");
        oContexto.setMetodo("list");
        oContexto.setFase("1");
        ContestacionList1 oOperacion = new ContestacionList1();
        return oOperacion.execute(request, response);
    }
}
