// Fig. 6.15: fig06_15.c
// Sorting an array's values into ascending order.
#include <stdio.h>
#define SIZE 10

void printArray(const int b[], size_t size);
void bubbleSort(int b[], size_t size);

int main(void)
{
	int a[SIZE] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };

	puts("Data items in original order");

	printArray(a, SIZE);
	bubbleSort(a, SIZE);

	puts("\nData items in ascending order");

	printArray(a, SIZE);

	puts("");
}

void printArray(const int b[], size_t size)
{
	size_t i;

	for (i = 0; i < size; i++)
	{
		printf("%4d", b[i]);
	}
}

void bubbleSort(int b[], size_t size )
{
	int pass;
	size_t i;
	int hold;

	for (pass = 1; pass < size; pass++)
	{
		for (i = 0; i < size - 1; i++)
		{
			if(b[i] > b[i + 1])
			{
				hold = b[i];
				b[i] = b[i + 1];
				b[i + 1] = hold;
			}

		}
	}
}
