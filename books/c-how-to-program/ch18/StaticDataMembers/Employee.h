// Fig. 18.18: Employee.h
// Employee class definition with a static data member to
// track the number of Employee objects in memory
#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>
using namespace std;

class Employee
{
public:
    Employee(const string &, const string &);
    ~Employee();
    
    string getFirstName() const;
    string getLastName() const;

    static int getCount();
private:
    string firstName;
    string lastName;

    static int count;
};


#endif