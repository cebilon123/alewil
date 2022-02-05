package com.company;

import java.lang.*;


class TrasaProgramu {
    final static int tab[][] = new int[][] {
            {0,290,455,485,293,244,287,344},
            {290,0,220,230,94,107,302,207},
            {455,220,0,69,169,279,467,259},
            {485,230,69,0,192,335,527,252},
            {293,94,169,192,0,187,380,130},
            {244,107,279,335,187,0,196,279},
            {287,302,467,527,380,196,0,454},
            {344,207,259,252,130,279,454,0}};

    public static void main(String[] args) {

        OdpowiedzProgramu droga = new OdpowiedzProgramu();
        droga.rozwiazanie(tab, 0);
    }
}

class OdpowiedzProgramu {
    final static int tab[][] = new int[][] {
            {0,290,455,485,293,244,287,344},
            {290,0,220,230,94,107,302,207},
            {455,220,0,69,169,279,467,259},
            {485,230,69,0,192,335,527,252},
            {293,94,169,192,0,187,380,130},
            {244,107,279,335,187,0,196,279},
            {287,302,467,527,380,196,0,454},
            {344,207,259,252,130,279,454,0}};

    static final int iloscDrog = 8;

    void rozwiazanie(int tab[][], int ilosc) {
        int sciezka[] = new int[iloscDrog];
        Boolean sprawdzone[] = new Boolean[iloscDrog];
        for (int i = 0; i < iloscDrog; i++) {
            sciezka[i] = Integer.MAX_VALUE;
            sprawdzone[i] = false;
        }
        sciezka[ilosc] = 0;
        for (int i = 0; i < iloscDrog - 1; i++) {
            int dys = dystansMinimalny(sciezka, sprawdzone);
            sprawdzone[dys] = true;
            for (int j = 0; j < iloscDrog; j++)
                if (!sprawdzone[j] && tab[dys][j] != 0 && sciezka[dys] != Integer.MAX_VALUE && sciezka[dys] + tab[dys][j] < sciezka[j])
                    sciezka[j] = sciezka[dys] + tab[dys][j];
        }
        pokazRozwiazanie(sciezka);
    }

    int dystansMinimalny(int sciezka[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < iloscDrog; i++)
            if (sptSet[i] == false && sciezka[i] <= min) {
                min = sciezka[i];
                min_index = i;
            }

        return min_index;
    }


    void pokazRozwiazanie(int sciezka[]) {
        System.out.println("Droga | minimalny Dystans do przejechania: ");
        int suma = 0;
        for (int i = 0; i < iloscDrog; i++)
        {
            suma += sciezka[i];
            System.out.println(i + " " + sciezka[i]);
        }

        System.out.println("W sumie: " + suma);
    }
}