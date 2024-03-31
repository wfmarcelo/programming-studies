// Fig. 4.2: fig04_02.c
// Counter-controlled repetition with the for statement.
#include <stdio.h>

int main(void)
{
	unsigned int counter;

	for (counter = 1; counter <= 10; counter++)
	{
		printf("%u\n", counter);
	}
}
