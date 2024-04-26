// Exe. 2.16: exe02_16.c
// Perform calculation with two numbers
#include <stdio.h>

int main(void)
{
  int number1, number2;

  printf("%s", "Enter two integers: ");

  scanf("%d %d", &number1, &number2);

  printf("The sum of %d + %d is %d\n", number1, number2, number1 + number2);
  printf("The product of %d * %d is %d\n", number1, number2, number1 * number2);
  printf("The diference of %d - %d is %d\n", number1, number2, number1 - number2);
  printf("The quotient of %d / %d is %d\n", number1, number2, number1 / number2);
  printf("The remainder of %d %% %d is %d\n", number1, number2, number1 % number2);


}
