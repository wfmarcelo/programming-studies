// Fig. 5.3: fig05_03.c
// Creating and using a programmer-defined function.
#include <stdio.h>

int square(int y);

int main(void)
{
	int x;

	for (x = 1; x <= 10; x++)
	{
		printf("%d ", square(x));
	}

	puts("");
}

int square(int y)
{
	return y * y;
}
