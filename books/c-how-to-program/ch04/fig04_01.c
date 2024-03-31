// Fig. 4.1: fig04_01.c
// Counter-controlled repetition.
#include <stdio.h>

int main(void)
{
	unsigned int counter = 1;

	while (counter <= 10)
	{
		printf("%u\n", counter);
		counter++;
	}
}
