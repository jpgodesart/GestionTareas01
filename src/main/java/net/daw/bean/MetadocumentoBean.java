/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import java.util.Date;

/**
 *
 * @author al037431
 */
public class MetadocumentoBean {
    private int id = 0;
    private String titulo;
    private String fecha;

    public MetadocumentoBean() {
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public MetadocumentoBean(Integer next) {
        
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

   
}
