// Exe. 4.3.e: exe04_03_e.c
// Printing numbers from 1 to 20, 5 by 5
#include <stdio.h>

int main(void)
{
	unsigned x;

	for(x = 1; x <= 20; x++)
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
	}
}
