// Exe. 4.3.d: exe04_03_d.c
// Printing the numbers from 1 to 20 five by five
#include <stdio.h>

int main(void)
{
	unsigned x;

	x = 1;

	while(x <= 20)
	{
		printf("%u", x);

		if(x % 5 == 0)
		{
			printf("\n");
		}
		else
		{
			printf("\t");
		}

		x++;
	}
}
