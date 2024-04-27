// Fig. 15.11: fig15_11.cpp
// Name mangling to enable type-safe linkage.

int square(int x)
{
    return x * x;
}

double square(double y)
{
    return y * y;
}

void nothing1(int a, float b, char c, int &d)
{

}

int nothing2(char a, int b, float &c, double &d)
{
    return 0;
}

int main()
{
    return 0;
}