/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;

/**
 *
 * @author Alvaro
 */
public class TextParser {

    public static String toHtml(String text, String url) throws Exception {
        ParserConverter oParserConverter = new ParserConverter();
        try {
            text = oParserConverter.tag(text, "======", "h6");
            text = oParserConverter.tag(text, "=====", "h5");
            text = oParserConverter.tag(text, "====", "h4");
            text = oParserConverter.tag(text, "===", "h3");
            text = oParserConverter.tag(text, "==", "h2");
            text = oParserConverter.tag(text, "=", "h1");
            text = oParserConverter.tag(text, "\\*\\*", "b");
            text = oParserConverter.tag(text, "\\$\\$", "i");
            text = oParserConverter.a(text, url);
            text = oParserConverter.p(text);
        } catch (Exception e) {
            throw new ServletException("TextParser Error: " + e.getMessage());
        }
        return text;
    }
  
  public static void miau(){
      //URLEncoder.encode(null, null);
  }

  public static void miau1(){
      //URLDecoder.decode(null, null);
  }
}
