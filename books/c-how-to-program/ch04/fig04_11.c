// Fig. 4.11: fig04_11.c
// Using the break statement in a for statement.
#include <stdio.h>

int main(void)
{
	unsigned int x;

	for (x = 1; x <= 10; x++)
	{
		if (x == 5)
		{
			break;
		}

		printf("%u ", x);

	}

	printf("\nBroke out the loop at x == %u\n", x);
}
