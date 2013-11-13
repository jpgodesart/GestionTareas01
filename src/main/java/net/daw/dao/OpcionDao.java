/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author al037721
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.daw.bean.OpcionBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;
import net.daw.helper.FilterBean;

public class OpcionDao {

    private final Mysql oMysql;
    private final Enum.Connection enumTipoConexion;

    public OpcionDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("opcion", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("OpcionDao.getPages: Error: " + e.getMessage());
        }
    }

    public int getCount( ArrayList<FilterBean> hmFilter) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getCount("opcion",  hmFilter);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("OpcionDao.getCount: Error: " + e.getMessage());
        }
    }
  
    public ArrayList<OpcionBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean>  hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<OpcionBean> arrOpcion = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("opcion", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                OpcionBean oOpcionBean = new OpcionBean(iterador.next());
                arrOpcion.add(this.get(oOpcionBean));
            }
            oMysql.desconexion();
            return arrOpcion;
        } catch (Exception e) {
            throw new Exception("OpcionDao.getPage: Error: " + e.getMessage());
        }
    }

    public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
        oMysql.conexion(enumTipoConexion);
        ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
        oMysql.desconexion();
        return n;
    }

    public OpcionBean get(OpcionBean oOpcionBean) throws Exception {
        if (oOpcionBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("opcion", oOpcionBean.getId())) {
                    oOpcionBean.setId(0);
                } else {
                    oOpcionBean.setDescripcion(oMysql.getOne("opcion", "descripcion", oOpcionBean.getId()));
                    oOpcionBean.setId_pregunta(Integer.parseInt( oMysql.getOne("opcion", "id_pregunta", oOpcionBean.getId()) ));
                    oOpcionBean.setCorrecta(Boolean.getBoolean( oMysql.getOne("opcion", "correcta", oOpcionBean.getId()) ));
                }
            } catch (Exception e) {
                throw new Exception("OpcionDao.getOpcion: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oOpcionBean.setId(0);
        }
        return oOpcionBean;
    }

    public void set(OpcionBean oOpcionBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oOpcionBean.getId() == 0) {
                oOpcionBean.setId(oMysql.insertOne("opcion"));
            }
            oMysql.updateOne(oOpcionBean.getId(), "opcion", "descripcion", oOpcionBean.getDescripcion());
            oMysql.updateOne(oOpcionBean.getId(), "opcion", "id_pregunta", oOpcionBean.getId_pregunta().toString());
            oMysql.updateOne(oOpcionBean.getId(), "opcion", "correcta", Boolean.toString( oOpcionBean.getCorrecta() ) );
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("OpcionDao.setOpcion: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public void remove(OpcionBean oOpcionBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oOpcionBean.getId(), "opcion");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("OpcionDao.removeOpcion: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
}


