/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.RepositorioBean;
import net.daw.bean.EstadoBean;
import net.daw.bean.IncidenciasBean;
import net.daw.bean.UsuarioBean;
import net.daw.data.Mysql;
import net.daw.helper.FilterBean;
import net.daw.helper.Enum;

/**
 *
 * @author Enrique Gimeno
 */
public class IncidenciasDao {

    private final Mysql oMysql;
    private final Enum.Connection enumTipoConexion;

    public IncidenciasDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("incidencias", intRegsPerPag, alFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public int getCount(ArrayList<FilterBean> hmFilter) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getCount("incidencias", hmFilter);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("IncidenciasDao.getCount: Error: " + e.getMessage());
        }
    }

    public ArrayList<IncidenciasBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<IncidenciasBean> arrIncidencias = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("incidencias", intRegsPerPag, intPage, alFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                IncidenciasBean oIncidenciasBean = new IncidenciasBean(iterador.next());
                arrIncidencias.add(this.get(oIncidenciasBean));
            }
            oMysql.desconexion();
            return arrIncidencias;
        } catch (Exception e) {
            throw new Exception("EstadoDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public IncidenciasBean get(IncidenciasBean oIncidenciasBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);

            EstadoBean oEstadoBean = new EstadoBean();
            RepositorioBean oRepositorioBean = new RepositorioBean();
            UsuarioBean oUsuarioBean = new UsuarioBean();

            oEstadoBean.setId(Integer.parseInt(oMysql.getOne("incidencias", "id_estado", oIncidenciasBean.getId())));
            oRepositorioBean.setId(Integer.parseInt(oMysql.getOne("incidencias", "id_repositorio", oIncidenciasBean.getId())));
            oUsuarioBean.setId(Integer.parseInt(oMysql.getOne("incidencias", "id_usuario", oIncidenciasBean.getId())));

            oIncidenciasBean.setResumen(oMysql.getOne("incidencias", "resumen", oIncidenciasBean.getId()));
            oIncidenciasBean.setCambios(oMysql.getOne("incidencias", "cambios", oIncidenciasBean.getId()));
            oIncidenciasBean.setFechaAlta(oMysql.getOne("incidencias", "fechaalta", oIncidenciasBean.getId()));
            oIncidenciasBean.setFechaResolucion(oMysql.getOne("incidencias", "fecharesolucion", oIncidenciasBean.getId()));



            EstadoDao oEstadoDao = new EstadoDao(enumTipoConexion);
            RepositorioDao oRepositorioDao = new RepositorioDao(enumTipoConexion);
            UsuarioDao oUsuarioDao = new UsuarioDao(enumTipoConexion);



            oEstadoBean = oEstadoDao.get(oEstadoBean);
            oRepositorioBean = oRepositorioDao.get(oRepositorioBean);
            oUsuarioBean = oUsuarioDao.get(oUsuarioBean);




            oIncidenciasBean.setEstado(oEstadoBean);
            oIncidenciasBean.setRepositorio(oRepositorioBean);
            oIncidenciasBean.setUsuario(oUsuarioBean);

            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("EstadoDao.get: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oIncidenciasBean;
    }

    public void set(IncidenciasBean oIncidenciasBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oIncidenciasBean.getId() == 0) {
                oIncidenciasBean.setId(oMysql.insertOne("incidencias"));
            }
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id_estado", Integer.toString(oIncidenciasBean.getEstado().getId()));
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id_repositorio", Integer.toString(oIncidenciasBean.getRepositorio().getId()));
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "id_usuario", Integer.toString(oIncidenciasBean.getUsuario().getId()));

            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "resumen", oIncidenciasBean.getResumen());
            oMysql.updateOne(oIncidenciasBean.getId(), "incidencias", "cambios", oIncidenciasBean.getCambios());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("IncidenciasDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    /**
     *
     * @param oIncidenciasBean
     * @throws Exception
     */
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