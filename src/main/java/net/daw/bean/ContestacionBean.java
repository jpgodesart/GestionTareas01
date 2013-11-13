/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author al037914
 */
public class ContestacionBean {
    private int id = 0;
    private UsuarioBean usuario = null;
    private PreguntaBean pregunta = null;
    private OpcionBean opcion = null;
    
    public ContestacionBean() {
        this.usuario = new UsuarioBean();
        this.usuario.setId(0);
        this.pregunta = new PreguntaBean();
        this.pregunta.setId(0);
        this.opcion = new OpcionBean();
        this.opcion.setId(0);
    }

    public ContestacionBean(Integer intId) {
        this.id = intId;
        this.usuario = new UsuarioBean();
        this.usuario.setId(0);
        this.pregunta = new PreguntaBean();
        this.pregunta.setId(0);
        this.opcion = new OpcionBean();
        this.opcion.setId(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public PreguntaBean getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaBean pregunta) {
        this.pregunta = pregunta;
    }

    public OpcionBean getOpcion() {
        return opcion;
    }

    public void setOpcion(OpcionBean opcion) {
        this.opcion = opcion;
    }
   
    
}
