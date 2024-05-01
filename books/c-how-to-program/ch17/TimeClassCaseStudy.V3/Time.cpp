// Fig. 17.15: Time.cpp
// Time class member-function definitions.
#include <stdexcept>
#include "Time.h"
using namespace std;

Time::Time(int hr, int min, int sec)
{
    setTime(hr, min, sec);
}

void Time::setTime(int h, int m, int s)
{
    if (!((h >= 0 && h < 24) && (m >= 0 && m < 60) &&
        (s >= 0 && s < 60)))
        throw invalid_argument(
            "hour, minute and/or second was out of range");

    hour = h;
    minute = m;
    second = s;
}

int Time::getHour()
{
    return hour;
}

// POOR PRACTICE: Returning a reference to a private data member.
int &Time::badSetHour(int hh)
{
    if (!(hh >= 0 && hh < 24))
        throw invalid_argument("hour must be 0-23");

    hour = hh;

    return hour; // DANGEROUS reference return
}