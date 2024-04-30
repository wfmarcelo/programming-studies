// Fig. 16.11: GradeBook.h
// GradeBook Class definition. This file presents GradeBook's public
// interface without revealing the implementations of GradeBook's member
// functions, which are defined in GradeBook.cpp.
#include <string>
using namespace std;

class GradeBook
{
public:
    GradeBook(string);
    void setCourseName(string);
    string getCourseName();
    void displayMessage();
private:
    string courseName;
};