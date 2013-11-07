/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author al037877
 */
public class IncidenciaBean {
    private int id = 0;
    private int id_usuario = 0;
    private String resumen = "";
    private String cambios = "";
    private String id_estado = "";
    private String id_repositorio = "";
    private String fechaAlta = "";
    private String fechaResolucion = "";
    
    public IncidenciaBean(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getId_repositorio() {
        return id_repositorio;
    }

    public void setId_repositorio(String id_repositorio) {
        this.id_repositorio = id_repositorio;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
    
    
    
}
