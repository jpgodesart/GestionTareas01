/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import net.daw.bean.RepositorioBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;

/**
 *
 * @author al037877
 */
public class RepositorioDao {

    private Mysql oMysql;
    private Enum.Connection enumTipoConexion;

    /**
     *
     * @author Alvaro Crego
     * @param tipoConexion
     */
    public RepositorioDao(Enum.Connection tipoConexion) {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    /**
     *
     * @author Alvaro Crego
     * @param oRepositorioBean
     * @return
     * @throws Exception
     */
    public RepositorioBean get(RepositorioBean oRepositorioBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oRepositorioBean.setTitulo(oMysql.getOne("repositorio", "titulo", oRepositorioBean.getId()));
            oRepositorioBean.setContenido(oMysql.getOne("repositorio", "contenido", oRepositorioBean.getId()));

            //faltan los id_miau
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            oRepositorioBean.setFecha(formato.parse(oMysql.getOne("repositorio", "fecha", oRepositorioBean.getId())));
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("RepositorioDao.getRespositorio: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oRepositorioBean;
    }
    
    public void remove(RepositorioBean oClienteBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oClienteBean.getId(), "repositorio");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ClienteDao.removeCliente: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
    /*
    public int getPages(int intRegsPerPag) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("repositorio", intRegsPerPag);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("RepositorioDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
    public ArrayList<RepositorioBean> getPage(int intRegsPerPag, int intPage) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<RepositorioBean> arrCliente = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("cliente", intRegsPerPag, intPage,"");
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                RepositorioBean oRepositorioBean = new RepositorioBean(iterador.next());
                arrCliente.add(this.get(oRepositorioBean));
            }
            oMysql.desconexion();
            return arrCliente;
        } catch (Exception e) {
            throw new Exception("ClienteDao.getPage: Error: " + e.getMessage());
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
*/
}
