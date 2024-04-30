// Fig. 17.8: Time.h
// Time class containing a constructor with default arguments.
// Member functions defined in Time.cpp.

#ifndef TIME_H
#define TIME_H

class Time
{
public:
    Time(int = 0, int = 0, int = 0);

    void setTime(int, int, int);
    void setHour(int);
    void setMinute(int);
    void setSecond(int);

    int getHour();
    int getMinute();
    int getSecond();

    void printUniversal();
    void printStandard();
private:
    int hour;
    int minute;
    int second;
};

#endif