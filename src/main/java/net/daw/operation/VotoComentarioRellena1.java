package net.daw.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ComentBean;
import net.daw.bean.UsuarioBean;
import net.daw.bean.VotoComentarioBean;
import net.daw.dao.VotoComentarioDao;
import net.daw.helper.Contexto;
import net.daw.operation.Operation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diana
 */
public class VotoComentarioRellena1 implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        VotoComentarioBean oVotoComentarioBean = new VotoComentarioBean();
        VotoComentarioDao oVotoComentarioDao = new VotoComentarioDao(oContexto.getEnumTipoConexion());
        String id_usuario = "";
        String id_comentario = "";
        String valor = "";

        ArrayList<String> arrUsuario = new ArrayList<>();
        arrUsuario.add("1188111B");
        arrUsuario.add("1119512C");
        arrUsuario.add("0007703C");
        arrUsuario.add("1891105E");
        arrUsuario.add("111105A");
        arrUsuario.add("1161531D");
        arrUsuario.add("1212589F");
        arrUsuario.add("2211006C");
        arrUsuario.add("9611243J");

        ArrayList<String> arrComentario = new ArrayList<>();
        arrComentario.add("Javier");
        arrComentario.add("Lucia");
        arrComentario.add("Lucas");
        arrComentario.add("Javier");
        arrComentario.add("Marco");
        arrComentario.add("Sandra");
        arrComentario.add("Margarita");
        arrComentario.add("Pedro");
        arrComentario.add("Toni");

        ArrayList<String> arrValor = new ArrayList<>();
        arrValor.add("Garcia");
        arrValor.add("Benito");
        arrValor.add("Soria");
        arrValor.add("Grancha");
        arrValor.add("Martinez");
        arrValor.add("Rodriguez");
        arrValor.add("Gutierrez");
        arrValor.add("Rubio");
        arrValor.add("Moreno");

        int index;
        int contador = 0;
        Iterator<String> iterador = arrUsuario.listIterator();
        Random generator;

        while (iterador.hasNext()) {
            contador++;
            id_usuario = iterador.next();
            generator = new Random();
            oVotoComentarioBean.setId(0);
            UsuarioBean oUsuarioBean = new UsuarioBean();
            oVotoComentarioBean.setId_usuario(oUsuarioBean);

            index = generator.nextInt(arrUsuario.size());
            String randomUsuario = arrUsuario.get(index);
            oUsuarioBean.setId(Integer.parseInt(contador + randomUsuario));
            oVotoComentarioBean.setId_usuario(oUsuarioBean);
            generator = new Random();

            index = generator.nextInt(arrComentario.size());
            String randomComentario = arrComentario.get(index);
            ComentBean oComentBean = new ComentBean();
            oComentBean.setId(index);
            oVotoComentarioBean.setId_comentario(Integer.parseInt(randomComentario));
            generator = new Random();

            index = generator.nextInt(arrValor.size());
            String randomValor = arrValor.get(index);
            oVotoComentarioBean.setValor(randomValor);
            generator = new Random();

            index = generator.nextInt(arrComentario.size());
            String randomLOGIN = arrComentario.get(index);
            oVotoComentarioBean.getId_usuario().setLogin(randomLOGIN + contador);

            index = generator.nextInt(arrComentario.size());
            String randomPASSWORD = arrComentario.get(index);
            oVotoComentarioBean.getId_usuario().setPassword(randomPASSWORD + contador);

            try {
                oVotoComentarioDao.set(oVotoComentarioBean);

            } catch (Exception e) {
                throw new ServletException("VotoComentarioController: Update Error: Phase 2: " + e.getMessage());
            }
        }
        return "OK- Información Autorellena VotoComentario generada.";
    }
}
