<%-- 
    Document   : form
    Created on : 24-feb-2014, 8:39:24
    Author     : al037721
--%>

<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.UsuproBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String id_usuario = "";
    String descUsuario = "";
    String id_proyecto = "";
    String descProyecto = "";

    UsuproBean oUsuproBean = (UsuproBean) oContexto.getParametro();
    id = oUsuproBean.getId();

    id_usuario = Integer.toString(oUsuproBean.getUsuario().getId());
    if (oUsuproBean.getUsuario().getId() > 0) {
        descUsuario = oUsuproBean.getUsuario().getLogin();
    }

    id_proyecto = Integer.toString(oUsuproBean.getProyecto().getId());
    if (oUsuproBean.getProyecto().getId() > 0) {
        descProyecto = oUsuproBean.getProyecto().getNombre();
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
<h1><%=strTitulo%> de usupro</h1>
<form class="form-horizontal" action="Controller" method="post" id="usuproForm">
    <fieldset>
        <legend>Formulario de usupro</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="usupro" /> 
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
            <label class="control-label" for="id_proyecto">Proyecto </label>
            <div class="controls">                
                <input readonly="true" id="id_proyecto" class="input-mini"
                       name="id_proyecto" type="text" size="5" maxlength="5"
                       value="<%=id_proyecto%>" />  
                <input <%=strControlEnabled%> type="submit" name="searchingfor" value="proyecto" />
                <span class="alert alert-success"><%=descProyecto%></span>
            </div>
        </div> 
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>
