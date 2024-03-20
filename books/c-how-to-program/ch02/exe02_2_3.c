// Exercise 2.3

#include <stdio.h>

int main(void)
{
	int c;
	int thisVariable;
	int q76354;
	int number;

	printf("%s", "Enter an integer: ");
	scanf("%d", &number);

	if (number != 7)
		puts("The variable number is not equal to 7.");

	puts("This is a C program.");
	printf("%s\n%s\n","This is a C", "program.");
	printf("%s\n%s\n%s\n%s\n%s\n", "This", "is", "a", "C", "Program");
	printf("%s\t%s\t%s\t%s\t%s\n", "This", "is", "a", "C", "Program");
}
