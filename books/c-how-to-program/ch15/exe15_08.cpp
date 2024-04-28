// Exe. 15.8: exe15_08.cpp
// Testing function min, that return the minimum value
#include <iostream>
using namespace std;

#include "minimum.h"

int main()
{
    int int1, int2;
    cout << "Input two integers values: ";
    cin >> int1 >> int2;

    cout << "The minimum integer value is: "
        << minimum(int1, int2);

    double double1, double2;
    cout << "\n\nInput two double values: ";
    cin >> double1 >> double2;

    cout << "The minimum double value is: "
        << minimum(double1, double2);

    char char1, char2;
    cout << "\n\nInput two characters: ";
    cin >> char1 >> char2;

    cout << "The minimum character value is: "
        << minimum(char1, char2) << endl;

}