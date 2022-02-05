package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int[] nominaly = {500, 200, 100, 50, 20, 10, 5, 2, 1}; //w groszacxh
        final int[] liczbaMonet = {4, 3, 2, 0, 1, 4, 3, 3, 1}; // liczba nominalow
        int zl = 50, gr = 30, r, i = 0;
        r = zl * 100 + gr;
        System.out.println("reszta do wydania : " + r/100.0);

        int[] zliczaj = new int[nominaly.length];


        while (r > 0 && i < nominaly.length-1) {

                if (nominaly[i] <= r && liczbaMonet[i] > 0) {
                    r = r - nominaly[i];
                    liczbaMonet[i]--;
                    zliczaj[i]++;
                } else i++;


        }
        System.out.println(Arrays.toString(zliczaj));
        for (int j = 0; j < nominaly.length; j++) {
            System.out.println(nominaly[j] / 100.0 + " zł  czyli " + zliczaj[j] + " takie monety razem " + (nominaly[j] / 100.0) * zliczaj[j]);
        }
        if(r>0){
            System.out.println("nie można wydać reszty, pozostało " + r/100.0  );
        }

    }
}
