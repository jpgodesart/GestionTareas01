
<%@page import="net.daw.helper.Parser"%>
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
    fecha = new SimpleDateFormat("dd-MM-yyyy").format(oDocumentoBean.getFecha());
    nota = oDocumentoBean.getNota();
    etiquetas = oDocumentoBean.getEtiquetas();

    String cadena = Parser.toHtml(contenido, titulo, true);
    String[] separada = cadena.split("<body>");
    String cadena2 = separada[1];
    String[] separada2 = cadena2.split("</body>");

    strTitulo = "Vista";
    strValueBoton = "Cerrar";
%>
<%
    String classNota = "";
    if (nota == 5) {
        classNota = "class=\"text-warning\"";
    } else if (nota <= 4) {
        classNota = "class=\"text-error\"";
    } else if (nota >= 6) {
        classNota = "class=\"text-success\"";
    }
%>
<%
    String[] etiquetasSeparadas = etiquetas.split(", ");
    String etiquetasProcesadas = "";
    for (int j = 0; j < etiquetasSeparadas.length; j++) {
        System.out.println(j);
        etiquetasProcesadas += " <a href=\"Controller?nrpp=10&enviar=Filtrar&filteroperator=like&filtervalue=" + etiquetasSeparadas[j] + "&page=1&class=documento&method=list&filter=etiquetas\"><span class=\"label label-info\">" + etiquetasSeparadas[j] + "</span></a> ";
    }
%>
<h1><%=strTitulo%> de documento</h1>
<form class="form-horizontal" action="Controller" method="post" id="clienteForm">
    <fieldset>
        <legend>
            <p>Fecha: <%=fecha%></p><p <%=classNota%>>Nota: <%=nota%></p>
        </legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="documento" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <%=separada2[0].substring(0, separada2[0].length() - 8)%>
        <div class="control-group">
            <br/>
            <p>Etiquetas: <span class="alert alert-info"><%=etiquetasProcesadas%></span></p>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>
