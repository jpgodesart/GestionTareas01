/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import net.daw.bean.EstadoBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;
import net.daw.helper.FilterBean;

public class EstadoDao {

    private final Mysql oMysql;
    private final Enum.Connection enumTipoConexion;

    public EstadoDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("estado", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPages: Error: " + e.getMessage());
        }
    }

    public int getCount( ArrayList<FilterBean> hmFilter) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getCount("estado",  hmFilter);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getCount: Error: " + e.getMessage());
        }
    }
  
    public ArrayList<EstadoBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean>  hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<EstadoBean> arrEstado = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("estado", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                EstadoBean oEstadoBean = new EstadoBean(iterador.next());
                arrEstado.add(this.get(oEstadoBean));
            }
            oMysql.desconexion();
            return arrEstado;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPage: Error: " + e.getMessage());
        }
    }


    public EstadoBean get(EstadoBean oEstadoBean) throws Exception {
        if (oEstadoBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("estado", oEstadoBean.getId())) {
                    oEstadoBean.setId(0);
                } else {
                    oEstadoBean.setNombre(oMysql.getOne("estado", "nombre", oEstadoBean.getId()));
                   
                }
            } catch (Exception e) {
                throw new Exception("EstadoDao.getEstado: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oEstadoBean.setId(0);
        }
        return oEstadoBean;
    }

    public void set(EstadoBean oEstadoBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oEstadoBean.getId() == 0) {
                oEstadoBean.setId(oMysql.insertOne("estado"));
            }
            oMysql.updateOne(oEstadoBean.getId(), "estado", "nombre", oEstadoBean.getNombre());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("EstadoDao.setEstado: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
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
}
