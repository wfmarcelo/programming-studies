// Fig. 16.15: GradeBook.h
// GradeBook class definition presents the public interface of 
// the class. Member-function definitions appear in GradeBook.cpp.
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