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
import net.daw.bean.UsutareaBean;
import net.daw.bean.TareaBean;
import net.daw.bean.UsuarioBean;
import net.daw.data.Mysql;
import net.daw.helper.FilterBean;

/**
 *
 * @author rafa
 */
public class UsutareaDao {

    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public UsutareaDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("usutarea", intRegsPerPag, alFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("UsuarioDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<UsutareaBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<UsutareaBean> arrUsutarea = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("usutarea", intRegsPerPag, intPage, alFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                UsutareaBean oUsutareaBean = new UsutareaBean(iterador.next());
                arrUsutarea.add(this.get(oUsutareaBean));
            }
            oMysql.desconexion();
            return arrUsutarea;
        } catch (Exception e) {
            throw new Exception("UsuarioDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public UsutareaBean get(UsutareaBean oUsutareaBean) throws Exception {
        if (oUsutareaBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("usutarea", oUsutareaBean.getId())) {
                    oUsutareaBean.setId(0);
                } else {
 
                    String intId_usuario = oMysql.getOne("usutarea", "id_usuario", oUsutareaBean.getId());
                    if (intId_usuario != null) {
                        oUsutareaBean.getUsuario().setId(Integer.parseInt(intId_usuario));
                        UsuarioDao oUsuarioDao = new UsuarioDao(enumTipoConexion);
                        oUsutareaBean.setUsuario(oUsuarioDao.get(oUsutareaBean.getUsuario()));
                    }
                    String intId_tarea = oMysql.getOne("usutarea", "id_tarea", oUsutareaBean.getId());
                    if (intId_tarea != null) {
                        oUsutareaBean.getTarea().setId(Integer.parseInt(intId_tarea));
                        TareaDao oTareaDao = new TareaDao(enumTipoConexion);
                        oUsutareaBean.setTarea(oTareaDao.get(oUsutareaBean.getTarea()));
                    }
                }
            } catch (Exception e) {
                throw new Exception("UsutareaDao.get: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oUsutareaBean.setId(0);
        }
        return oUsutareaBean;
    }

    public void set(UsutareaBean oUsutareaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oUsutareaBean.getId() == 0) {
                oUsutareaBean.setId(oMysql.insertOne("usutarea"));
            }
            Integer id_usuario = oUsutareaBean.getUsuario().getId();
            if (id_usuario > 0) {
                oMysql.updateOne(oUsutareaBean.getId(), "usutarea", "id_usuario", id_usuario.toString());
            } else {
                oMysql.setNull(oUsutareaBean.getId(), "usutarea", "id_usuario");
            }
            Integer id_tarea = oUsutareaBean.getTarea().getId();
            if (id_tarea > 0) {
                oMysql.updateOne(oUsutareaBean.getId(), "usutarea", "id_tarea", id_tarea.toString());
            } else {
                oMysql.setNull(oUsutareaBean.getId(), "usutarea", "id_tarea");
            }
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("UsutareaDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public void remove(UsutareaBean oUsutareaBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oUsutareaBean.getId(), "usutarea");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("UsutareaDao.remove: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }

    }
}