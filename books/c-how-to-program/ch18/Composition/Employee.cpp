// Fig. 18.11: Employee.cpp
// Employee class member-function definitions.
#include <iostream>
#include "Employee.h"
using namespace std;

Employee::Employee(const string &first, const string &last,
    const Date &dateOfBirth, const Date &dateOfHire)
    : firstName(first),
      lastName(last),
      birthDate(dateOfBirth),
      hireDate(dateOfHire)
{
    cout << "Employee object constructor: "
        << firstName << ' ' << lastName << endl;
}

void Employee::print() const
{
    cout << lastName << ", " << firstName << "  Hired: ";
    hireDate.print();
    cout << "  Birthday: ";
    birthDate.print();
    cout << endl;
}

Employee::~Employee()
{
    cout << "Employee object destructor: "
        << lastName << ", " << firstName << endl;
}