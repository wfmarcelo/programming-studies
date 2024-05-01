// Fig. 18.3: main.cpp
// Attempting to access a const object with non-const member functions.
#include "Time.h"

int main()
{
    Time wakeUp(6, 45, 0);
    const Time noon(12, 0, 0);

    wakeUp.setHour(18);

    // noon.setHour(12);

    wakeUp.getHour();

    noon.getMinute();
    noon.printUniversal();
    
    // noon.printStandard();
}