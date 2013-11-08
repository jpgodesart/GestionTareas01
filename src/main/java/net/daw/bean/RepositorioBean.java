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
    private String titulo;
    private String contenido;
    private int id_usuario;
    private int id_lenguaje;
    private int id_documento;
    private Date fecha;

    public RepositorioBean() {
        
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

    public int getId_lenguaje() {
        return id_lenguaje;
    }

    public void setId_lenguaje(int id_lenguaje) {
        this.id_lenguaje = id_lenguaje;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
