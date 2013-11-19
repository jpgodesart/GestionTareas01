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

    public String h6(String text) {
        String prueba = "==hola== yo soy ======iron man====== ahfuisahf ==hola==";

        String[] h = prueba.split("======");

        String hola = "";
        String close = "";
        boolean h6 = false;

        for (int x = 0; x < h.length; x++) {
            System.out.println(x + " - " + h[x]);

                if (h6) {
                    h6 = false;
                    close = "/";
                } else {
                    close = "";
                    h6 = true;
                }
                
                hola += h[x] +"<h6" + close + ">" ;
            System.out.println(hola.substring(hola.length()-4, hola.length()));
        }
        System.out.println(hola);
        return null;
    }

    private String todosH() {
        String prueba = "=hola=yo soy==iron man==ahfuisahf=hola=";
        // String miau = prueba.replaceAll("=(.*?)=", prueba);
        String[] h = prueba.split("======");
        System.out.println();
        String hola = "";
        boolean h1 = false;
        boolean h2 = false;
        boolean h3 = false;
        boolean h4 = false;
        boolean h5 = false;
        boolean h6 = false;
        int count = 0;
        String close = "";
        for (int x = 0; x < h.length; x++) {
            System.out.println(x + " - " + h[x]);
            if (h[x].isEmpty()) {
                count++;
                System.out.println("if");
            } else {

                if (h1 || h2 || h3 || h4 || h5 || h6) {
                    close = "/";
                    switch (count) {
                        case 1:
                            h1 = false;
                            break;
                        case 2:
                            h2 = false;
                            break;
                        case 3:
                            h3 = false;
                            break;
                        case 4:
                            h4 = false;
                            break;
                        case 5:
                            h5 = false;
                            break;
                        case 6:
                            h6 = false;
                            break;
                    }
                } else {
                    close = "";
                    switch (count) {
                        case 1:
                            h1 = true;
                            break;
                        case 2:
                            h2 = true;
                            break;
                        case 3:
                            h3 = true;
                            break;
                        case 4:
                            h4 = true;
                            break;
                        case 5:
                            h5 = true;
                            break;
                        case 6:
                            h6 = true;
                            break;
                    }
                }
                hola += "<h" + count + close + ">" + h[x];

            }
        }
        System.out.println(hola);
        System.out.println("h1" + h1);
        System.out.println("h2" + h2);
        System.out.println("h3" + h3);
        System.out.println("h4" + h4);
        System.out.println("h5" + h5);
        System.out.println("h6" + h6);
        return null;

    }
}
