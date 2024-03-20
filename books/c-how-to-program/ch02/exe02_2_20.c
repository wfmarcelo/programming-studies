// Diameter, circumference and area of a circle
#include <stdio.h>

const float PI = 3.14159;

int main(void)
{
	float radius;

	printf("%s", "Enter the radius of the circumference: ");
	scanf("%f", &radius);

	printf("The circle diameter is %f\n", radius * 2);
	printf("The circle circumference is %f\n", radius * 2 * PI);
	printf("The circle area is %f\n", radius * radius * PI);

}
