<%-- 
    Document   : form
    Created on : 20-nov-2013, 12:13:39
    Author     : al037431
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.IncidenciasBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String id_usuario = "";
    String resumen = "";
    String cambios = "";
    String id_estado = "";
    String id_repositorio = "";
    String fechaAlta = "";
    String fechaResolucion = "";
    String nomid_estado = "";
    String titid_repositorio = "";
    String descUsuario = "";

    IncidenciasBean oIncidenciasBean = (IncidenciasBean) oContexto.getParametro();
    id = oIncidenciasBean.getId();
    id_usuario = Integer.toString(oIncidenciasBean.getUsuario().getId());
    if (!(oIncidenciasBean.getUsuario().getId().equals("") && oIncidenciasBean.getUsuario().getId().equals(""))) {
        descUsuario = oIncidenciasBean.getUsuario().getId() + " " + oIncidenciasBean.getUsuario().getId();
    }
    id_producto = Integer.toString(oIncidenciasBean.getProducto().getId());
    if (oIncidenciasBean.getProducto().getId() > 0) {
        descProducto = oIncidenciasBean.getProducto().getDescripcion();
    }
    cantidad = oIncidenciasBean.getCantidad().toString();
    fecha = new SimpleDateFormat("yyyy-MM-dd").format(oIncidenciasBean.getFecha());

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
<h1><%=strTitulo%> de compra</h1>
<form class="form-horizontal" action="Controller" method="post" id="usuarioForm">
    <legend>Formulario de compra</legend>
    <input type="hidden" name="id" value="<%=id%>" /> 
    <input type="hidden" name="class" value="compra" /> 
    <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
    <input type="hidden" name="phase" value="2" />
    <div class="control-group">
        <label class="control-label" for="id_producto">Producto: </label> 
        <div class="controls">                
            <input readonly="true" id="id_producto" class="input-mini"
                   name="id_producto" type="text" size="5" maxlength="5"
                   value="<%=id_producto%>" />  
            <input <%=strControlEnabled%> type="submit" name="searchingfor" value="producto" />
            <span class="alert alert-success"><%=descProducto%></span>
        </div>
    </div>             

    <div class="control-group">
        <label class="control-label" for="id_usuario">Usuario: </label> 
        <div class="controls">                
            <input readonly="true" id="id_usuario" class="input-mini"
                   name="id_usuario" type="text" size="5" maxlength="5"
                   value="<%=id_usuario%>" />  
            <input <%=strControlEnabled%> type="submit" name="searchingfor" value="usuario" />
            <span class="alert alert-success"><%=descUsuario%></span>
        </div>
    </div>             
    <div class="control-group">
        <label class="control-label" for="precio">Cantidad: </label> 
        <div class="controls">
            <input <%=strControlEnabled%>  id="cantidad"
                                           name="cantidad" type="text" size="30" maxlength="50"
                                           value="<%=cantidad%>"  /> 
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="fecha">Fecha: </label> 
        <div class="controls">
            <input <%=strControlEnabled%>  id="fecha"
                                           name="fecha" type="date" size="30" maxlength="50"
                                           value="<%=fecha%>" /> 
        </div> 
    </div>
    <div class="control-group">
        <div class="controls">
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </div>
</form>