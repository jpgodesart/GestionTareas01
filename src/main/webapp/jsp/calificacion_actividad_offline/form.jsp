<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.CalificacionActividadOfflineBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String id_usuario = "";
    String nombreUsuario = "";
    String id_actividad_offline = "";  /* Una vez este implementada la tabla actividad_offline cambiar esto. */
    String actividadOffline = ""; /* Una vez este implementada la tabla actividad_offline cambiar esto. */

    CalificacionActividadOfflineBean oCalificacionActividadOfflineBean = (CalificacionActividadOfflineBean) oContexto.getParametro();
    id = oCalificacionActividadOfflineBean.getId();
    
    id_usuario = Integer.toString(oCalificacionActividadOfflineBean.getUsuario().getId());
    if ( oCalificacionActividadOfflineBean.getUsuario().getId() > 0 ) {
        nombreUsuario = oCalificacionActividadOfflineBean.getUsuario().getLogin();
    }
    
    id_actividad_offline = Integer.toString(oCalificacionActividadOfflineBean.getActividadOffline().getId()); /* Una vez este implementada la tabla actividad_offline cambiar esto. */
    if( oCalificacionActividadOfflineBean.getActividadOffline().getId() > 0 ) { /* Una vez este implementada la tabla actividad_offline cambiar esto. */
        actividadOffline = oCalificacionActividadOfflineBean.getActividadOffline().getDescripcion(); /* Una vez este implementada la tabla actividad_offline cambiar esto. */
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
<h1><%=strTitulo%> de contestacion</h1>
<form class="form-horizontal" action="Controller" method="post" id="calificacion_actividad_offlineForm">
    <fieldset>
        <legend>Formulario de Calificacion Actividad Offline</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="calificacion_actividad_offline" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div class="control-group">
        <label class="control-label" for="id_usuario">Usuario </label> 
        <div class="controls">                
            <input readonly="true" id="id_usuario" class="input-mini"
                   name="id_usuario" type="text" size="5" maxlength="5"
                   value="<%=id_usuario%>" />  
            <input <%=strControlEnabled%> type="submit" name="searchingfor" value="usuario" />
            <span class="alert alert-success"><%=nombreUsuario%></span>
        </div>
        </div>
        <div class="control-group">
        <label class="control-label" for="id_actividad_offline">Actividad Offline </label>
        <div class="controls">                
            <input readonly="true" id="id_actividad_offline" class="input-mini"
                   name="id_actividad_offline" type="text" size="5" maxlength="5"
                   value="<%=id_actividad_offline%>" />  
            <input <%=strControlEnabled%> type="submit" name="searchingfor" value="actividad_offline" />
            <span class="alert alert-success"><%=actividadOffline%></span>
        </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" name="enviar" value="<%=strValueBoton%>" />
            </div>
        </div>   
    </fieldset>
</form>
