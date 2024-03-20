// This program calculate the product
// of three integers.

#include <stdio.h>

int main(void)
{
	int x, y, z, result;

	printf("%s", "Enter three integers: ");
	scanf("%d%d%d", &x, &y, &z);

	result = x * y * z;

	printf("%s %d.\n", "The product is", result);
}
