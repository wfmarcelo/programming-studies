// Exe. 15.6: exe15_06.cpp
// Calculating by value and by reference.
#include <iostream>


using namespace std;

int tripleByValue(int count)
{
    return count * 3;
}

void tripleByReference(int &count)
{
    count *= 3;
}

int main()
{
    int countValue;

    cout << "Enter an integer value: ";
    cin >> countValue;

    cout << "Count value before calling tripleByValue: " 
        << countValue << endl;
    cout << "Value returned by tripleByValue :" 
        << tripleByValue(countValue) << endl;
    cout << "Count value after calling triplebyValue: "
        << countValue << endl;

    cout << "\nCount value before calling tripleByReference: "
        << countValue << endl;
    tripleByReference(countValue);
    cout << "Count value after calling tripleByReference: "
        << countValue << endl;
}