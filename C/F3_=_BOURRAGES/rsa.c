// -*- coding: utf-8 -*-

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "gmp.h"

typedef unsigned char uchar;

int main(void) {
  //------------------------------------------------------------------
  //  Construction et affichage de la clef
  //------------------------------------------------------------------
  mpz_t e, n, d;
  mpz_inits(n, e, d, (void *)NULL);
  mpz_set_str(n,
	      "00af7958cb96d7af4c2e6448089362\
	      31cc56e011f340c730b582a7704e55\
	      9e3d797c2b697c4eec07ca5a903983\
	      4c0566064d11121f1586829ef6900d\
	      003ef414487ec492af7a12c34332e5\
	      20fa7a0d79bf4566266bcf77c2e007\
	      2a491dbafa7f93175aa9edbf3a7442\
	      f83a75d78da5422baa4921e2e0df1c\
	      50d6ab2ae44140af2b", 16);
  mpz_set_str(e, "10001", 16);
  mpz_set_str(d,
	      "35c854adf9eadbc0d6cb47c4d11f9c\
	      b1cbc2dbdd99f2337cbeb2015b1124\
	      f224a5294d289babfe6b483cc253fa\
	      de00ba57aeaec6363bc7175fed20fe\
	      fd4ca4565e0f185ca684bb72c12746\
	      96079cded2e006d577cad2458a5015\
	      0c18a32f343051e8023b8cedd49598\
	      73abef69574dc9049a18821e606b0d\
	      0d611894eb434a59", 16);

  gmp_printf("Module          (n): %Zd (%d bits)\n", n, mpz_sizeinbase(n, 2));
  gmp_printf("Exposant public (e): %Zd (%d bits)\n", e, mpz_sizeinbase(e, 2));
  gmp_printf("Exposant privé  (d): %Zd (%d bits)\n", d, mpz_sizeinbase(d, 2));

  //------------------------------------------------------------------
  //  Construction et affichage du message clair
  //------------------------------------------------------------------
  uchar m[5] = { 0x4B, 0x59, 0x4F, 0x54, 0x4F } ;
  printf("Message clair      : ");
  for (int i = 0 ; i<sizeof(m) ; i++) printf("0x%02X ", m[i]);
  printf(" (%lu octets)\n", sizeof(m));
  
  //------------------------------------------------------------------
  //  Du message m à l'entier représentatif x (partie à modifier)
  //------------------------------------------------------------------
  mpz_t x;
  mpz_init(x);
  mpz_import (x, sizeof(m), 1, sizeof(m[0]), 0, 0, m);
  gmp_printf("x = %Zd (en décimal)\n", x);     
  gmp_printf("x = 0x%ZX (en hexadécimal)\n", x);

  //------------------------------------------------------------------
  //  Chiffrement de l'entier représentatif
  //------------------------------------------------------------------
  mpz_t c;
  mpz_init(c);
  mpz_powm(c, x, e, n);
  gmp_printf("m^e mod n = %Zd (%d bits)\n", c, mpz_sizeinbase(c, 2));  

  //------------------------------------------------------------------
  //  Décodage de l'entier représentatif
  //------------------------------------------------------------------
  uchar chiffre[256];
  size_t taille;
  mpz_export(chiffre, &taille, 1, 1, 1, 0, c);
  printf("Message chiffré    : ");
  for (size_t i = 0; i < taille; i++) printf("0x%02X ", chiffre[i]);
  printf(" (%lu octets)\n", taille);
  
  /* Libération de la mémoire utilisée */
  mpz_clears (x, c, n, e, d, (void *) NULL);
  exit(EXIT_SUCCESS);
}  

/* 
   $ make
   gcc -o rsa -I/usr/local/include -I/usr/include rsa.c -L/usr/local/lib
       -L/usr/lib -lgmp -g -std=c99 -Wall
   $ ./rsa
   Module          (n): 12322204109610601400...299   (1024 bits)
   Exposant public (e): 65537 (17 bits)
   Exposant privé  (d): 37767385438721355925...209   (1022 bits)
   Message clair      : 0x4B 0x59 0x4F 0x54 0x4F     (5 octets)
   x = 323620918351 (en décimal)
   x = 0x4B594F544F (en hexadécimal)
   m^e mod n = 65891982980551359715048403549...638   (1023 bits)
   Message chiffré    : 0x5D 0xD5 0x53 0x0B ... 0x26 (128 octets)
*/
