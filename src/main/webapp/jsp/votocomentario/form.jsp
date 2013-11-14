
<%@page import="java.util.Calendar"%>
<%@page import="net.daw.bean.VotoComentarioBean"%>
<%@page import="net.daw.helper.Contexto"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    /*Integer id_usuario = 0;
    Integer id_comentario = 0;*/
    Integer valor = 0;
    
    if (oContexto.getMetodo().equals("update") || oContexto.getMetodo().equals("view")) {
        VotoComentarioBean oVotoComentarioBean = (VotoComentarioBean) oContexto.getParametro();
        id = oVotoComentarioBean.getId();        
       /* id_usuario = oVotoComentarioBean.getId_usuario();
        id_comentario = oVotoComentarioBean.getId_comentario();*/
        valor = oVotoComentarioBean.getValor();
        
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
<h1><%=strTitulo%> de votoComentario</h1>
<form class="semantic" action="Controller" method="post" id="votoComentarioForm">
    <fieldset>
        <legend>Formulario de VotoComentario</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="votoComentario" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div>
            <label for="nombre">Titulo: </label> 
            <input <%=strControlEnabled%> id="valor" name="valor" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=valor%>" /><br />
            
        </div>
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>
