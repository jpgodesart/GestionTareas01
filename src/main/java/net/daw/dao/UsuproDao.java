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
import net.daw.bean.UsuproBean;
import net.daw.bean.ProyectoBean;
import net.daw.bean.UsuarioBean;
import net.daw.data.Mysql;
import net.daw.helper.FilterBean;

/**
 *
 * @author rafa
 */
public class UsuproDao {

    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public UsuproDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("usupro", intRegsPerPag, alFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("UsuarioDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<UsuproBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<UsuproBean> arrUsupro = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("usupro", intRegsPerPag, intPage, alFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                UsuproBean oUsuproBean = new UsuproBean(iterador.next());
                arrUsupro.add(this.get(oUsuproBean));
            }
            oMysql.desconexion();
            return arrUsupro;
        } catch (Exception e) {
            throw new Exception("UsuarioDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public UsuproBean get(UsuproBean oUsuproBean) throws Exception {
        if (oUsuproBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("usupro", oUsuproBean.getId())) {
                    oUsuproBean.setId(0);
                } else {
 
                    String intId_usuario = oMysql.getOne("usupro", "id_usuario", oUsuproBean.getId());
                    if (intId_usuario != null) {
                        oUsuproBean.getUsuario().setId(Integer.parseInt(intId_usuario));
                        UsuarioDao oUsuarioDao = new UsuarioDao(enumTipoConexion);
                        oUsuproBean.setUsuario(oUsuarioDao.get(oUsuproBean.getUsuario()));
                    }
                    String intId_proyecto = oMysql.getOne("usupro", "id_proyecto", oUsuproBean.getId());
                    if (intId_proyecto != null) {
                        oUsuproBean.getProyecto().setId(Integer.parseInt(intId_proyecto));
                        ProyectoDao oProyectoDao = new ProyectoDao(enumTipoConexion);
                        oUsuproBean.setProyecto(oProyectoDao.get(oUsuproBean.getProyecto()));
                    }
                }
            } catch (Exception e) {
                throw new Exception("UsuproDao.get: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oUsuproBean.setId(0);
        }
        return oUsuproBean;
    }

    public void set(UsuproBean oUsuproBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oUsuproBean.getId() == 0) {
                oUsuproBean.setId(oMysql.insertOne("usupro"));
            }
            Integer id_usuario = oUsuproBean.getUsuario().getId();
            if (id_usuario > 0) {
                oMysql.updateOne(oUsuproBean.getId(), "usupro", "id_usuario", id_usuario.toString());
            } else {
                oMysql.setNull(oUsuproBean.getId(), "usupro", "id_usuario");
            }
            Integer id_proyecto = oUsuproBean.getProyecto().getId();
            if (id_proyecto > 0) {
                oMysql.updateOne(oUsuproBean.getId(), "usupro", "id_proyecto", id_proyecto.toString());
            } else {
                oMysql.setNull(oUsuproBean.getId(), "usupro", "id_proyecto");
            }
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("UsuproDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public void remove(UsuproBean oUsuproBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oUsuproBean.getId(), "usupro");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("UsuproDao.remove: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }

    }
}