// Exe.3.5: exe_03_05.c
// Calculate the sum of integers from 1 to 10
#include <stdio.h>

int main(void)
{
	int sum, x;
	x = 1;
	sum = 0;

	while (x <= 10)
	{
		sum += x++;
	}

	printf("The sum is: %d\n", sum);
}
