// Fig. 18.1: Time.h
// Time class definition with const member functions.
// Member functions defined in Time.cpp
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

    int getHour() const;
    int getMinute() const;
    int getSecond() const;

    void printUniversal() const;
    void printStandard();
private:
    int hour;
    int minute;
    int second;
};

#endif