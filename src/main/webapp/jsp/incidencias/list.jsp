<%-- 
    Document   : list
    Created on : 09-nov-2013, 17:32:12
    Author     : Enrique
--%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="net.daw.bean.IncidenciasBean"%>
<%@ page import="net.daw.helper.Contexto"%>
<%
    Contexto oContexto = (Contexto) request.getAttribute("contexto");
    ArrayList<Object> alObjetoParametro = (ArrayList<Object>) oContexto.getParametro();
    ArrayList<IncidenciasBean> alPagina = (ArrayList<IncidenciasBean>) alObjetoParametro.get(0);
    Iterator<IncidenciasBean> oIterador = alPagina.listIterator();
%>
<div class="row-fluid">
    <div class="span9">
        <h1>Listado de incidencias</h1>
        <%
            if (!oIterador.hasNext()) {
                out.print("<h4>Listado vacío</h4>");
            } else {
        %>
        <%
            if (oContexto.getHmOrder() != null) {
                out.print("<p>Listado ordenado por " + oContexto.getHmOrder().keySet().toArray()[0].toString() + "    ");
                out.print("<a href=\"Controller?" + oContexto.getSerializedParamsExceptOrder() + "\">(Quitar orden)</a></p>");
            } else {
                out.print("<p>Sin ordenar</p>");
            }
        %>
        <%
            if (oContexto.getHmFilter() != null) {
                out.print("<p>Listado filtrado por " + oContexto.getHmFilter().keySet().toArray()[0].toString() + "    ");
                out.print("<a href=\"Controller?" + oContexto.getSerializedParamsExceptFilter() + "\">(Quitar filtro)</a></p>");
            } else {
                out.print("<p>Sin filtrar</p>");
            }
        %>
        <%
            ArrayList<String> paginacion = (ArrayList<String>) alObjetoParametro.get(1);
            Iterator<String> iterador2 = paginacion.listIterator();
            while (iterador2.hasNext()) {
                String o = iterador2.next();
                out.print(o);
            }
        %>
    </div>
    <div class="span3">
        <div class="text-right">
            <legend>Filtro de incidencias</legend> 
            <form class="navbar-form pull-right" action="Controller" method="post" id="incidenciasForm">
                <fieldset>                                               
                    <%=oContexto.getSerializedParamsExceptFilterFormFormat()%>       
                    <span>
                        <select id="filter" name="filter" width="80" style="width: 80px">
                            <option>id</option>
                            <option>resumen</option>
                            <option>cambios</option>
                            <option>id_estado</option>
                            <option>id_repositorio</option>
                            <option>id_usuario</option>
                            <option>fechaalta</option>
                            <option>fecharesolucion</option>
                        </select>                        
                        <input id="filtervalue" name="filtervalue" type="text" size="20" maxlength="50" value=""  width="100" style="width: 100px"/>
                    </span>
                    <span>
                        <input type="submit" name="enviar" value="Filtrar" />
                    </span>
                </fieldset>
        </div>
    </div>
</div>
<table class="table table-hover table-condensed">
    <tr>
        <th>id
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=id&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=id&ordervalue=desc"><i class="icon-arrow-down"></i></a>
        </th>
        <th>resumen
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=nombre&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=nombre&ordervalue=desc"><i class="icon-arrow-down"></i></a>
        </th>
        <th>cambios
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=ape1&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=ape1&ordervalue=desc"><i class="icon-arrow-down"></i></a>
        </th>
        <th>id_estado
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=ape2&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=ape2&ordervalue=desc"><i class="icon-arrow-down"></i></a>        
        </th>
        <th>id_repositorio
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=desc"><i class="icon-arrow-down"></i></a>         
        </th>
        <th>id_usuario
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=desc"><i class="icon-arrow-down"></i></a>         
        </th>
        <th>fechaalta
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=desc"><i class="icon-arrow-down"></i></a>         
        </th>
        <th>fecharesolucion
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=asc"><i class="icon-arrow-up"></i></a>
            <a href="Controller?<%=oContexto.getSerializedParamsExceptOrder()%>&order=email&ordervalue=desc"><i class="icon-arrow-down"></i></a>         
        </th>
        <th>Operaciones</th>
    </tr>
    <%        while (oIterador.hasNext()) {
            IncidenciasBean oIncidenciasBean = oIterador.next();
    %>
    <tr>
        <td><%=oIncidenciasBean.getId()%></td>
        <td><%=oIncidenciasBean.getResumen()%></td>
        <td><%=oIncidenciasBean.getCambios()%></td>
        <td><%=oIncidenciasBean.getId_estado()%></td>
        <td><%=oIncidenciasBean.getId_repositorio()%></td>
        <td><%=oIncidenciasBean.getId_usuario()%></td>
        <td><%=oIncidenciasBean.getFechaAlta()%></td>
        <td><%=oIncidenciasBean.getFechaResolucion()%></td>
        <td>
            <div class="btn-toolbar">
                <div class="btn-group">                    
                    <a class="btn btn-mini" href="Controller?class=repositorio&method=view&id=<%=oIncidenciasBean.getId()%>"><i class="icon-eye-open"></i></a>                    
                    <a class="btn btn-mini" href="Controller?class=repositorio&method=update&id=<%=oIncidenciasBean.getId()%>"><i class="icon-pencil"></i></a>           
                    <a class="btn btn-mini" href="Controller?class=repositorio&method=remove&id=<%=oIncidenciasBean.getId()%>"><i class="icon-trash"></i></a>                         
                </div>
            </div>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>
