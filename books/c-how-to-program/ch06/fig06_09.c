// Fig. 6.9: fig06_09.c
// Roll a siz-sided die 6,000,000 times
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 7

int main(void)
{
	size_t face;
	unsigned int roll;
	unsigned int frequency[SIZE] = { 0 };

	srand(time(NULL));

	for (roll = 1; roll <= 6000000; roll++)
	{
		face = 1 + rand() % 6;
		++frequency[face];
	}

	printf("%s%17s\n", "Face", "Frequency");

	for (face = 1; face < SIZE; ++face) 
	{
		printf("%4lu%17u\n", face, frequency[face]);
	}
}
