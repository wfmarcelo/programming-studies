// Fig. 17.9: Time.cpp
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

void Time::setTime(int h, int m, int s)
{
    setHour(h);
    setMinute(m);
    setSecond(s);
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

int Time::getHour()
{
    return hour;
}

int Time::getMinute()
{
    return minute;
}

int Time::getSecond()
{
    return second;
}

void Time::printUniversal()
{
    cout << setfill('0') << setw(2) << getHour() << ":"
        << setw(2) << getMinute() << ":" << setw(2) << getSecond();
}

void Time::printStandard()
{
    cout << ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12)
        << ":" << setfill('0') << setw(2) << getMinute()
        << ":" << setw(2) << getSecond() << (getHour() < 12 ? "AM" : "PM");
}
