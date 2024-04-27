// Fig. 15.13: fig15_13.cpp
// Demonstrating function template maximum.
#include <iostream>
using namespace std;

#include "maximum.h"

int main()
{
    int int1, int2, int3;

    cout << "Input three integer values: ";
    cin >> int1 >> int2 >> int3;

    cout << "The maximum integer value is: "
        << maximum(int1, int2, int3);

    double double1, double2, double3;

    cout << "\n\nInput three dobule values: ";
    cin >> double1 >> double2 >> double3;

    cout << "The maximum double value is: "
        << maximum(double1, double2, double3);

    char char1, char2, char3;

    cout << "\n\nInput three characters: ";
    cin >> char1 >> char2 >> char3;

    cout << "The maximum character value is: "
        << maximum(char1, char2, char3) << endl;
}