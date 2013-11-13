<%--
    Document   : form
    Created on : 13-nov-2013, 10:33:46
    Author     : al037570
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.CuestionarioBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String descripcion = "";
    String fecha = "";
    Integer evaluacion = 0;
    boolean activo = false;
    if (oContexto.getMetodo().equals("update") || oContexto.getMetodo().equals("view")) {
        CuestionarioBean oCuestionarioBean = (CuestionarioBean) oContexto.getParametro();
        id = oCuestionarioBean.getId();
        descripcion = oCuestionarioBean.getDescripcion();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(oCuestionarioBean.getFecha());
        evaluacion = oCuestionarioBean.getEvaluacion();
        activo = oCuestionarioBean.getActivo();
    }
    if (oContexto.getMetodo().equals("view")) {
        strControlEnabled = "disabled=\"true\"";
        strValueBoton = "Cerrar";
    }
    if (oContexto.getMetodo().equals("update")) {
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strValueBoton = "Crear";
    }
%>
<h1>Edición de cuestionario</h1>
<form class="semantic" action="Controller" method="post" id="cuestionarioForm">
    <fieldset>
        <legend>Formulario de cuestionario</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="cuestionario" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div>
            <label for="descripcion">Descripción: </label> 
            <input <%=strControlEnabled%> id="descripcion" name="descripcion" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=descripcion%>" /><br />
        </div>
        <div>
            <label for="fecha">Fecha: </label>
            <input <%=strControlEnabled%> id="ape1" name="fecha" type="text" size="30" maxlength="50" value="<%=fecha%>" /><br />
        </div>
        <div>
            <label for="evaluacion">Evaluacion: </label> 
            <input <%=strControlEnabled%> id="evaluacion" name="evaluacion" type="text" size="30" maxlength="50" value="<%=evaluacion%>" /> <br />
        </div>
        <div>
            <label for="activo">Activo: </label> 
            <input <%=strControlEnabled%> id="activo" name="activo" type="text" size="30" maxlength="50" value="<%=activo%>" /><br />
        </div>
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>