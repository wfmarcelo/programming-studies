// Fig. 18.15: Time.h
// Time class modified to enable cascaded member function calls.

// Time class definition.
// Member functions defined in Time.cpp
#ifndef TIME_H
#define TIME_H

class Time
{

public:
    Time(int = 0, int = 0, int = 0);

    Time &setTime(int, int, int);
    Time &setHour(int);
    Time &setMinute(int);
    Time &setSecond(int);

    int getHour() const;
    int getMinute() const;
    int getSecond() const;

    void printUniversal() const;
    void printStandard() const;
private:
    int hour;
    int minute;
    int second;

};

#endif