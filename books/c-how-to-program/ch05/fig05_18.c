// Fig. 5.18: fig05_18.c
// Recursive factorial function.
#include <stdio.h>

unsigned long long int factorial(unsigned int number);

int main(void)
{
	unsigned int i;

	for (i = 0; i <= 21; i++)
	{
		printf("%u! == %llu\n", i, factorial(i));
	}
}

unsigned long long int factorial(unsigned int number)
{
	if (number <= 1)
	{
		return 1;
	}
	else
	{
		return (number * factorial(number - 1));
	}
}
