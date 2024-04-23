// Fig. 6.11: fig06_11.c
// Static arrays are initialized to zero if not explicitly initialized.
#include <stdio.h>

void staticArrayInit(void);
void automaticArrayInit(void);

int main(void)
{
	puts("First call to each function:");
	staticArrayInit();
	automaticArrayInit();

	puts("\n\nSecond call to each function:");
	staticArrayInit();
	automaticArrayInit();

	puts("");
}

void staticArrayInit(void)
{
	static int array1[3];
	size_t i;

	puts("\nValues on entering staticArrayInit:");

	for (i = 0; i <= 2; i++)
	{
		printf("array1[%lu] = %d  ", i, array1[i]);
	}

	puts("\nValues on exiting staticArrayInit:");

	for (i = 0; i <= 2; ++i)
	{
		printf("array1[%lu] = %d  ", i, array1[i] += 5);
	}
}

void automaticArrayInit(void)
{
	int array2[3] = { 1, 2, 3 };
	size_t i;

	puts("\n\nValues on entering automaticArrayInit:");

	for (i = 0; i<= 2; i++)
	{
		printf("array2[%lu] = %d  ", i, array2[i]);
	}

	puts("\nValues on exiting automaticArrayInit:");

	for (i = 0; i <= 2; i++)
	{
		printf("array2[%lu] = %d  ", i, array2[i] += 5);
	}
}
