/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletException;

/**
 *
 * @author Alvaro
 */
public class TextParser {

    public static String toHtml(String text) throws Exception {
        ParserConverter oParserConverter = new ParserConverter();
        try {
            text = oParserConverter.h(text, "======");
            text = oParserConverter.h(text, "=====");
            text = oParserConverter.h(text, "====");
            text = oParserConverter.h(text, "===");
            text = oParserConverter.h(text, "==");
            text = oParserConverter.h(text, "=");
            text = oParserConverter.aExtern(text);
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
