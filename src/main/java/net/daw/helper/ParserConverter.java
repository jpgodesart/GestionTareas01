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
public class ParserConverter {

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String h6(String text) throws Exception {

        String[] textSplit = text.split("======");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

        try {
            for (int x = 0; x < textSplit.length; x++) {
                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }

                textFomat += textSplit[x] + "<" + close + "h6>";

            }
            if (h6 == true) {
                textFomat = textFomat.substring(0, textFomat.length() - 4);
            }
        } catch (Exception e) {
            throw new ServletException("Method h6 Error: " + e.getMessage());
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String h5(String text) throws Exception {

        String[] textSplit = text.split("=====");

        String textFomat = "";
        String close = "";
        boolean h6 = false;
        try {
            for (int x = 0; x < textSplit.length; x++) {
                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }

                textFomat += textSplit[x] + "<" + close + "h5>";

            }
            if (h6 == true) {
                textFomat = textFomat.substring(0, textFomat.length() - 4);
            }
        } catch (Exception e) {
            throw new ServletException("Method h5 Error: " + e.getMessage());
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String h4(String text) throws Exception {

        String[] textSplit = text.split("====");

        String textFomat = "";
        String close = "";
        boolean h6 = false;
        try {
            for (int x = 0; x < textSplit.length; x++) {
                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }

                textFomat += textSplit[x] + "<" + close + "h4>";

            }
            if (h6 == true) {
                textFomat = textFomat.substring(0, textFomat.length() - 4);
            }
        } catch (Exception e) {
            throw new ServletException("Method h4 Error: " + e.getMessage());
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String h3(String text) throws Exception {

        String[] textSplit = text.split("===");

        String textFomat = "";
        String close = "";
        boolean h6 = false;
        try {
            for (int x = 0; x < textSplit.length; x++) {
                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }

                textFomat += textSplit[x] + "<" + close + "h3>";

            }
            if (h6 == true) {
                textFomat = textFomat.substring(0, textFomat.length() - 4);
            }
        } catch (Exception e) {
            throw new ServletException("Method h3 Error: " + e.getMessage());
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String h2(String text) throws Exception {

        String[] textSplit = text.split("==");

        String textFomat = "";
        String close = "";
        boolean h6 = false;
        try {
            for (int x = 0; x < textSplit.length; x++) {
                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }

                textFomat += textSplit[x] + "<" + close + "h2>";

            }
            if (h6 == true) {
                textFomat = textFomat.substring(0, textFomat.length() - 4);
            }
        } catch (Exception e) {
            throw new ServletException("Method h2 Error: " + e.getMessage());
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String h1(String text) throws Exception {

        String[] textSplit = text.split("=");

        String textFomat = "";
        String close = "";
        boolean h6 = false;
        try {
            for (int x = 0; x < textSplit.length; x++) {
                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }

                textFomat += textSplit[x] + "<" + close + "h1>";

            }
            if (h6 == true) {
                textFomat = textFomat.substring(0, textFomat.length() - 4);
            }
        } catch (Exception e) {
            throw new ServletException("Method h1 Error: " + e.getMessage());
        }
        return textFomat;
    }

//    public String aIntern(String text) {
//
//        String[] textSplit = text.split("=");
//
//        String textFomat = "";
//        String close = "";
//        boolean a = false;
//
//        for (int x = 0; x < textSplit.length; x++) {
//            if (a) {
//                a = false;
//                close = "/";
//            } else {
//                close = "";
//                a = true;
//            }
//            textFomat += textSplit[x] + "<a" + close + ">";
//
//        }
//        return textFomat;
//    }
    
    /**
     *
     * @param text
     * @return
     * @throws Exception
     */
    public String aExtern(String text) throws Exception {

        String[] textSplit = text.split("\\[");

        String textFomat = "";
        String tag = "";
        boolean a = false;
        try {
            if (textSplit.length != 1) {
                for (int x = 0; x < textSplit.length; x++) {

                    if (x == 0) {
                        textFomat += textSplit[x];
                        x++;
                    }

                    String[] spl = textSplit[x].split("\\]");
                    String[] split = spl[0].split("\\|");
                    if (spl.length == 1) {
                        tag = "<a href='" + split[0] + "'>" + split[1] + "&nbsp<i class='icon-globe'></i></a>";
                    } else {
                        tag = "<a href='" + split[0] + "'>" + split[1] + "&nbsp<i class='icon-globe'></i></a>" + spl[1];
                    }
                    textFomat += tag;
                }
            }
        } catch (Exception e) {
            throw new ServletException("Method aExtern Error: " + e.getMessage());
        }
        if(textFomat.isEmpty()){
            textFomat = text;
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     * @throws java.lang.Exception
     */
    public String p(String text) throws Exception {
        String[] textSplit = text.split("\n");
        String textFomat = "";
        try {
            for (int p = 0; p < textSplit.length; p++) {
                System.out.println("hola: " + p + " - " + textSplit[p]);
                textFomat += "<p>" + textSplit[p] + "</p>";
            }
        } catch (Exception e) {
            throw new ServletException("Method p Error: " + e.getMessage());
        }
        return textFomat;
    }

}
