// Fig. 17.2: Time.cpp
// Time class member-function definitions.
#include <iostream>
#include <iomanip>
#include <stdexcept>
#include "Time.h"

using namespace std;

Time::Time()
{
    hour = minute = second = 0;
}

void Time::setTime(int h, int m, int s)
{
    if (!(h >= 0 && h < 24))
    {
        throw invalid_argument("hour must be equal or greater than 0 and less than 24");
    }

    if (!(m >= 0 && m < 60))
    {
        throw invalid_argument("minute must be equal or greater than 0 and less than 60");
    }

    if (!(s >= 0 && s < 60))
    {
        throw invalid_argument("second must be equal or greater than 0 and less than 60");
    }
    
    hour = h;
    minute = m;
    second = s;
}

void Time::printUniversal()
{
    cout << setfill('0') << setw(2) << hour << ":"
        << setw(2) << minute << ":" << setw(2) << second;
}

void Time::printStandard()
{
    cout << ((hour == 0 || hour == 12) ? 12 : hour % 12) << ":"
        << setfill('0') << setw(2) << minute << ":" <<setw(2)
        << second << (hour < 12 ? "AM" : "PM");
}