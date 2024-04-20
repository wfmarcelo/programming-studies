// Fig. 6.3: fig06_03.c
// Initializing the elements of an array to zeros.
#include <stdio.h>

int main(void)
{
	int n[10];
	size_t i;

	for (i = 0; i < 10; i++)
	{
		n[i] = 0;
	}

	printf("%s%13s\n", "Element", "Value");

	for (i = 0; i < 10; i++)
	{
		printf("%7lu%13d\n", i, n[i]);
	}
}
