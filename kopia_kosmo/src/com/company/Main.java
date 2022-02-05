package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static boolean listaZawiera(List<Character> lista, char litera) {
        for (char znak : lista) //dla kazdego znaku w tej liscie wykona rozkaz w pętli
        {
            if (znak == litera)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final int[] K = {1, 2, 3, 4, 5};
        final int[] A = {1, 0, 0, 1, 0};
        final int[] B = {0, 1, 1, 1, 0};
        final int[] C = {0, 0, 1, 0, 1};
        final int[] D = {1, 1, 0, 0, 1};
        int i = 0;

        HashMap<Integer,char[]>hashmap_kosmonauci=new HashMap<Integer, char[]>();
        hashmap_kosmonauci.put(K[0], new char[]{'A','D'});
        hashmap_kosmonauci.put(K[1], new char[]{'B','D'});
        hashmap_kosmonauci.put(K[2], new char[]{'B','C'});
        hashmap_kosmonauci.put(K[3], new char[]{'A','B'});
        hashmap_kosmonauci.put(K[4], new char[]{'C','D'});

        // char [] specjalizacje=new char[4];

        int[] wybraniKosmonauci = new int[5];
        List<Character> specjalizacje = new ArrayList<Character>();


        int nieZapelnioneSpec = 4;


        while (i < K.length) {

         int aktualnyKosmonauta=K[i];
         System.out.println("k" + aktualnyKosmonauta+ Arrays.toString(hashmap_kosmonauci.get(K[i])));
         i++;
        }
        System.out.println(Arrays.toString(wybraniKosmonauci));

        while (nieZapelnioneSpec > 0 && i < K.length) {
            int aktualnyKosmonauta=K[i];
            char[] specjalizacjeKosmonauty= hashmap_kosmonauci.get(K[i]);
            i++;
        }
    }


}