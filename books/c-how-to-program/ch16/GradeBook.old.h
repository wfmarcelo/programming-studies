// Fig. 16.9: GradeBook.h
// GradeBook class definition in a separete file from main
#include <iostream>
#include <string>
using namespace std;

class GradeBook
{
private:
    string courseName;
public:
    GradeBook(string name)
    {
        setCourseName(name);
    }

    void setCourseName(string name)
    {
        courseName = name;
    }

    string getCourseName()
    {
        return courseName;
    }

    void displayMessage()
    {
        cout << "Welcome to the grade book for \n" << getCourseName()
            << "!" << endl;
    }
};


