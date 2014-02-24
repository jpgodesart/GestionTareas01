<%-- 
    Document   : form
    Created on : 24-feb-2014, 8:39:24
    Author     : al037721
--%>

<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.UsutareaBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String id_usuario = "";
    String descUsuario = "";
    String id_tarea = "";
    String descTarea = "";

    UsutareaBean oUsutareaBean = (UsutareaBean) oContexto.getParametro();
    id = oUsutareaBean.getId();

    id_usuario = Integer.toString(oUsutareaBean.getUsuario().getId());
    if (oUsutareaBean.getUsuario().getId() > 0) {
        descUsuario = oUsutareaBean.getUsuario().getNombre();
    }

    id_tarea = Integer.toString(oUsutareaBean.getTarea().getId());
    if (oUsutareaBean.getTarea().getId() > 0) {
        descTarea = oUsutareaBean.getTarea().getNombre();
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
%>
<h1><%=strTitulo%> de usutarea</h1>
<form class="form-horizontal" action="Controller" method="post" id="usutareaForm">
    <fieldset>
        <legend>Formulario de usutarea</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="usutarea" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
        </div>
        <div class="control-group">
            <label class="control-label" for="id_usuario">Usuario </label>
            <div class="controls">                
                <input readonly="true" id="id_usuario" class="input-mini"
                       name="id_usuario" type="text" size="5" maxlength="5"
                       value="<%=id_usuario%>" />  
                <input <%=strControlEnabled%> type="submit" name="searchingfor" value="usuario" />
                <span class="alert alert-success"><%=descUsuario%></span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="id_tarea">Tarea </label>
            <div class="controls">                
                <input readonly="true" id="id_tarea" class="input-mini"
                       name="id_tarea" type="text" size="5" maxlength="5"
                       value="<%=id_tarea%>" />  
                <input <%=strControlEnabled%> type="submit" name="searchingfor" value="tarea" />
                <span class="alert alert-success"><%=descTarea%></span>
            </div>
        </div> 
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>
