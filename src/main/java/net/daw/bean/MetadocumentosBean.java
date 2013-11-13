/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.bean;

/**
 *
 * @author Alvaro Crego
 */
public class MetadocumentosBean {
    private int id;
    //private int id_metadocumento;
    private DocumentoBean id_documento;
    private int orden;

     public MetadocumentosBean() {
        
    }

    public MetadocumentosBean(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocumentoBean getId_documento() {
        return id_documento;
    }

    public void setId_documento(DocumentoBean id_documento) {
        this.id_documento = id_documento;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
    
}
