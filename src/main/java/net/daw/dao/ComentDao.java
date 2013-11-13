/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.ComentBean;
import net.daw.data.Mysql;
import net.daw.helper.FilterBean;

/**
 *
 * @author Jordi Eslava Barrera
 */
public class ComentDao {

    private Mysql oMysql;
    private net.daw.helper.Enum.Connection enumTipoConexion;

    /**
     *
     * @param tipoConexion
     */
    public ComentDao(net.daw.helper.Enum.Connection tipoConexion) {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public void set(ComentBean oComentBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oComentBean.getId() == 0) {
                oComentBean.setId(oMysql.insertOne("comentario"));
            }
            oMysql.updateOne(oComentBean.getId(), "comentario", "titulo", oComentBean.getTitulo()) ;
            oMysql.updateOne(oComentBean.getId(), "comentario", "contenido", oComentBean.getContenido());
            oMysql.updateOne(oComentBean.getId(), "comentario", "fecha", oComentBean.getFecha());
            oMysql.updateOne(oComentBean.getId(), "comentario", "id_usuario", String.valueOf(oComentBean.getId_usuario()));
            oMysql.updateOne(oComentBean.getId(), "comentario", "id_documento", String.valueOf(oComentBean.getId_documento()));
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("ComentDao.setComent: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public int getPages(int intRegsPerPag, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("comentario", intRegsPerPag, alFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("ComentDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    public ArrayList<ComentBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean> alFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<ComentBean> arrComent = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("comentario", intRegsPerPag, intPage, alFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                ComentBean oComentBean = new ComentBean(iterador.next());
                arrComent.add(this.get(oComentBean));
            }
            oMysql.desconexion();
            return arrComent;
        } catch (Exception e) {
            throw new Exception("ComentDao.getPage: Error: " + e.getMessage());
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

    public ComentBean get(ComentBean oComentBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oComentBean.setTitulo(oMysql.getOne("comentario", "titulo", oComentBean.getId()));
            oComentBean.setContenido(oMysql.getOne("comentario", "contenido", oComentBean.getId()));
            oComentBean.setFecha(oMysql.getOne("comentario", "fecha", oComentBean.getId()));
            oComentBean.setId_documento(Integer.parseInt(oMysql.getOne("comentario", "id_repositorio", oComentBean.getId())));
            oComentBean.setId_usuario(Integer.parseInt(oMysql.getOne("comentario", "id_usuario", oComentBean.getId())));

            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ComentDao.getComent: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oComentBean;
    }
     public void remove(ComentBean oComentBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oComentBean.getId(), "comentario");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ComentDao.remove: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }

    }
    
}
