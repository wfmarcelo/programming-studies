// Fig. 17.10: fig17_10.cpp
// Constructor with default arguments for class Time.
#include <iostream>
#include <stdexcept>
#include "Time.h"
using namespace std;

const size_t SIZE = 5;

int main()
{
    Time timeList[SIZE];
    Time t1;
    Time t2(2);
    Time t3(21, 34);
    Time t4(12,25,42);

    timeList[1] = t1;
    timeList[2] = t2;
    timeList[3] = t3;
    timeList[4] = t4;

    cout << "Constructed with:" << endl;

    for (size_t i = 1; i < SIZE; i++)
    {
        cout << "\n\nt" << i << ":\n   ";
        timeList[i].printUniversal();
        cout << "\n   ";
        timeList[i].printStandard();
    }

    try
    {
        Time t5(24, 74, 99);
    }
    catch(const invalid_argument& e)
    {
        cerr << "\n\nException while initializing t5: " << e.what() << endl;
    }
}