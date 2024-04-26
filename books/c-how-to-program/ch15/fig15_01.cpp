// Fig. 15.1: fig15_01.cpp
// Addition program that displays the sum of two numbers.
#include <iostream>

int main()
{
  int number1;

  std::cout << "Enter first integer: ";
  std::cin >> number1;

  int number2;
  int sum;

  std::cout << "Enter second integer: ";
  std::cin >> number2;

  sum = number1 + number2;

  std::cout << "Sum is " << sum << std::endl;

}
