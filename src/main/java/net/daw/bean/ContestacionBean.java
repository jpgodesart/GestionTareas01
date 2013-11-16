/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author al037721
 */

package net.daw.bean;


public class ContestacionBean {

    private Integer id = 0;
    private UsuarioBean usuario = null;
    private PreguntaBean pregunta = null;
    private String contestacion = "";

    public ContestacionBean() {
        this.usuario = new UsuarioBean();
        this.pregunta = new PreguntaBean();
    }

    public ContestacionBean(Integer id) {
        this.id = id;
        this.usuario = new UsuarioBean();
        this.pregunta = new PreguntaBean();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioBean getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
    
    public PreguntaBean getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(PreguntaBean pregunta) {
        this.pregunta = pregunta;
    }

    public String getContestacion() {
        return this.contestacion;
    }
    
    public void setContestacion(String contestacion) {
        this.contestacion = contestacion;
    }
}

