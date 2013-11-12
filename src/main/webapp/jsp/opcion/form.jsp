<%-- 
    Document   : form
    Created on : 12-nov-2013, 11:50:35
    Author     : al037721
--%>
<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.OpcionBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String descripcion = "";
    Integer id_pregunta;
    Boolean correcta;


    OpcionBean oOpcionBean = (OpcionBean) oContexto.getParametro();
    id = oOpcionBean.getId();
    descripcion = oOpcionBean.getDescripcion();
    id_pregunta = oOpcionBean.getId_pregunta();
    correcta = oOpcionBean.getCorrecta();


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
<h1><%=strTitulo%> de opcion</h1>
<form class="form-horizontal" action="Controller" method="post" id="opcionForm">
    <fieldset>
        <legend>Formulario de opcion</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="opcion" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
            <label class="control-label" for="descripcion">Descripcion: </label> 
            <div class="controls">
                <input <%=strControlEnabled%> id="descripcion" name="descripcion" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=descripcion%>" /><br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="id_pregunta">id_pregunta: </label>
            <div class="controls">
                <input <%=strControlEnabled%> id="id_pregunta" name="id_pregunta" type="text" size="30" maxlength="50" value="<%=id_pregunta%>" /><br />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="correcta">Correcta: </label> 
            <div class="controls">
                <input <%=strControlEnabled%> id="correcta" name="correcta" type="radio" size="30" maxlength="50" value="<%=correcta%>" /> <br />
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>