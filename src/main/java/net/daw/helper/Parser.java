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
public class Parser {

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
}
