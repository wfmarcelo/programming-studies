// Fig. 15.5: fig15_05.cpp
// Comparing pass-by-value and pass-by-reference with rederences.
#include <iostream>
using namespace std;

int squareByValue(int);
void squareByReference(int &);

int main()
{
  int x = 2;
  int z = 4;

  cout << "x = " << x << " before squareByValue\n";
  cout << "Value returned by squareByValue: "
    << squareByValue(x) << endl;
  cout << "x = " << x << " after squareByValue\n" << endl;

  cout << "z = " << z << " before sqaureByReference" << endl;
  squareByReference(z);
  cout << "z = " << z << " after squareByReference" << endl;
}

int squareByValue(int number)
{
  return number *= number;
}

void squareByReference(int &numberRef)
{
  numberRef *= numberRef;
}
