// Fig. 6.13: fig06_13.c
// Passing arrays and individual array elements to functions.
#include <stdio.h>
#define SIZE 5

void modifyArray(int b[], size_t size);
void modifyElement(int e);

int main(void)
{
	int a[SIZE] = { 0, 1, 2, 3, 4 };
	size_t i;

	puts("Effects of passing entire array by reference:\n\nThe "
		"Values of the original array are:");

	for (i =0; i < SIZE; i++)
	{
		printf("%3d", a[i]);
	}

	puts("");

	modifyArray(a, SIZE);

	puts("The values of the modified array are:");

	for (i = 0; i < SIZE; i++)
	{
		printf("%3d", a[i]);
	}

	printf("\n\n\nEffects of passing array element "
		"by value:\n\nThe value of a[3] is %d\n", a[3]);

	modifyElement(a[3]);

	printf("The value of a[3] is %d\n", a[3]);
}

void modifyArray(int b[], size_t size)
{
	size_t j;

	for (j = 0; j < size; j++)
	{
		b[j] *= 2;
	}
}

void modifyElement(int e)
{
	printf("Value in modifyElement is %d\n", e *= 2);
}
