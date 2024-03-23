// Exe 3.7: exe_03_07.c
// Calculate the power of numbers
#include <stdio.h>

int main(void)
{
	unsigned int x, y, power, i;

	power = 1;
	i = 1;

	printf("%s", "Enter the first integer : ");
	scanf("%u", &x);

	printf("%s", "Enter the second integer : ");
	scanf("%u", &y);

	while (i <= y)
	{
		power *= x;
		i++;
	}

	printf("The power of %u by %u is %u\n", x, y, power);
}
