// Fig. 18.4: Increment.h
// Definition of class Increment.
#ifndef INCREMENT_H
#define INCREMENT_H

class Increment
{
public:
    Increment(int c = 0, int i = 1);

    void addIncrement()
    {
        count += increment;
    }

    void print() const;
private:
    int count;
    const int increment;
};

#endif