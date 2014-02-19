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
import net.daw.bean.TareaBean;
import net.daw.bean.ProyectoBean;
import net.daw.bean.EstadoBean;
import net.daw.data.Mysql;
import net.daw.helper.FilterBean;

/**
 *
 * @author rafa
 */
public class TareaDao {

    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public TareaDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("tarea", intRegsPerPag, alFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<TareaBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<TareaBean> arrTarea = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("tarea", intRegsPerPag, intPage, alFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                TareaBean oTareaBean = new TareaBean(iterador.next());
                arrTarea.add(this.get(oTareaBean));
            }
            oMysql.desconexion();
            return arrTarea;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public TareaBean get(TareaBean oTareaBean) throws Exception {
        if (oTareaBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("tarea", oTareaBean.getId())) {
                    oTareaBean.setId(0);
                } else {
                    oTareaBean.setNombre(oMysql.getOne("tarea", "nombre", oTareaBean.getId()));
                    oTareaBean.setDescripcion(oMysql.getOne("tarea", "descripcion", oTareaBean.getId()));
                    String intId_estado = oMysql.getOne("tarea", "id_estado", oTareaBean.getId());
                    if (intId_estado != null) {
                        oTareaBean.getEstado().setId(Integer.parseInt(intId_estado));
                        EstadoDao oEstadoDao = new EstadoDao(enumTipoConexion);
                        oTareaBean.setEstado(oEstadoDao.get(oTareaBean.getEstado()));
                    }
                    String intId_proyecto = oMysql.getOne("tarea", "id_proyecto", oTareaBean.getId());
                    if (intId_proyecto != null) {
                        oTareaBean.getProyecto().setId(Integer.parseInt(intId_proyecto));
                        ProyectoDao oProyectoDao = new ProyectoDao(enumTipoConexion);
                        oTareaBean.setProyecto(oProyectoDao.get(oTareaBean.getProyecto()));
                    }
                }
            } catch (Exception e) {
                throw new Exception("TareaDao.get: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oTareaBean.setId(0);
        }
        return oTareaBean;
    }

    public void set(TareaBean oTareaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oTareaBean.getId() == 0) {
                oTareaBean.setId(oMysql.insertOne("tarea"));
            }
            oMysql.updateOne(oTareaBean.getId(), "tarea", "nombre", oTareaBean.getNombre());
            oMysql.updateOne(oTareaBean.getId(), "tarea", "descripcion", oTareaBean.getDescripcion());
            Integer id_estado = oTareaBean.getEstado().getId();
            if (id_estado > 0) {
                oMysql.updateOne(oTareaBean.getId(), "tarea", "id_estado", id_estado.toString());
            } else {
                oMysql.setNull(oTareaBean.getId(), "tarea", "id_estado");
            }
            Integer id_proyecto = oTareaBean.getProyecto().getId();
            if (id_proyecto > 0) {
                oMysql.updateOne(oTareaBean.getId(), "tarea", "id_proyecto", id_proyecto.toString());
            } else {
                oMysql.setNull(oTareaBean.getId(), "tarea", "id_proyecto");
            }
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("TareaDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public void remove(TareaBean oTareaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oTareaBean.getId(), "tarea");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("TareaDao.remove: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }

    }
}