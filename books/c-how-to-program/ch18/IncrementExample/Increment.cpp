// Fig. 18.5: Increment.cpp
// Member-function definitios for class Increment demonstrate using a
// member initializer to initialize a constant of a built-in data type.
#include <iostream>
#include "Increment.h"
using namespace std;

Increment::Increment(int c, int i)
    : count(c),
      increment(i)
{

}

void Increment::print() const
{
    cout << "count = " << count << ", increment = " << increment << endl;
}