// Fig. 17.11: CreateAndDestroy.h
// CreateAndDestroy class definition.
// Member functions defined in CreateAndDestroy.cpp
#include <string>
using namespace std;

#ifndef CREATEANDDESTROY_H
#define CREATEANDDESTROY_H

class CreateAndDestroy
{
public:
    CreateAndDestroy(int, string);
    ~CreateAndDestroy();
    void printMessage(string);
private:
    int objectID;
    string message;
};
#endif