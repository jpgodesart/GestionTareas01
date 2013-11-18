/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBException;
import org.apache.commons.io.FileUtils;
import org.sweble.wikitext.engine.CompiledPage;
import org.sweble.wikitext.engine.CompilerException;
import org.sweble.wikitext.engine.PageId;
import org.sweble.wikitext.engine.PageTitle;
import org.sweble.wikitext.engine.utils.HtmlPrinter;
import org.sweble.wikitext.engine.utils.SimpleWikiConfiguration;
import org.sweble.wikitext.lazy.LinkTargetException;

/**
 *
 * @author Alvaro
 */
public class Parser1 {

    /**
     *
     * @param wikitext
     * @param fileTitle
     * @param renderHtml
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws LinkTargetException
     * @throws CompilerException
     * @throws JAXBException
     */
    public static String toHtml(String wikitext, String fileTitle, boolean renderHtml) throws FileNotFoundException, IOException, LinkTargetException, CompilerException, JAXBException {
        // Set-up a simple wiki configuration
        SimpleWikiConfiguration config = new SimpleWikiConfiguration(
                "classpath:/org/sweble/wikitext/engine/SimpleWikiConfiguration.xml");

        final int wrapCol = 80;

        // Instantiate a compiler for wiki pages
        org.sweble.wikitext.engine.Compiler compiler = new org.sweble.wikitext.engine.Compiler(config);

        // Retrieve a page
        PageTitle pageTitle = PageTitle.make(config, fileTitle);

        PageId pageId = new PageId(pageTitle, -1);

        // Compile the retrieved page
        CompiledPage cp = compiler.postprocess(pageId, wikitext, null);

        // Render the compiled page as HTML
        StringWriter w = new StringWriter();

        if (renderHtml) {
            HtmlPrinter p = new HtmlPrinter(w, pageTitle.getFullTitle());
            p.setCssResource("/org/sweble/wikitext/engine/utils/HtmlPrinter.css", "");
            p.setStandaloneHtml(true, "");
            p.go(cp.getPage());
            return w.toString();
        } else {
            TextConverter p = new TextConverter(config, wrapCol);
            return (String) p.go(cp.getPage());
        }
    }

    public static void expreg(String[] args) {
        /* PROGRAMA HECHO EN PERL equivalente
         $_="Para todo x: |x|=|-x|";
         print "[$`]\n[$&]\n[$']\n" if /x/; # imprime [Para todo ]
         # [x]
         # [: |x|=|-x|]
         print "[$&]\n" if m/todo/; # imprime [todo]
         $e="la menor: la si do re mi fa(#) sol(#) la";
         print "[$&]\n" if $e=~/\(#\)/; # imprime [(#)]
         */
        Pattern pat = null;
        Matcher mat = null;
        String texto = "Para todo x: |x|=|-x|";
        pat = Pattern.compile("x");
        mat = pat.matcher(texto);
        System.out.println("Texto –> " + texto);
        if (mat.find()) {
            System.out.println("\tExpresion regular –> /x/");
            System.out.println("\t[" + texto.substring(0, mat.start()) + "]");
            System.out.println("\t[" + mat.group() + "]");
            System.out.println("\t[" + texto.substring(mat.end(), texto.length()) + "]");
        }
        pat = Pattern.compile("todo");
        mat = pat.matcher(texto);
        if (mat.find()) {
            System.out.println("\n\tExpresion regular –> /todo/");
            System.out.println("\t[" + mat.group() + "]");
        }
        texto = "la menor: la si do re mi fa(#) sol(#) la";
        pat = Pattern.compile("\\(#\\)");
        mat = pat.matcher(texto);
        System.out.println("\n\nTexto –> " + texto);
        if (mat.find()) {
            System.out.println("\tExpresion regular –> /\\(#\\)/");
            System.out.println("\t[" + mat.group() + "]");
        }
    }

//    public static void sustitucion(String args) {
//        /*PROGRAMA HECHO EN LENGUAJE PERL 
//         $c0=$c1="Hay un tono salvo de mi a fa, y de si a do.";
//         $r=$c1=~s/do|re|mi|fa|sol|la|si/NOTA/g;
//         print "Original [$c0]\nResultante [$c1]";$c0=$_="El resultado del partido ha sido de de 2-2";
//         s/(\d+)/$1+1/e;
//         print "\nOriginal [$c0]\nResultante [$_]"
//         */
//
//        Matcher mat = null;
//        Pattern pat = null;
//
//        String texto = "Hay un tono salvo de mi a fa, y de si a do.";
//
//        System.out.println("==Primer Ejemplo======");
//        pat = Pattern.compile("do|re|mi|fa|sol|la|si");
//        mat = pat.matcher(texto);
//        System.out.println("Original —> " + texto);
//        System.out.println("Resultante -> " + mat.replaceAll("NOTA"));
//
//        System.out.println("\n==Segundo Ejemplo====");
//        texto = "El resultado del partido ha sido de de 2-2";
//        pat = Pattern.compile("(\\d+)");
//        mat = pat.matcher(texto);
//        System.out.println("Original —> " + texto);
//
//        System.out.println(mat.find());
//        System.out.println("Resultante -> " + mat.replaceFirst((new Integer((new Integer(mat.group(1))).intValue() + 1)).toString()));
//
//    }
    
    public static void sustitucion(String args) {
        /*PROGRAMA HECHO EN LENGUAJE PERL 
         $c0=$c1="Hay un tono salvo de mi a fa, y de si a do.";
         $r=$c1=~s/do|re|mi|fa|sol|la|si/NOTA/g;
         print "Original [$c0]\nResultante [$c1]";$c0=$_="El resultado del partido ha sido de de 2-2";
         s/(\d+)/$1+1/e;
         print "\nOriginal [$c0]\nResultante [$_]"
         */

        Matcher mat = null;
        Pattern pat = null;

        String texto = "Hay un tono salvo de mi a fa, y de si a do.";

        System.out.println("==Primer Ejemplo======");
        pat = Pattern.compile("do|re|mi|fa|sol|la|si");
        mat = pat.matcher(texto);
        System.out.println("Original —> " + texto);
        System.out.println("Resultante -> " + mat.replaceAll("NOTA"));

        System.out.println("\n==Segundo Ejemplo====");
        texto = "El resultado del partido ha sido de de 2-2";
        pat = Pattern.compile("(\\d+)");
        mat = pat.matcher(texto);
        System.out.println("Original —> " + texto);

        System.out.println(mat.find());
        System.out.println("Resultante -> " + mat.replaceFirst((new Integer((new Integer(mat.group(1))).intValue() + 1)).toString()));

    }
}
