<%@page import="java.text.SimpleDateFormat"%>
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
    String id_usuario = "";
    String titulo = "";
    String contenido = "";
    String id_documento = "";
    String fecha = "";
    String descDocumento ="";
    String descUsuario ="";


    IncidenciasBean oIncidenciasBean = (IncidenciasBean) oContexto.getParametro();
    id = oIncidenciasBean.getId();
    titulo = oIncidenciasBean.getTitulo();
    contenido = oIncidenciasBean.getContenido();
    
    id_usuario = Integer.toString(oIncidenciasBean.getId_usuario().getId());
    if (oIncidenciasBean.getId_usuario().getId() > 0) {
        descUsuario = oIncidenciasBean.getId_usuario().getLogin();
    }
    if (oIncidenciasBean.getId_documento().getId() > 0) {
        descDocumento = oIncidenciasBean.getId_documento().getTitulo();
    }
    fecha = new SimpleDateFormat("yyyy-MM-dd").format(oIncidenciasBean.getFecha());



    if (oContexto.getMetodo().equals("update")) {
        strTitulo = "Edición";
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strTitulo = "Alta";
        strValueBoton = "Crear";
    }

    if (oContexto.getMetodo().equals("view")) {
        strTitulo = "Vista";
        strControlEnabled = "disabled=\"true\"";
        strValueBoton = "Cerrar";
    } else {
        strValueBoton = "Guardar";
    }
%>
<h1><%=strTitulo%> de Incidenciasario</h1>
<form class="semantic" action="Controller" method="post" id="comentForm">
    <fieldset>
        <legend>Formulario de Incidenciasario</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="coment" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
            <label for="titulo">Título: </label> 
            <input <%=strControlEnabled%> id="titulo" name="titulo" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=titulo%>" /><br />
        </div>
        <div class="control-group">
            <label for="contenido">Contenido: </label>
            <textarea <%=strControlEnabled%> id="contenido" name="contenido" type="text" size="30" maxlength="50" ><%=contenido%></textarea><br />
        </div>

        <div class="control-group">
            <label class="control-label" for="fecha">Fecha: </label> 
            <div class="controls">
                <input <%=strControlEnabled%>  id="fecha" name="fecha" type="date" size="30" maxlength="50" value="<%=fecha%>" /></div> 
        </div>
        <div class="control-group">
            <label class="control-label" for="id_usuario">Usuario: </label> 
            <div class="controls">                
                <input readonly="true" id="id_usuario" class="input-mini" name="id_usuario" type="text" size="5" maxlength="5" value="<%=id_usuario%>" />  
                <input <%=strControlEnabled%> type="submit" name="searchingfor" value="usuario" />
                <span class="alert alert-success"><%=descUsuario%></span>
            </div>
        </div> 
        <div class="control-group">
            <label class="control-label" for="id_documento">Documento: </label> 
            <div class="controls">                
                <input readonly="true" id="id_documento" class="input-mini"
                       name="id_documento" type="text" size="5" maxlength="5" value="<%=id_documento%>" />  
                <input <%=strControlEnabled%> type="submit" name="searchingfor" value="documento" />
                <span class="alert alert-success"><%=descDocumento%></span>
            </div>
        </div> 
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>