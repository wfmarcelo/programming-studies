// Fig. 17.7: main.cpp
// Utility function demonstration.
// Compile this program with SalesPerson.cpp
// include SalesPerson class definition from SalesPerson.h
#include "SalesPerson.h"

int main()
{
    SalesPerson s;

    s.getSalesFromUser();
    s.printAnnualSales();
}