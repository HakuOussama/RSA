CC = gcc

INCLUDE = -I/usr/local/include -I/usr/include
LIB = -L/usr/local/lib -L/usr/lib -lm -lssl -lcrypto -g -Wall -std=c99 

all: resume_sha1

resume_sha1: resume_sha1.c
	$(CC) -o resume_sha1 $(INCLUDE) resume_sha1.c $(LIB)

clean:
	-rm *.o *~
	-rm resume_sha1
