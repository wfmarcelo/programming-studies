// Fig. 17.3: fig17_03.cpp
// Program to test class Time.
// NOTE: This file must be compiled with Time.cpp
#include <iostream>
#include "Time.h"

using namespace std;

int main()
{
    Time t;

    cout << "The initial universal time is ";
    t.printUniversal();
    cout << "\nThe initial standard time is ";
    t.printStandard();

    t.setTime(13, 27, 6);

    cout << "\n\nUniversal time after setTime is ";
    t.printUniversal();
    cout << "\nStandard time after setTime is ";
    t.printStandard();

    try
    {
        t.setTime(99, 99, 99);
    }
    catch(invalid_argument &e)
    {
        cout << "\nException: " << e.what() << endl << endl;
    }

    cout << "\n\nAfter attempting invalid settings:"
        << "\nUniversal time: ";
    t.printUniversal();
    cout << "\nStandard time: ";
    t.printStandard();
    cout << endl;
    
}