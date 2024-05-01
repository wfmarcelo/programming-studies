// Fig. 17.17: Date.h
// Date class declaration.
// Member functions are defined in Date.cpp

#ifndef DATE_H
#define DATE_H

class Date
{
public:
    Date(int = 1, int = 1, int = 2000);
    void print();
private:
    int month;
    int day;
    int year;
};

#endif

