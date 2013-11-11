<%-- 
    Document   : form
    Created on : 07-nov-2013, 12:20:07
    Author     : al037431
--%>

<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="net.daw.helper.Enum.Connection"%>
<%@page import="net.daw.data.Mysql"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.daw.bean.IncidenciasBean"%>
<%@page import="net.daw.helper.Contexto"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    Integer id_usuario = 0;
    String resumen = "";
    String cambios = "";
    Integer id_estado = 0;
    Integer id_repositorio = 0;
    String fechaAlta = "";
    String fechaResolucion = "";

    if (oContexto.getMetodo().equals("update") || oContexto.getMetodo().equals("view")) {
        IncidenciasBean oIncidenciasBean = (IncidenciasBean) oContexto.getParametro();
        id = oIncidenciasBean.getId();
        resumen = oIncidenciasBean.getResumen();
        cambios = oIncidenciasBean.getCambios();
        id_estado = oIncidenciasBean.getId_estado();
        id_repositorio = oIncidenciasBean.getId_repositorio();
        id_usuario = oIncidenciasBean.getId_usuario();
        fechaAlta = oIncidenciasBean.getFechaAlta();
        fechaResolucion = oIncidenciasBean.getFechaResolucion();
    }
    if (oContexto.getMetodo().equals("view")) {
        strTitulo = "Vista";
        strControlEnabled = "disabled=\"true\"";
        strValueBoton = "Cerrar";
    }
    if (oContexto.getMetodo().equals("update")) {
        strTitulo = "Edición";
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strTitulo = "Alta";
        strValueBoton = "Crear";
    }
/*
    if (oContexto.getMetodo().equals("new")) {
        Mysql oMysql;
        net.daw.helper.Enum.Connection enumTipoConexion;
        oMysql = new Mysql();
        oMysql.conexion(Connection.DataSource);
        
        id_estado = Integer.parseInt(oMysql.getId("estado", "true", "true"));
    }*/

%>
<h1><%=strTitulo%> de cliente</h1>
<form class="semantic" action="Controller" method="post" id="incidenciasForm">
    <fieldset>
        <legend>Formulario de Incidencias</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="incidencias" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div>
            <label for="Resumen_incidencias">Resumen Incidencias </label> 
            <input <%=strControlEnabled%> id="Resumen_incidencias" name="Resumen_incidencias" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=resumen%>" /><br />
        </div>
        <div>
            <label for="cambios">Cambios </label>
            <textarea <%=strControlEnabled%> id="cambios" name="cambios" type="text" size="30" maxlength="50" value="<%=cambios%>" ></textarea><br />
        </div>

        <div>
            <label for="fechaAlta">Fecha Alta: </label> 
            <input <%=strControlEnabled%> id="fechaAlta" name="fechaAlta" type="date" size="30" maxlength="50" value="<%=fechaAlta%>" /> <br />
        </div>
        <div>
            <label for="fechaResolucion">Fecha Resolución: </label> 
            <input <%=strControlEnabled%> id="fechaResolucion" name="fechaResolucion" type="date" size="30" maxlength="50" value="<%=fechaResolucion%>" /> <br />
        </div>
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>
