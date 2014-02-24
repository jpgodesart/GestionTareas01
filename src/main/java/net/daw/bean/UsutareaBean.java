/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;


public class UsutareaBean {

    private Integer id = 0;
    private UsuarioBean usuario = null;
    private TareaBean tarea = null;

    public UsutareaBean() {

        this.usuario = new UsuarioBean();
        this.tarea = new TareaBean();
    }

    public UsutareaBean(Integer id) {
        this.id = id;
        this.usuario = new UsuarioBean();
        this.tarea = new TareaBean();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public TareaBean getTarea() {
        return tarea;
    }

    public void setTarea(TareaBean tarea) {
        this.tarea = tarea;
    }

    

}

