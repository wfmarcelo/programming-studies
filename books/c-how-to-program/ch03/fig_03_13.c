// Fig. 3.13: fig03_13.c
// Preincrementing and postincrementing.
#include <stdio.h>

int main(void)
{
	int c;

	c = 5;
	printf("%d\n",c);
	printf("%d\n",c++);
	printf("%d\n",c);

	c = 5;

	printf("%d\n",c);
	printf("%d\n",++c);
	printf("%d\n",c);
}
