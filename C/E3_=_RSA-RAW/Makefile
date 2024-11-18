CC = gcc

INCLUDE = -I/usr/local/include -I/usr/include
LIB = -L/usr/local/lib -L/usr/lib -lgmp -std=c99 -Wall

all: rsa_raw

rsa_raw: rsa_raw.c
	$(CC) -o rsa_raw $(INCLUDE) rsa_raw.c $(LIB)

clean:
	-rm *.o
	-rm rsa_raw
