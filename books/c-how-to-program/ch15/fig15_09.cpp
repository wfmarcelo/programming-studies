// Fig. 15.9: fig15_09.cpp
// Using the unary scope resolution operator.
#include <iostream>
using namespace std;

int number = 7;

int main()
{
	double number = 10.5;

	cout << "Local double value of number = " << number
		<< "\nGlobal int value of number = " << ::number << endl;
}
