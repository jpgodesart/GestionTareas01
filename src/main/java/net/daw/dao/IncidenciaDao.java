/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.IncidenciaBean;
import net.daw.data.Mysql;

/**
 *
 * @author al037877
 */
public class IncidenciaDao {
    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public IncidenciaDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("producto", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("ProductoDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<IncidenciaBean> getPage(int intRegsPerPag, int intPage, HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<IncidenciaBean> arrProducto = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("producto", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                IncidenciaBean oIncidenciaBean = new IncidenciaBean(iterador.next());
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

    public IncidenciaBean get(IncidenciaBean oIncidenciaBean) throws Exception {
        if (oIncidenciaBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                oIncidenciaBean.setResumen(oMysql.getOne("incidencia", "resumen", oIncidenciaBean.getId()));
                oIncidenciaBean.setCambios(oMysql.getOne("incidencia", "cambios", oIncidenciaBean.getId()));
                oIncidenciaBean.setId_estado(oMysql.getOne("incidencia", "id_estado", oIncidenciaBean.getId()));
                oIncidenciaBean.setId_repositorio(oMysql.getOne("incidencia", "id_repositorio", oIncidenciaBean.getId()));
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
    
    /*MODIFICAR PARA NUEVO
    public void set(IncidenciaBean oIncidenciaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oIncidenciaBean.getId() == 0) {
                oIncidenciaBean.setId(oMysql.insertOne("producto"));
            }
            oMysql.updateOne(oIncidenciaBean.getId(), "producto", "codigo", oIncidenciaBean.getCodigo());
            oMysql.updateOne(oIncidenciaBean.getId(), "producto", "descripcion", oIncidenciaBean.getDescripcion());
            oMysql.updateOne(oIncidenciaBean.getId(), "producto", "precio", oIncidenciaBean.getPrecio().toString());
            Integer id_Tipoproducto = oIncidenciaBean.getTipoProducto().getId();
            if (id_Tipoproducto > 0) {
                oMysql.updateOne(oIncidenciaBean.getId(), "producto", "id_tipoproducto", id_Tipoproducto.toString());
            } else {
                oMysql.setNull(oIncidenciaBean.getId(), "producto", "id_tipoproducto");
            }
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("ProductoDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
*/
    public void remove(IncidenciaBean oIncidenciaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oIncidenciaBean.getId(), "producto");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ProductoDao.remove: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }

    }
}
