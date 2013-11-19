
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.DocumentoBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String titulo = "";
    String contenido = "";
    String fecha = "";
    Integer nota = 0;
    String etiquetas = "";

    DocumentoBean oDocumentoBean = (DocumentoBean) oContexto.getParametro();
    id = oDocumentoBean.getId();
    titulo = oDocumentoBean.getTitulo();
    contenido = oDocumentoBean.getContenido();
    fecha = new SimpleDateFormat("yyyy-MM-dd").format(oDocumentoBean.getFecha());
    nota = oDocumentoBean.getNota();
    etiquetas = oDocumentoBean.getEtiquetas();

    if (oContexto.getMetodo().equals("update")) {
        strTitulo = "Edición";
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strTitulo = "Alta";
        strValueBoton = "Crear";
    }
%>
<h1><%=strTitulo%> de documento</h1>
<form class="form-horizontal" action="Controller" method="post" id="clienteForm">
    <fieldset>
        <legend>Formulario de documento</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="documento" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
            <label class="control-label" for="titulo">Titulo: </label> 
            <div class="controls">
                <input id="titulo" name="titulo" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=titulo%>" /><br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="contenido">Contenido: </label>
            <div class="controls">
                <textarea class="field span6" id="contenido" name="contenido" type="text" rows="10" ><%=contenido%></textarea><br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="fecha">Fecha: </label> 
            <div class="controls">
                <input id="fecha" name="fecha" type="date" size="30" maxlength="50" value="<%=fecha%>" /> <br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="nota">Nota: </label> 
            <div class="controls">
                <input id="nota" name="nota" type="text" size="30" maxlength="50" value="<%=nota%>" /> <br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="etiquetas">Etiquetas: </label> 
            <div class="controls">
                <input id="etiquetas" name="etiquetas" type="text" size="30" maxlength="50" value="<%=etiquetas%>" placeholder="Etiquetas separadas por coma" /><br />
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>
