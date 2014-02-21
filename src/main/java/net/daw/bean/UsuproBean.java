/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;


public class UsuproBean {

    private Integer id = 0;
    private UsuarioBean usuario = null;
    private ProyectoBean proyecto = null;

    public UsuproBean() {

        this.usuario = new UsuarioBean();
        this.proyecto = new ProyectoBean();
    }

    public UsuproBean(Integer id) {
        this.id = id;
        this.usuario = new UsuarioBean();
        this.proyecto = new ProyectoBean();
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

    public ProyectoBean getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoBean proyecto) {
        this.proyecto = proyecto;
    }

    

}

