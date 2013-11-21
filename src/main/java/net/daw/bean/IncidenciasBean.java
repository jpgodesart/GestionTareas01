/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author al037877
 */
public class IncidenciasBean {
    private int id = 0;
    private EstadoBean estado = null;
    private RepositorioBean repositorio = null;
    private UsuarioBean usuario = null;
    private String resumen = "";
    private String cambios = "";
    private int id_estado = 0;
    private int id_repositorio = 0;
    private String fechaAlta = "";
    private String fechaResolucion = "";
    
    public IncidenciasBean(int id) {
        this.id = id;
    }

    public IncidenciasBean() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoBean getEstado() {
        return estado;
    }

    public void setEstado(EstadoBean estado) {
        this.estado = estado;
    }

    public RepositorioBean getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioBean repositorio) {
        this.repositorio = repositorio;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
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

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_repositorio() {
        return id_repositorio;
    }

    public void setId_repositorio(int id_repositorio) {
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
