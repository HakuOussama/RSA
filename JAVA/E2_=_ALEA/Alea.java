// -*- coding: utf-8 -*-

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Random;

public class Alea
{	
    public static void main(String[] args)
    {moyenne(10);

    }

    public static BigInteger generateNumberInRange() {
        Random random = new Random();
        BigInteger number = new BigInteger(1023, random);
        BigInteger lowerBound = BigInteger.ONE.shiftLeft(1023);
        number.add(lowerBound);
        return number;
    }

    public static BigInteger getPrimeNumber() {
        while (true){
        Random random = new Random();
        BigInteger number = new BigInteger(1023, random);
        BigInteger lowerBound = BigInteger.ONE.shiftLeft(1023);
        number.add(lowerBound);
        if(EPP.est_probablement_premier(number)) return number;
        }
    }



    public static  void moyenne(int NbTentative){
        double [] tabTemps = new double[NbTentative];
        double [] tabTentative = new double[NbTentative];
        for(int i=0;i<NbTentative;i++){
            int count=0;
            Long debut=System.nanoTime();
            while(true){
                BigInteger number = generateNumberInRange();
                if (EPP.est_probablement_premier(number)) {
                    tabTentative[i]=count;
                    System.out.println("Nombre de tentative : "+count);
                    double time = ( (System.nanoTime()-debut)/Math.pow(10,6) );
                    tabTemps[i]=time;
                    System.out.println("Temps d'execution : "+ time +" ms");
                    //System.out.println(number);
                    break;
                }
                count++;
            }
        }
        double avergaeTentaives=0;
        double averageTime=0;
        for(int i=0;i<NbTentative;i++){
            avergaeTentaives=avergaeTentaives+tabTentative[i];
            averageTime=averageTime+tabTemps[i];
        }
        System.out.println("Temps Moyenne sur "+NbTentative + " est "+(averageTime/NbTentative));
        System.out.println("Nombre de tentative Moyenne sur "+NbTentative + " est "+(avergaeTentaives/NbTentative));
    }
}

/*
  $ make
  javac *.java 
  $ java Alea
  Valeur de x : 83298061311752912319685844512597155212
  $ java Alea
  Valeur de x : 285871252058034402763697089368152008986
  $ java Alea
  Valeur de x : 197542704085834536850620075483034476692
  $ java Alea
  Valeur de x : 118481379124562405626844429693602702101
  $
*/

