/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

/**
 *
 * @author Alvaro
 */
public class ParserConverter {

    /**
     *
     * @param text
     * @return
     */
    public String h6(String text) {

        String[] textSplit = text.split("======");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

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
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     */
    public String h5(String text) {

        String[] textSplit = text.split("=====");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

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
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     */
    public String h4(String text) {

        String[] textSplit = text.split("====");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

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
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     */
    public String h3(String text) {

        String[] textSplit = text.split("===");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

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
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     */
    public String h2(String text) {

        String[] textSplit = text.split("==");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

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
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     */
    public String h1(String text) {

        String[] textSplit = text.split("=");

        String textFomat = "";
        String close = "";
        boolean h6 = false;

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
        return textFomat;
    }

    public String aIntern(String text) {

        String[] textSplit = text.split("=");

        String textFomat = "";
        String close = "";
        boolean a = false;

        for (int x = 0; x < textSplit.length; x++) {
            if (a) {
                a = false;
                close = "/";
            } else {
                close = "";
                a = true;
            }
            textFomat += textSplit[x] + "<a" + close + ">";

        }
        return textFomat;
    }

    public String aExtern(String text) {

        String[] textSplit = text.split("\\[");

        String textFomat = "";
        String tag = "";
        boolean a = false;

        for (int x = 0; x < textSplit.length; x++) {

            if (x == 0) {
                textFomat += textSplit[x];
                x++;
            }

            String[] spl = textSplit[x].split("\\]");
            String[] split = spl[0].split("\\|");
            if (spl.length == 1) {
                tag = "<a href='" + split[0] + "'>" + split[1] + "<i class='icon-globe'></i></a>";
            } else {
                tag = "<a href='" + split[0] + "'>" + split[1] + "<i class='icon-globe'></i></a>" + spl[1];
            }
            textFomat += tag;
        }
        return textFomat;
    }

    /**
     *
     * @param text
     * @return
     */
    public String p(String text) {
        String[] textSplit = text.split("\n");
        String textFomat = "";
        for (int p = 0; p < textSplit.length; p++) {
            System.out.println("hola: " + p + " - " + textSplit[p]);
            textFomat += "<p>" + textSplit[p] + "</p>";
        }
        return textFomat;
    }

}
