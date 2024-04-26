// Fig. 15.6: fig15_06.cpp
// Initializing and using a reference.
#include <iostream>
using namespace std;

int main()
{
  int x = 3;
  int &y = x;

  cout << "x = " << x << endl << "y = " << y << endl;
  y = 7;
  cout << "x = " << x << endl << "y = " << y << endl;
}
