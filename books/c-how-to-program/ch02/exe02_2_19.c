// Calculate and print the sum, average, product
// and prints the smallest and the largest 
// of three integers
#include <stdio.h>

int main(void)
{
	int number1, number2, number3;
	int sum = 0;
	int average = 0;
	int product = 0;
	int smallest = 0;
	int largest = 0;

	printf("%s", "Enter three integers: ");
	scanf("%d%d%d", &number1, &number2, &number3);

	sum = number1 + number2 + number3;
	average = sum / 3;
	product = number1 * number2 * number3;

	if (number1 > number2 && number1 > number3)
		largest = number1;

	if (number2 > number1 && number2 > number3)
		largest = number2;

	if (number3 > number1 && number3 > number2)
		largest = number3;

	if (number1 < number2 && number1 < number3)
		smallest = number1;

	if (number2 < number1 && number2 < number3)
		smallest = number2;

	if (number3 < number1 && number3 < number2)
		smallest = number3;

	printf("Sum is %d\n", sum);
	printf("Average is %d\n", average);
	printf("Product is %d\n", product);
	printf("Smallest is %d\n", smallest);
	printf("Largest is %d\n", largest);
}
