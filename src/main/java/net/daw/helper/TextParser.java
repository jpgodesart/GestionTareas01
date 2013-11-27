/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;

/**
 *
 * @author Alvaro
 */
public class TextParser {

    /**
     *
     * @param text
     * @param url
     * @return
     * @throws Exception
     */
    public static String toHtml(String text, String url) throws Exception {
        ParserConverter oParserConverter = new ParserConverter();
        try {
            if (text != null) {
                if (!text.equals("")) {
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
                }
            }
        } catch (Exception e) {
            throw new ServletException("TextParser Error: " + e.getMessage());
        }
        return text;
    }

    /**
     *
     * @param textEncode
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String textEncode(String textEncode) throws UnsupportedEncodingException, ServletException {
        String encode = "";
        try{
        encode = URLEncoder.encode(textEncode, "UTF-8");
        }catch(UnsupportedEncodingException e){
            throw new ServletException("Encode: " + e.getMessage());
        }
        return encode;
    }

    /**
     *
     * @param textDecode
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String textDecode(String textDecode) throws UnsupportedEncodingException, ServletException {
        String decode = "";
        try {
            decode = URLDecoder.decode(textDecode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new ServletException("Decode: " + e.getMessage());
        }
        return decode;
    }
}
