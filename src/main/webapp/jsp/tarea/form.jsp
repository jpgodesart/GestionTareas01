<%-- 
    Document   : form
    Created on : 19-feb-2014, 12:31:40
    Author     : al037721
--%>

<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.TareaBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String nombre = "";
    String descripcion = "";
    String id_estado = "";
    String descEstado = "";
    String id_proyecto = "";
    String descProyecto = "";

    TareaBean oTareaBean = (TareaBean) oContexto.getParametro();
    id = oTareaBean.getId();
    nombre = oTareaBean.getNombre();
    descripcion = oTareaBean.getDescripcion();

    id_estado = Integer.toString(oTareaBean.getEstado().getId());
    if (oTareaBean.getEstado().getId() > 0) {
        descEstado = oTareaBean.getEstado().getNombre();
    }

    id_proyecto = Integer.toString(oTareaBean.getProyecto().getId());
    if (oTareaBean.getProyecto().getId() > 0) {
        descProyecto = oTareaBean.getProyecto().getNombre();
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
<h1><%=strTitulo%> de tarea</h1>
<form class="form-horizontal" action="Controller" method="post" id="tareaForm">
    <fieldset>
        <legend>Formulario de tarea</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="tarea" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
        </div>
        <div class="control-group">
            <div class="control-group">
                <label class="control-label" for="nombre">Nombre: </label> 
                <div class="controls">
                    <input <%=strControlEnabled%> id="nombre" name="nombre" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=nombre%>" /><br />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="descripcion">Descripcion: </label> 
                <div class="controls">
                    <input <%=strControlEnabled%> id="descripcion" name="descripcion" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=descripcion%>" /><br />
                </div>
            </div>    

            <label class="control-label" for="id_estado">Estado </label>
            <div class="controls">                
                <input readonly="true" id="id_estado" class="input-mini"
                       name="id_estado" type="text" size="5" maxlength="5"
                       value="<%=id_estado%>" />  
                <input <%=strControlEnabled%> type="submit" name="searchingfor" value="estado" />
                <span class="alert alert-success"><%=descEstado%></span>
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