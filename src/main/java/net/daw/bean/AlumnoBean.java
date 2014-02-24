/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author Sergio Martín Tárraga
 * @version v2.0
 * @since mie, 12 noviembre 2013
 */

public class AlumnoBean {

    private int id = 0;
    private int id_usuario = 0;
    private String nombre = "";
    private String ape1 = "";
    private String ape2 = "";
    private String email = "";
    //private String validado = "";
    private UsuarioBean usuario = null;

    /*
     * Constructor vacio
     */
    public AlumnoBean() {
        this.usuario = new UsuarioBean();
        this.usuario.setId(0);
    }

    /*
     * 
     */
    public AlumnoBean(int id) {
        this.id = id;
        this.usuario = new UsuarioBean();
        this.usuario.setId(0);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }*/

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

   
}
