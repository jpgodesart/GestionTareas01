<%-- 
    Document   : form
    Created on : 07-nov-2013, 12:20:07
    Author     : al037431
--%>

<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="net.daw.helper.Enum.Connection"%>
<%@page import="net.daw.data.Mysql"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.daw.bean.IncidenciasBean"%>
<%@page import="net.daw.helper.Contexto"%>
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
    String nomid_estado="";
    String titid_repositorio= "";
    String nomid_usuario= "";

        IncidenciasBean oIncidenciasBean = (IncidenciasBean) oContexto.getParametro();
        id = oIncidenciasBean.getId();
        resumen = oIncidenciasBean.getResumen();
        cambios = oIncidenciasBean.getCambios();
        
        
        
        fechaAlta = oIncidenciasBean.getFechaAlta();
        fechaResolucion = oIncidenciasBean.getFechaResolucion();
    
  
    /*id_estado = Integer.toString(oIncidenciasBean.getEstado().getId());
    if (oIncidenciasBean.getEstado().getId() > 0) {
       nomid_estado = oIncidenciasBean.getEstado().getNombre();
    }
    
    
    id_repositorio = Integer.toString(oIncidenciasBean.getRepositorio().getId());
    if (oIncidenciasBean.getEstado().getId() > 0) {
       titid_repositorio = oIncidenciasBean.getRepositorio().getTitulo();
    }
    
    
     id_usuario = Integer.toString(oIncidenciasBean.getUsuario().getId());
    if (oIncidenciasBean.getUsuario().getId() > 0) {
       nomid_usuario = Integer.toString(oIncidenciasBean.getUsuario().getId());
    }*/
    
    
    
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
<h1><%=strTitulo%> de cliente</h1>
<form class="semantic" action="Controller" method="post" id="incidenciasForm">
    <fieldset>
        <legend>Formulario de Incidencias</legend>
        
    </fieldset>
</form>
