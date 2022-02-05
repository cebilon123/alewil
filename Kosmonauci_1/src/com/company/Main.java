package com.company;

import java.util.ArrayList;
import java.util.Arrays;
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

        // char [] specjalizacje=new char[4];

        int[] wybraniKosmonauci = new int[5];
        List<Character> specjalizacje = new ArrayList<Character>();


        int nieZapelnioneSpec = 4;


        while (nieZapelnioneSpec > 0 && i < K.length) {

            int aktualnyKos = K[i];
            if (A[i] == 1 && !listaZawiera(specjalizacje,'A')){//jeśli którykolwiewk spełni warunek
                System.out.println("kosmonauta k" + aktualnyKos + " ma specjalizacje A");
                nieZapelnioneSpec--;
                specjalizacje.add('A'); // dodalismy do tablicy (listy) - jest dodana specjalizacja A
                wybraniKosmonauci[i]=aktualnyKos;
            }

            if (B[i] == 1 && !listaZawiera(specjalizacje,'B')) {
                System.out.println("kosmonauta k" + aktualnyKos + " ma specjalizacje B");
                nieZapelnioneSpec--;
                specjalizacje.add('B');
                wybraniKosmonauci[i]=aktualnyKos;
            }

            if (C[i] == 1 && !listaZawiera(specjalizacje,'C')) {
                System.out.println("kosmonauta k" + aktualnyKos + " ma specjalizacje C");
                nieZapelnioneSpec--;
                specjalizacje.add('C');
                wybraniKosmonauci[i]=aktualnyKos;
            }

            if (D[i] == 1 && !listaZawiera(specjalizacje,'D')) {
                System.out.println("kosmonauta k" + aktualnyKos + " ma specjalizacje D");
                nieZapelnioneSpec--;
                specjalizacje.add('D');
                wybraniKosmonauci[i]=aktualnyKos;
            }

            i++;

        }
        System.out.println(Arrays.toString(wybraniKosmonauci));
    }


}

