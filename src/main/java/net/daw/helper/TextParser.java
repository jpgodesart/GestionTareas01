/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import javax.servlet.ServletException;

/**
 *
 * @author Alvaro
 */
public class TextParser {

    public static String toHtml(String text) throws Exception {
        ParserConverter oParserConverter = new ParserConverter();
        try {
            text = oParserConverter.h(text,"======");
            text = oParserConverter.h(text,"=====");
            text = oParserConverter.h(text,"====");
            text = oParserConverter.h(text,"===");
            text = oParserConverter.h(text,"==");
            text = oParserConverter.h(text,"=");
            text = oParserConverter.aExtern(text);
            text = oParserConverter.p(text);
        } catch (Exception e) {
            throw new ServletException("TextParser Error: " + e.getMessage());
        }
        return text;
    }

}
