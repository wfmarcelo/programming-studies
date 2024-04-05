// FIg. 5.6: fig05_06.c
// Demonstrating the function call stack
// and stack frames using a function square.
#include <stdio.h>

int square(int);

int main()
{
	int a = 10;

	printf("%d squared: %d\n", a, square(a));
}

int square(int x)
{
	return x * x;
}
