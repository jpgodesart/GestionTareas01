/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;


public class TareaBean {

    private Integer id = 0;
    private String nombre = "";
    private String descripcion = "";
    private EstadoBean estado = null;
    private ProyectoBean proyecto = null;

    public TareaBean() {

        this.estado = new EstadoBean();
        this.proyecto = new ProyectoBean();
    }

    public TareaBean(Integer id) {
        this.id = id;
        this.estado = new EstadoBean();
        this.proyecto = new ProyectoBean();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoBean getEstado() {
        return estado;
    }

    public void setEstado(EstadoBean estado) {
        this.estado = estado;
    }

    public ProyectoBean getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoBean proyecto) {
        this.proyecto = proyecto;
    }

    

}

