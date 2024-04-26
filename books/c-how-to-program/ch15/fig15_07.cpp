// Fig. 15.7: fig15_07.cpp
// Uninitializing and using a reference.
#include <iostream>
using namespace std;

int main()
{
  int x = 3;
  int &y;

  cout << "x = " << x << endl << "y = " << y << endl;
  y = 7;
  cout << "x = " << x << endl << "y = " << y << endl;
}
