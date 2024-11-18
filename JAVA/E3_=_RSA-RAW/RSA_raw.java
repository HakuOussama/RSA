// -*- coding: utf-8 -*-

import java.math.BigInteger;

public class RSA_raw
{
  private static BigInteger clair, chiffré, déchiffré ;
  private static BigInteger n ;      // Le module de la clef publique
  private static BigInteger e ;      // L'exposant de la clef publique
  private static BigInteger d ;      // L'exposant de la clef privée
  private static  KeyPair keyPair ;
    
  static void fabrique() {           // Fabrique d'une paire de clefs RSA (A MODIFIER)
    //n = new BigInteger("196520034100071057065009920573", 10);
    //e = new BigInteger("7", 10);
    //d = new BigInteger("56148581171448620129544540223", 10);
    BigInteger p=Alea.getPrimeNumber();
    BigInteger q=Alea.getPrimeNumber();
    n = p.multiply(q);
    BigInteger w = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    int result = 0;
    d=Alea.getPrimeNumber();
    while(result!= -1){
      d=  Alea.getPrimeNumber() ;
      result =d.compareTo(w) ;
    }
    e = d.modInverse(w);
    PublicKey publicKey = new PublicKey(n,e);
    PrivatKey privatKey = new PrivatKey(d);
    keyPair = new KeyPair(publicKey,privatKey);
    }

  public static void main(String[] args)
  {  
    clair = new BigInteger("4b594f544f", 16);

    /* Affichage du clair */
    System.out.println("Clair             : " + clair);
    
    fabrique(); 

    /* Affichage des clefs utilisées */
    System.out.println("Clef publique (n) : " + n);
    System.out.println("Clef publique (e) : " + e);
    System.out.println("Clef privée (d)   : " + d);

    /* On effectue d'abord le chiffrement RSA du clair clair avec la clef publique */
    chiffré = clair.modPow(e, n);
    System.out.println("Chiffré           : " + chiffré);

    /* On déchiffre ensuite avec la clef privée */
    déchiffré = chiffré.modPow(d, n);
    System.out.println("Déchiffré         : " + déchiffré);
  }
}

