// Fig. 18.10: Employee.h
// Employee class definition showing composition.
// Member functions defined in Employee.cpp
#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>
#include "Date.h"
using namespace std;

class Employee
{
public:
    Employee(const string &, const string &,
        const Date &, const Date &);
    void print() const;
    ~Employee();
private:
    string firstName;
    string lastName;
    const Date birthDate;
    const Date hireDate;
};

#endif