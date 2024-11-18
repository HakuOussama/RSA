// -*- coding: utf-8 -*-

#include <stdio.h>
#include <stdlib.h>
#include <openssl/sha.h>

int main() {
  unsigned char resume_sha1[SHA_DIGEST_LENGTH];
  unsigned char message[] = "Alain Turin";
  printf("Message à hacher: \"%s\" (%lu octets)\n", message , sizeof(message)-1);

  SHA1(message, sizeof(message)-1, resume_sha1);

  printf("Le résumé SHA1 de cette chaîne est: 0x");
  for(int i = 0; i < SHA_DIGEST_LENGTH; i++) printf("%02X", resume_sha1[i]);
  printf("\n");
  exit(EXIT_SUCCESS);  
}

/*
  $ make
  gcc -o resume_sha1 -I/usr/local/include -I/usr/include resume_sha1.c -L/usr/local/lib
  -L/usr/lib -lm -lssl -lcrypto -g -Wall -std=c99 
  $ ./resume_sha1 
  Message à hacher: "Alain Turin" (11 octets)
  Le résumé SHA1 de cette chaîne est: 0x9B682F2CA6F44CB60493288A686DE5D81ECA6B6D
*/
