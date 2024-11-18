// -*- coding: utf-8 -*-

import java.math.BigInteger;
    
public class EPP
{	
    public static void main(String[] args)
    {
        BigInteger n = new BigInteger("170141183460469231731687303715884105727", 10);

        System.out.print("Le nombre " + n);
        if (est_probablement_premier(n))
            System.out.println(" est très probablement premier!");
        else
            System.out.println(" n'est absolument pas premier!");
    }

    static boolean est_probablement_premier(BigInteger n)
    {
        /*
          Modifiez cette fonction afin qu'elle retourne si oui
          ou non l'entier n est un nombre premier, avec un taux 
          d'erreur inférieur à 1/1000 000 000 000 000 000.
        */  
        return false;			     
    }
}

/*
  $ make
  javac *.java 
  $ java EPP
  Le nombre 170141183460469231731687303715884105727 ...
*/

