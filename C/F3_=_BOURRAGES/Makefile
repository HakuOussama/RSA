CC = gcc

INCLUDE = -I/usr/local/include -I/usr/include
LIB = -L/usr/local/lib -L/usr/lib -lgmp -g -std=c99 -Wall

all: rsa

rsa: rsa.c
	$(CC) -o rsa $(INCLUDE) rsa.c $(LIB)

clean:
	-rm *.o *~
	-rm rsa
