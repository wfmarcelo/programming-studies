// Fig. 4.9: fig04_09.c
// Using the do...while repetition statement.
#include <stdio.h>

int main(void)
{
	unsigned int counter = 1;

	do
	{
		printf("%u ", counter);
	}
	while(++counter <= 10);
	puts("");
}
