/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.IncidenciasBean;
import net.daw.data.Mysql;

/**
 *
 * @author al037877
 */
public class IncidenciasDao {
    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public IncidenciasDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("incidencia", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("IncidenciaDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<IncidenciasBean> getPage(int intRegsPerPag, int intPage, HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<IncidenciasBean> arrProducto = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("producto", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                IncidenciasBean oIncidenciaBean = new IncidenciasBean(iterador.next());
                arrProducto.add(this.get(oIncidenciaBean));
            }
            oMysql.desconexion();
            return arrProducto;
        } catch (Exception e) {
            throw new Exception("ProductoDao.getPage: Error: " + e.getMessage());
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

    public IncidenciasBean get(IncidenciasBean oIncidenciaBean) throws Exception {
        if (oIncidenciaBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                oIncidenciaBean.setResumen(oMysql.getOne("incidencia", "resumen", oIncidenciaBean.getId()));
                oIncidenciaBean.setCambios(oMysql.getOne("incidencia", "cambios", oIncidenciaBean.getId()));
                oIncidenciaBean.setId_estado(Integer.parseInt(oMysql.getOne("incidencia", "id_estado", oIncidenciaBean.getId())));
                oIncidenciaBean.setId_repositorio(Integer.parseInt(oMysql.getOne("incidencia", "id_repositorio", oIncidenciaBean.getId())));
                oIncidenciaBean.setId_usuario(Integer.parseInt(oMysql.getOne("incidencia", "id_usuario", oIncidenciaBean.getId())));
                oIncidenciaBean.setFechaAlta(oMysql.getOne("incidencia", "fechaalta", oIncidenciaBean.getId()));
                oIncidenciaBean.setFechaResolucion(oMysql.getOne("incidencia", "fecharesolucion", oIncidenciaBean.getId()));
                
                /*BORRAR MAS ADELANTE SI NO ES NECESARIO
                String intId_producto = oMysql.getOne("incidencia", "id_tipoproducto", oIncidenciaBean.getId());
                if (intId_producto != null) {
                    oIncidenciaBean.getTipoProducto().setId(Integer.parseInt(intId_producto));
                    TipoproductoDao oTipoproductoDao = new TipoproductoDao(enumTipoConexion);
                    oIncidenciaBean.setTipoProducto(oTipoproductoDao.get(oIncidenciaBean.getTipoProducto()));
                }*/
                oMysql.desconexion();
            } catch (Exception e) {
                throw new Exception("ProductoDao.get: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        }
        return oIncidenciaBean;
    }
    
    public void set(IncidenciasBean oIncidenciasBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oIncidenciasBean.getId() == 0) {
                oIncidenciasBean.setId(oMysql.insertOne("incidencias"));
            }
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id", String.valueOf(oIncidenciasBean.getId()));
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "resumen", oIncidenciasBean.getResumen());
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "cambios", oIncidenciasBean.getCambios());
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id_estado", String.valueOf(oIncidenciasBean.getId_estado()));
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id_repositorio", String.valueOf(oIncidenciasBean.getId_repositorio()));
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id_usuario", String.valueOf(oIncidenciasBean.getId_usuario()));
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "fechaalta", oIncidenciasBean.getFechaAlta());
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "fecharesolucion", oIncidenciasBean.getFechaResolucion());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("IncidenciasDao.setIncidencias: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
    public void remove(IncidenciasBean oIncidenciasBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oIncidenciasBean.getId(), "incidencias");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("IncidenciasDao.remove: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }

    }
}
