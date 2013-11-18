<%-- 
    Document   : form
    Created on : 13-nov-2013, 11:28:59
    Author     : Jordi Eslava Barrera
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="net.daw.helper.Enum.Connection"%>
<%@page import="net.daw.data.Mysql"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.daw.bean.ComentBean"%>
<%@page import="net.daw.helper.Contexto"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    Integer id_usuario = 0;
    String titulo = "";
    String contenido = "";
    Integer id_documento = 0;
    String fecha = "";


    ComentBean oComentBean = (ComentBean) oContexto.getParametro();
    id = oComentBean.getId();
    titulo = oComentBean.getTitulo();
    contenido = oComentBean.getContenido();
    id_usuario = oComentBean.getId_usuario();
    id_documento = Integer.toString(oComentBean.getDocumento().getId());
    if (oComentBean.getDocumento().getId() > 0) {
        descDocumento = oComentBean.getDocumento().getDescripcion();
    }
    fecha = new SimpleDateFormat("yyyy-MM-dd").format(oComentBean.getFecha());



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
<h1><%=strTitulo%> de Comentario</h1>
<form class="semantic" action="Controller" method="post" id="comentForm">
    <fieldset>
        <legend>Formulario de Comentario</legend>
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
        <!-- <div class="control-group">
             <label for="id_usuario">ID del Usuario: </label> 
             <input <%=strControlEnabled%> id="id_usuario" name="id_usuario" type="text" size="30" maxlength="50" value="<%=id_usuario%>" /> <br />
         </div>-->
        <div class="control-group">
            <label for="id_documento">ID del Documento: </label> 
            <input <%=strControlEnabled%> id="id_documento" name="id_documento" type="text" size="30" maxlength="50" value="<%=id_documento%>" /> <br />
        </div>
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>
