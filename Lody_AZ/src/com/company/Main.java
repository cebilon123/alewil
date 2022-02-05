package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int LICZBA_SMAKOW = 6;
        final int LICZBA_LOSOWAN = 100;
        final int czas [][]= new int [6][6];
//x/y
        czas[0][0] = 0;
        czas[0][1] = 7;
        czas[0][2] = 20;
        czas[0][3] = 21;
        czas[0][4] = 12;
        czas[0][5] = 23;

        czas[1][0] = 27;
        czas[1][1] = 0;
        czas[1][2] = 13;
        czas[1][3] = 16;
        czas[1][4] = 46;
        czas[1][5] = 5;

        czas[2][0] = 53;
        czas[2][1] = 15;
        czas[2][2] = 0;
        czas[2][3] = 25;
        czas[2][4] = 27;
        czas[2][5] = 6;

        czas[3][0] = 16;
        czas[3][1] = 2;
        czas[3][2] = 35;
        czas[3][3] = 0;
        czas[3][4] = 47;
        czas[3][5] = 10;

        czas[4][0] = 31;
        czas[4][1] = 29;
        czas[4][2] = 5;
        czas[4][3] = 18;
        czas[4][4] = 0;
        czas[4][5] = 4;

        czas[5][0] = 28;
        czas[5][1] = 24;
        czas[5][2] = 1;
        czas[5][3] = 17;
        czas[5][4] = 5;
        czas[5][5] = 0;


        for (int i = 0; i < czas.length; i++){
            System.out.println(Arrays.toString(czas[i]));
        }


        int[] minKolejnoscSmakow = new int[LICZBA_SMAKOW];
        int minSumaSmakow = 0;

        Random random = new Random();

        for (int i = 0; i < LICZBA_LOSOWAN; i++) {
            int ostatniSmak = -1;
            int[] kolejnoscWLosowaniu = new int[LICZBA_SMAKOW];
            int sumaWLosowaniu = 0;
            int zaprogramowanaLiczbaSmakow = 0;

            while(zaprogramowanaLiczbaSmakow < LICZBA_SMAKOW) {
                int smak = random.nextInt(LICZBA_SMAKOW+1);
                if(ostatniSmak == smak || SmakJestJuzWTablicy(kolejnoscWLosowaniu, smak))
                    continue;

                if(ostatniSmak == -1)
                    ostatniSmak = smak;

                kolejnoscWLosowaniu[zaprogramowanaLiczbaSmakow] = smak;
                zaprogramowanaLiczbaSmakow++;
            }

            for(int j = 1; j< zaprogramowanaLiczbaSmakow-1; j++) {
                sumaWLosowaniu += czas[kolejnoscWLosowaniu[j-1]][]
            }

            System.out.println("Wylosowane smaki: "+Arrays.toString(kolejnoscWLosowaniu));
            System.out.println("Suma smakow: "+ sumaWLosowaniu);
        }
    }

    public static boolean SmakJestJuzWTablicy(int[] tablica, int smak){
        System.out.println(Arrays.toString(tablica)+" smak "+smak);
        for (int i =0; i < tablica.length; i++){
            if(tablica[i] == smak)
                return true;
        }

        return false;
    }
}
