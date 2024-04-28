// Exe. 15.8: minimum.h
// Function template minimum header file.

template <class T>
T minimum(T value1, T value2)
{
    T minimumValue = value1;

    if (value2 < minimumValue)
    {
        minimumValue = value2;
    }
    
    return minimumValue;
}