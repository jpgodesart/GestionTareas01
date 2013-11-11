/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.EstadoBean;
import net.daw.data.Mysql;

/**
 *
 * @author Diana Ortega
 */
public class EstadoDao {
    
    private Mysql oMysql;
    private net.daw.helper.Enum.Connection enumTipoConexion;

    /**
     *
     * @author Diana Ortega
     * @param tipoConexion
     */
    public EstadoDao(net.daw.helper.Enum.Connection tipoConexion) {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    /**
     *
     * @author Diana Ortega
     * @param oEstadoBean
     * @return
     * @throws Exception
     */
    public EstadoBean get(EstadoBean oEstadoBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oEstadoBean.setNombre(oMysql.getOne("estado", "nombre", oEstadoBean.getId()));          
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("EstadoDao.getEstado: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oEstadoBean;
    }
    
    public void remove(EstadoBean oEstadoBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oEstadoBean.getId(), "estado");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("EstadoDao.removeEstado: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
    public int getPages(int intRegsPerPag,HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("estado", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<EstadoBean> getPage(int intRegsPerPag, int intPage,HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<EstadoBean> arrProducto = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("estado", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                EstadoBean oEstadoBean = new EstadoBean(iterador.next());
                arrProducto.add(this.get(oEstadoBean));
            }
            oMysql.desconexion();
            return arrProducto;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
        oMysql.conexion(enumTipoConexion);
        ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
        oMysql.desconexion();
        return n;
    }
    
        public void set(EstadoBean oUsuarioBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oUsuarioBean.getId() == 0) {
                oUsuarioBean.setId(oMysql.insertOne("estado"));
            }
            oMysql.updateOne(oUsuarioBean.getId(), "estado", "nombre", oUsuarioBean.getNombre());
          
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("EstadoDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
}
