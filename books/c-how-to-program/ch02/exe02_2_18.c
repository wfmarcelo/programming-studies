// Comparing Integers
#include <stdio.h>

int main(void)
{
	int number1, number2;

	printf("%s", "Enter two integers: ");
	scanf("%d%d", &number1, &number2);

	if (number1 > number2)
		printf("%d is larger\n", number1);

	if (number1 < number2)
		printf("%d is larger\n", number2);

	if (number1 == number2)
		puts("These numbers are equal");
}
