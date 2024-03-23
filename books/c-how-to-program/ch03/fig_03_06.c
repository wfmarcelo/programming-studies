// Fig. 3.6: fig03_06.c
// Class average program with counter-controlled repetition.
#include <stdio.h>

int main(void)
{
	unsigned int counter; 
	int grade;
	int total;
	int average;

	total = 0;
	counter = 1;

	while (counter <= 10)
	{
		printf("%s", "Enter grade: ");
		scanf("%d", &grade);
		total = total + grade;
		counter = counter + 1;
	}

	average = total / 10;

	printf("Class average is %d\n", average);
}
