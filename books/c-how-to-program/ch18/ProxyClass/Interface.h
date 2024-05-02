// Fig. 18.22: Interface.h
// Proxy class Interface definition.
// Client sees this source code, but the source code does not reveal 
// the data layout of class Implementation.

class Implementation;

class Interface
{
public:
    Interface(int);

    void setValue(int);
    int getValue() const;
    ~Interface();
private:
    Implementation *ptr;
};