<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.daw.bean.RepositorioBean"%>
<%@page import="net.daw.helper.Contexto"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String titulo = "";
    String contenido = "";
    Integer id_usuario = 0;
    String lenguaje = "";
    String nombreLengueje = "";
    Integer id_documento = 0;
    String fecha = "";


    RepositorioBean oRepositorioBean = (RepositorioBean) oContexto.getParametro();
    titulo = oRepositorioBean.getTitulo();
    contenido = oRepositorioBean.getTitulo();
    
    id = oRepositorioBean.getId();
    lenguaje = Integer.toString(oRepositorioBean.getLenguaje().getId());
    if (oRepositorioBean.getLenguaje().getId() > 0) {
        nombreLengueje = oRepositorioBean.getLenguaje().getNombre();
    }
    fecha = new SimpleDateFormat("yyyy-MM-dd").format(oRepositorioBean.getFecha());

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
<h1><%=strTitulo%> de repositorio</h1>
<form class="form-horizontal" action="Controller" method="post" id="repositorioForm">
    <legend>Formulario de Repositorio</legend>
    <input type="hidden" name="id" value="<%=id%>" /> 
    <input type="hidden" name="class" value="repositorio" /> 
    <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
    <input type="hidden" name="phase" value="2" />
    <div class="control-group">
        <label class="control-label" for="titulo">Titulo: </label> 
        <div class="controls">
            <input <%=strControlEnabled%> id="titulo" name="titulo" type="text" size="30" maxlength="50" value="<%=titulo%>" /><br />

        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="contenido">Contenido: </label>
        <div class="controls">
        <textarea <%=strControlEnabled%> id="contenido" name="contenido" type="text" size="30" ><%=contenido%></textarea><br />
    
        </div>
    </div>
    <!--
    <div>
        <label for="id_usuario">Id_usuario: </label>
        <input <a%=strControlEnabled%> id="id_usuario" name="id_usuario" type="text" size="30" maxlength="50" value="<a%=id_usuario%>" /><br />
    </div>
    -->
    <div class="control-group">
        <label class="control-label" for="lenguaje">Id_lenguaje: </label>
        <div class="controls">  
            <input readonly="true" id="lenguaje" class="input-mini"
                   name="id_lenguaje" type="text" size="5" maxlength="5"
                   value="<%=lenguaje%>" />
            <input <%=strControlEnabled%> type="submit" name="searchingfor" value="lenguaje" />
            <span class="alert alert-success"><%=nombreLengueje%></span>
        </div>
    </div>
        <!--
        <div>
            <label for="id_documento">Id_documento: </label>
            <input <a%=strControlEnabled%> id="id_documento" name="id_documento" type="text" size="30" maxlength="50" value="<a%=id_documento%>" /><br />
        </div>
        -->
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
