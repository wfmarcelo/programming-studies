// Fig. 5.11: fig05_11.c
// Shifted, scaled random integers produced by 1 + rand() % 6.
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	unsigned int i;

	for (i = 1; i <= 20; i++)
	{
		printf("%10d", 1 + (rand() % 6));

		if (i % 5 == 0)
		{
			puts("");
		}
	}
}
