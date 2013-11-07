/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.text.SimpleDateFormat;
import net.daw.bean.RepositorioBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;

/**
 *
 * @author al037877
 */
public class RepositorioDao {

    private Mysql oMysql;
    private Enum.Connection enumTipoConexion;

    /**
     *
     * @author Alvaro Crego
     * @param tipoConexion
     */
    public RepositorioDao(Enum.Connection tipoConexion) {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    /**
     *
     * @author Alvaro Crego
     * @param oRepositorioBean
     * @return
     * @throws Exception
     */
    public RepositorioBean get(RepositorioBean oRepositorioBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oRepositorioBean.setTitulo(oMysql.getOne("repositorio", "titulo", oRepositorioBean.getId()));
            oRepositorioBean.setContenido(oMysql.getOne("repositorio", "contenido", oRepositorioBean.getId()));

            //faltan los id_miau
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            oRepositorioBean.setFecha(formato.parse(oMysql.getOne("repositorio", "fecha", oRepositorioBean.getId())));
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ClienteDao.getCliente: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oRepositorioBean;
    }
    
    
    public void set(RepositorioBean oRepositorioBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oRepositorioBean.getId() == 0) {
                oRepositorioBean.setId(oMysql.insertOne("repositorio"));
            }
            oMysql.updateOne(oRepositorioBean.getId(), "repositorio", "Título", oRepositorioBean.getTitulo());
            oMysql.updateOne(oRepositorioBean.getId(), "repositorio", "Contenido", oRepositorioBean.getContenido());
            oMysql.updateOne(oRepositorioBean.getId(), "repositorio", "Id_usuario", Integer.toString(oRepositorioBean.getId_usuario()));
            oMysql.updateOne(oRepositorioBean.getId(), "repositorio", "Id_lenguaje", Integer.toString(oRepositorioBean.getId_lenguaje()));
            oMysql.updateOne(oRepositorioBean.getId(), "repositorio", "Id_documento", Integer.toString(oRepositorioBean.getId_documento()));
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("RepositorioDao.setRepositorio: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

}
