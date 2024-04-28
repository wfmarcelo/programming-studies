// Exe. 15.5: exe15_05.cpp
// Calculating the area of a circle
#include <iostream>

using namespace std;

const double PI = 3.14159;

inline double circleArea(const double radius)
{
    return PI * radius * radius;
}

int main()
{
    double radiusValue;
    
    cout << "Enter the length of the radius of your circle: ";
    cin >> radiusValue;

    cout << "Area of circle with radius " <<  radiusValue 
        << " is " << circleArea(radiusValue) << endl;
}