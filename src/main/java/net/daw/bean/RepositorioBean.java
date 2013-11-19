/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import java.util.Date;

/**
 *
 * @author Alvaro Crego
 */
public class RepositorioBean {

    private int id = 0;
    private String titulo = "";
    private String contenido = "";
    private int id_usuario;
    private LenguajeBean lenguaje = null;
    private int id_documento;
    private Date fecha = new Date();

    public RepositorioBean() {
        this.lenguaje = new LenguajeBean();
        this.lenguaje.setId(0);
    }

    public RepositorioBean(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public LenguajeBean getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(LenguajeBean lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
