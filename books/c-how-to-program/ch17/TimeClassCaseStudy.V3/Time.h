// Fig. 17.14: Time.h
// Time class declaration.
// Member functions defined in Time.cpp

#ifndef TIME_H
#define TIME_H

class Time
{
public:
    Time(int = 0, int = 0, int = 0);
    void setTime(int, int, int);
    int getHour();
    int &badSetHour(int);
private:
    int hour;
    int minute;
    int second;
};

#endif