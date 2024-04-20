// Fig. 6.5: fig06_05.c
// Initializing the elements of array s to the even integers from 2 to 20.
#include <stdio.h>
#define SIZE 10

int main(void)
{
	int s[SIZE];
	size_t j;

	for (j = 0; j < SIZE; j++)
	{
		s[j] = 2 + 2 * j;
	}

	printf("%s%13s\n", "Element", "Value");

	for (j = 0; j < SIZE; j++)
	{
		printf("%7lu%13d\n", j, s[j]);
	}
}
