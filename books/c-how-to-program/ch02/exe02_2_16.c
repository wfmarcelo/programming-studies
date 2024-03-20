// Perform basic arithmetic operations
#include <stdio.h>

int main(void)
{
	int number1, number2;

	printf("%s", "Enter two integers to perform calculations: ");
	scanf("%d%d", &number1, &number2);

	printf("The sum of %d and %d is %d\n", number1, number2, number1 + number2);
	printf("The product of %d and %d is %d\n", number1, number2, number1 * number2);
	printf("The difference of %d and %d is %d\n", number1, number2, number1 - number2);
	printf("The quotient of %d and %d is %d\n", number1, number2, number1 / number2);
	printf("The remainder of %d and %d is %d\n", number1, number2, number1 % number2);
}
