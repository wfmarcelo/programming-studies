// Demonstyrating the class member access operators . and ->
#include <iostream>
#include "Count.h"

using namespace std;

int main()
{
    Count counter;
    Count *counterPtr = &counter;
    Count &countRef = counter;

    cout << "Set x to 1 and print using the object's name: ";
    counter.setX(1);
    counter.print();

    cout << "Set x to 2 and print using a reference to an object: ";
    countRef.setX(2);
    countRef.print();

    cout << "Set x to 3 and print using a pointer to an object: ";
    counterPtr->setX(3);
    counterPtr->print();
}