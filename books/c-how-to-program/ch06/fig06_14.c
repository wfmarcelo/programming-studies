// Fig. 6.14: fig06_14.c
// Using the const type qualifier with arrays.
#include <stdio.h>

void tryToModifyArray(const int b[]);

int main(void)
{
	int a[] = { 10, 20, 30 };

	tryToModifyArray(a);

	printf("%d %d %d\n", a[0], a[1], a[2]);
}

void tryToModifyArray(const int b[])
{
	b[0] /= 2;
	b[1] /= 2;
	b[2] /= 2;
}
