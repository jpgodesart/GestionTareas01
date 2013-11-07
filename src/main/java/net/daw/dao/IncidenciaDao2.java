/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.data.Mysql;

/**
 *
 * @author al037431
 */
public class IncidenciaDao2 {
     private Mysql oMysql;
    private net.daw.helper.Enum.Connection enumTipoConexion;

    /**
     *
     * @author Enrique Gimeno
     * @param tipoConexion
     */
    public IncidenciaDao2(net.daw.helper.Enum.Connection tipoConexion) {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }
    
     public void set(IncidenciaBean oIncidenciaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oIncidenciaBean.getId() == 0) {
                oIncidenciaBean.setId(oMysql.insertOne("incidencia"));
            }
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "id", oIncidenciaBean.getid());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "resumen", oIncidenciaBean.getresumen());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "cambios", oIncidenciaBean.getcambios());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "id_estado", oIncidenciaBean.getid_estado());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "id_repositorio", oIncidenciaBean.getid_repositorio());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "id_usuario", oIncidenciaBean.getid_usuario());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "fechaalta", oIncidenciaBean.getfechaalta());
            oMysql.updateOne(oIncidenciaBean.getId(), "incidencia", "fecharesolucion", oIncidenciaBean.getid_estado());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("IncidenciaDao.setIncidencia: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
}
