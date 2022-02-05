package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        System.out.println(Fib(12));
    }


    public static int Fib(int n) {
        int[] tab = new int[n + 1];
        tab[0] = n;
        tab[1] = n;
        tab[2] = n;

        for (int i = 4; i < tab.length; i++) {
            if (n % 3 == 0) {
                tab[i] = Math.abs(tab[i - 1] - tab[i - 2] - tab[i - 3]);
            }
            if (n % 3 == 1) {
                tab[i] = (tab[i - 1] + tab[i - 2]) * tab[i - 3];
            }
            if (n % 3 == 2) {
                tab[i] = (tab[i - 1] - tab[i - 2]) * tab[i - 3];
            }
        }

        return tab[tab.length - 1];
    }

   public static void MonteCarlo(int LIMIT_LOSOWAN){
       final int LIMIT_PRZESTROJEN = 4;
       Integer sumaCzasuPrzestrojenia = 0;
       int aktualnyNumerPrzestrojenia = 0;
       int iloscDokonanychPrzestrojen = 0;
       int nastepnaPodstawaPrzestrojenia = 0;
       Integer najlepszyWynik = 99999999;
       Integer[] najlepszeIndeksyPrzestrojen = new Integer[100];
       Integer[] indeksyPrzestrojenAktualne = new Integer[100];
       Random losuj = new Random();

       final Integer czasyMaszyny[][] = {
               {0, 6, 4, 5, 99 },
               {4, 0, 2 , 99 ,7 },
               {2, 99, 0, 9, 4 },
               {3, 8, 99, 0, 4 },
               {5,9,1,99,0 }
       };



       for (int i = 0; i < LIMIT_LOSOWAN; i++) // petla do tworzenia rozwiazan zadania
       {
           sumaCzasuPrzestrojenia = 0;


           aktualnyNumerPrzestrojenia = losuj.nextInt(LIMIT_PRZESTROJEN);


           while(iloscDokonanychPrzestrojen < LIMIT_PRZESTROJEN){

               nastepnaPodstawaPrzestrojenia = losuj.nextInt(LIMIT_PRZESTROJEN);
               while(Arrays.asList(indeksyPrzestrojenAktualne).stream().anyMatch(Predicate.isEqual(nastepnaPodstawaPrzestrojenia))
                       || czasyMaszyny[aktualnyNumerPrzestrojenia][nastepnaPodstawaPrzestrojenia] == 99){
                   nastepnaPodstawaPrzestrojenia = losuj.nextInt(LIMIT_PRZESTROJEN);
               }

               sumaCzasuPrzestrojenia+= czasyMaszyny[aktualnyNumerPrzestrojenia][nastepnaPodstawaPrzestrojenia];
               iloscDokonanychPrzestrojen++;
               indeksyPrzestrojenAktualne[iloscDokonanychPrzestrojen] = nastepnaPodstawaPrzestrojenia;

               aktualnyNumerPrzestrojenia = nastepnaPodstawaPrzestrojenia;
           }

           if(sumaCzasuPrzestrojenia < najlepszyWynik){
               najlepszyWynik = sumaCzasuPrzestrojenia;
               najlepszeIndeksyPrzestrojen = indeksyPrzestrojenAktualne.clone();
           }



       }

       System.out.println("Najlepszy czas");
       System.out.println(najlepszyWynik);
       System.out.println(Arrays.toString(najlepszeIndeksyPrzestrojen));

       int[] wyniki = new int[999];
       int iter = 0;
       for (int i = 0; i < najlepszeIndeksyPrzestrojen.length; i++){
           if (najlepszeIndeksyPrzestrojen[i] != null){
               wyniki[iter] = najlepszeIndeksyPrzestrojen[i];
               iter++;
           }
       }
   }
}
