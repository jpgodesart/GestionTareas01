<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.ProyectoBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String nombre = "";
    String descripcion = "";


    ProyectoBean oProyectoBean = (ProyectoBean) oContexto.getParametro();
    id = oProyectoBean.getId();
    nombre = oProyectoBean.getNombre();
    descripcion = oProyectoBean.getDescripcion();
    

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
<h1><%=strTitulo%> de proyecto</h1>
<form class="form-horizontal" action="Controller" method="post" id="proyectoForm">
    <fieldset>
        <legend>Formulario de proyecto</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="proyecto" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
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
        
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>

