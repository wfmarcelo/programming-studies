// Exe. 4.3.b: exe04_03_b.c
// Printing floating number with formating

#include <stdio.h>

int main(void)
{
	float number = 333.546372;

	printf("%-15.1f\n", number);
	printf("%-15.2f\n", number);
	printf("%-15.3f\n", number);
	printf("%-15.4f\n", number);
	printf("%-15.5f\n", number);
}
