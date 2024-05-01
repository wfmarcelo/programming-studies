// Fig. 17.16: fig17_16.cpp
// Demonstrating a public member function that
// return a reference to a private data member.
#include <iostream>
#include "Time.h"
using namespace std;

int main()
{
    Time t;
    
    int &hourRef = t.badSetHour(20);

    cout << "Valid hour before modification: " << hourRef;
    hourRef = 30; // use hourRef to set invalid value in Time object t
    cout << "\nInvalid hour after modification: " << t.getHour();

    // Dangerous: Function call that returns
    // a reference can be used as an lvalue!
    t.badSetHour(12) = 74; // assign another invalid value to hour

    cout << "\n\n***********************************************\n"
        << "POOR PROGRAMMING PRACTICE!!!!!!!!\n"
        << "t.badSetHour(12) as an lvalue, invalid hour: "
        << t.getHour() 
        << "\n***********************************************" << endl;
}