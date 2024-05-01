// Fig. 17.12: CreateAndDestroy.cpp
// CreateAndDestroy class member-function definitions.
#include <iostream>
#include "CreateAndDestroy.h"
using namespace std;

CreateAndDestroy::CreateAndDestroy(int ID, string messageString)
{
    objectID = ID;
    message = messageString;

    printMessage("constructor");
}

CreateAndDestroy::~CreateAndDestroy()
{
    cout << (objectID == 1 || objectID == 6 ? "\n" : "");

    printMessage("destructor");
}

void CreateAndDestroy::printMessage(string operation)
{
    cout << "Object " << objectID << "   " << operation << " runs   "
        << message << endl;
}