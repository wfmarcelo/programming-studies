// Fig. 17.18: Date.cpp
// Date class member-function definitions.
#include <iostream>
#include "Date.h"
using namespace std;

Date::Date(int m, int d, int y)
{
    month = m;
    day = d;
    year = y;
}

void Date::print()
{
    cout << month << '/' << day << '/' << year;
}