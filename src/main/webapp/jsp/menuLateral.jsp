<%@page import="net.daw.helper.Contexto"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");%>
<%
    String menu = "<div class=\"well sidebar-nav\"><ul class=\"nav nav-list\">";

    menu += "<li class=\"nav-header\">Usuario</li>";

    if (oContexto.getClase().equals("usuario") && oContexto.getMetodo().equals("ocioso")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }

    menu += "<a href=\"Controller\">Home</a></li>";

    if (!oContexto.getHaySesion()) {
        if (oContexto.getClase().equals("usuario") && oContexto.getMetodo().equals("login")) {
            menu += "<li class=\"active\">";
        } else {
            menu += "<li>";
        }
        menu += "<a href=\"Controller?class=usuario&method=login\">Login</a></li>";
    } else {
        if (oContexto.getClase().equals("usuario") && oContexto.getMetodo().equals("logout")) {
            menu += "<li class=\"active\">";
        } else {
            menu += "<li>";
        }
        menu += "<a href=\"Controller?class=usuario&method=logout\">Logout</a></li>";
    }
    // ------------------------------------------------------
    menu += "<li class=\"nav-header\">Cuestionario</li>";

    if (oContexto.getClase().equals("cuestionario") && oContexto.getMetodo().equals("list")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=cuestionario&method=list\">Listar</a></li>";
    
    if (oContexto.getClase().equals("cuestionario") && oContexto.getMetodo().equals("new")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=cuestionario&method=new\">Crear</a></li>";
// ------------------------------------------------------
    menu += "<li class=\"nav-header\">Pregunta</li>";

    if (oContexto.getClase().equals("pregunta") && oContexto.getMetodo().equals("list")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=pregunta&method=list\">Listar</a></li>";
    
    if (oContexto.getClase().equals("pregunta") && oContexto.getMetodo().equals("new")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=pregunta&method=new\">Crear</a></li>";
// ------------------------------------------------------
    menu += "<li class=\"nav-header\">Opción</li>";

    if (oContexto.getClase().equals("opcion") && oContexto.getMetodo().equals("list")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=opcion&method=list\">Listar</a></li>";
    
    if (oContexto.getClase().equals("opcion") && oContexto.getMetodo().equals("new")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=opcion&method=new\">Crear</a></li>";
// ------------------------------------------------------
    menu += "<li class=\"nav-header\">Contestación</li>";

    if (oContexto.getClase().equals("contestacion") && oContexto.getMetodo().equals("list")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=contestacion&method=list\">Listar</a></li>";
    
    if (oContexto.getClase().equals("contestacion") && oContexto.getMetodo().equals("new")) {
        menu += "<li class=\"active\">";
    } else {
        menu += "<li>";
    }
    menu += "<a href=\"Controller?class=contestacion&method=new\">Crear</a></li>";
// ------------------------------------------------------
  
  menu += "</ul></div>";
%>
<%=menu%>