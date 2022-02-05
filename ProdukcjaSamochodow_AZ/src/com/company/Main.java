package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, int[]> oddzialyProdukcja = new HashMap<>();
        oddzialyProdukcja.put(1, new int[]{1000, 2000}); // nadwozia
        oddzialyProdukcja.put(2, new int[]{1200, 1440}); // silniki
        oddzialyProdukcja.put(3, new int[]{1100, 0});    // montujacy osobowe
        oddzialyProdukcja.put(4, new int[]{0, 1200});    // montujacy ciezarowe

        final int zyskSamochodOsobowy = 3200;
        final int zyskCiezarowy = 2200;

        int aktualnyZysk = 0;
        int liczbaOsobowychWyprodukowanych = 0, liczbaCiezarowychWyprodukowanych = 0;
        int limitProdukcjiOsobowych = oddzialyProdukcja.get(3)[0];
        int limitProdukcjiCiezarowych = oddzialyProdukcja.get(4)[1];

        while (limitProdukcjiOsobowych > 0 && limitProdukcjiCiezarowych > 0) {
            if (MoznaProdukowacOsobowy(limitProdukcjiOsobowych, oddzialyProdukcja.get(1)[0], oddzialyProdukcja.get(2)[0])) {
                limitProdukcjiOsobowych--;
                oddzialyProdukcja.get(1)[0]--;
                oddzialyProdukcja.get(2)[0]--;
                aktualnyZysk += zyskSamochodOsobowy;
                liczbaOsobowychWyprodukowanych++;
            } else {
                limitProdukcjiCiezarowych--;
                oddzialyProdukcja.get(1)[1]--;
                oddzialyProdukcja.get(2)[1]--;
                aktualnyZysk += zyskCiezarowy;
                liczbaCiezarowychWyprodukowanych++;
            }
            System.out.println("Aktualnie zarobiono: " + aktualnyZysk);
        }

        System.out.println("Zysk: " + aktualnyZysk);
        System.out.println("Osobowe: " + liczbaOsobowychWyprodukowanych);
        System.out.println("Ciezarowe: " + liczbaCiezarowychWyprodukowanych);
    }

    public static boolean MoznaProdukowacOsobowy(int limitProdukcjiOsobowych, int nadwozia, int silniki) {
        return limitProdukcjiOsobowych > 0 && nadwozia > 0 && silniki > 0;
    }
}
