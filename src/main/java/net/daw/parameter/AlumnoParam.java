package net.daw.parameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.AlumnoBean;

/**
 *
 * @author Sergio Martín Tárraga
 * @version v2.0
 * @since mie, 12 noviembre 2013
 */
public class AlumnoParam {

    private HttpServletRequest request;

    public AlumnoParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public AlumnoBean loadId(AlumnoBean oAlumno) throws NumberFormatException {
        try {
            if (request.getParameter("id") != null) {
                oAlumno.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oAlumno.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oAlumno;
    }

    public AlumnoBean load(AlumnoBean oAlumno) throws NumberFormatException {
        try {
            if ((request.getParameter("id_usuario") != null)) {
                oAlumno.getUsuario().setId(Integer.parseInt(request.getParameter("id_usuario")));
            }
            if ((request.getParameter("nombre") != null)) {
                oAlumno.setNombre(request.getParameter("nombre"));
            }
            if ((request.getParameter("ape1") != null)) {
                oAlumno.setApe1(request.getParameter("ape1"));
            }
            if ((request.getParameter("ape2") != null)) {
                oAlumno.setApe2(request.getParameter("ape2"));
            }
            if ((request.getParameter("email") != null)) {
                oAlumno.setEmail(request.getParameter("email"));
            }
           /* if ((request.getParameter("validado") != null)) {
                oAlumno.setValidado(request.getParameter("validado"));
            }*/
            if ((request.getParameter("login") != null)) {
                oAlumno.getUsuario().setLogin(request.getParameter("login"));
            }
            if ((request.getParameter("password") != null)) {
                oAlumno.getUsuario().setPassword(request.getParameter("password"));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: Load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oAlumno;
    }
}
