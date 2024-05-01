// Fig. 18.2: Time.cpp
// Time class member-function definitions.
#include <iostream>
#include <iomanip>
#include <stdexcept>
#include "Time.h"
using namespace std;

Time::Time(int hour, int minute, int second)
{
    setTime(hour, minute, second);
}

void Time::setTime(int hour, int minute, int second)
{
    setHour(hour);
    setMinute(minute);
    setSecond(second);
}

void Time::setHour(int h)
{
    if (!(h >= 0 && h < 24))
        throw invalid_argument("hour must be 0-23");

    hour = h;
}

void Time::setMinute(int m)
{
    if (!(m >= 0 && m < 60))
        throw invalid_argument("minute must be 0-59");

    minute = m;
}

void Time::setSecond(int s)
{
    if (!(s >= 0 && s < 60))
        throw invalid_argument("second must be 0-59");

    second = s;
}

int Time::getHour() const
{
    return hour;
}

int Time::getMinute() const
{
    return minute;
}

int Time::getSecond() const
{
    return second;
}

void Time::printUniversal() const
{
    cout << setfill('0') << setw(2) << hour << ":"
        << setw(2) << minute << ":" << setw(2) << second;
}

void Time::printStandard()
{
    cout << ((hour ==0 || hour == 12) ? 12 : hour % 12)
        << ":" << setfill('0') << setw(2) << minute
        << ":" << setw(2) << second << (hour < 12 ? " AM" : " PM"); 
}