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

import net.daw.bean.ProyectoBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;
import net.daw.helper.FilterBean;

public class ProyectoDao {

    private final Mysql oMysql;
    private final Enum.Connection enumTipoConexion;

    public ProyectoDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("proyecto", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("ProyectoDao.getPages: Error: " + e.getMessage());
        }
    }

    public int getCount( ArrayList<FilterBean> hmFilter) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getCount("proyecto",  hmFilter);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("ProyectoDao.getCount: Error: " + e.getMessage());
        }
    }
  
    public ArrayList<ProyectoBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean>  hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<ProyectoBean> arrProyecto = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("proyecto", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                ProyectoBean oProyectoBean = new ProyectoBean(iterador.next());
                arrProyecto.add(this.get(oProyectoBean));
            }
            oMysql.desconexion();
            return arrProyecto;
        } catch (Exception e) {
            throw new Exception("ProyectoDao.getPage: Error: " + e.getMessage());
        }
    }

    /*public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
        oMysql.conexion(enumTipoConexion);
        ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
        oMysql.desconexion();
        return n;
    }*/

    public ProyectoBean get(ProyectoBean oProyectoBean) throws Exception {
        if (oProyectoBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("proyecto", oProyectoBean.getId())) {
                    oProyectoBean.setId(0);
                } else {
                    oProyectoBean.setNombre(oMysql.getOne("proyecto", "nombre", oProyectoBean.getId()));
                    oProyectoBean.setDescripcion(oMysql.getOne("proyecto", "descripcion", oProyectoBean.getId()));
                }
            } catch (Exception e) {
                throw new Exception("ProyectoDao.getProyecto: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oProyectoBean.setId(0);
        }
        return oProyectoBean;
    }

    public void set(ProyectoBean oProyectoBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oProyectoBean.getId() == 0) {
                oProyectoBean.setId(oMysql.insertOne("proyecto"));
            }
            oMysql.updateOne(oProyectoBean.getId(), "proyecto", "nombre", oProyectoBean.getNombre());
            oMysql.updateOne(oProyectoBean.getId(), "proyecto", "descripcion", oProyectoBean.getDescripcion());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("ProyectoDao.setProyecto: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public void remove(ProyectoBean oProyectoBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oProyectoBean.getId(), "proyecto");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ProyectoDao.removeProyecto: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
}
