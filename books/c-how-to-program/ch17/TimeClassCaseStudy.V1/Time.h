// Fig. 17.1: Time.h
// Time class definition.
// Member functions are defined in Time.cpp

#ifndef TIME_H
#define TIME_H

class Time
{
public:
    Time();
    void setTime(int, int, int);
    void printUniversal();
    void printStandard();
private:
    int hour;
    int minute;
    int second;
};

#endif