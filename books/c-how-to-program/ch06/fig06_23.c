// Fig. 6.23: fig06_23.c
// Using variable-length arrays in C99
#include <stdio.h>

void print1DArray(int size, int arr[size]);
void print2DArray(int row, int col, int arr[row][col]);

int main(void)
{
  int arraySize;
  int row1, col1, row2, col2;

  printf("%s", "Enter size of a one-dimensional array: ");
  scanf("%d", &arraySize);

  printf("%s", "Enter number of rows and columns in a 2-d array: ");
  scanf("%d %d", &row1, &col1);
  
  printf("%s", "Enter number of rows and columns in a 2-d array: ");
  scanf("%d %d", &row2, &col2);

  int array[arraySize];
  int array2D1[row1][col1];
  int array2D2[row2][col2];

  printf("\nsizeof(array) yields array size of %lu bytes\n",
      sizeof(array));

  for (int i =0; i < arraySize; i++)
  {
    array[i] = i * i;
  }

  for (int i = 0; i < row1; i++)
  {
    for (int j = 0; j < col1; j++)
    {
      array2D1[i][j] = i + j;
    }
  }
  
  for (int i = 0; i < row2; i++)
  {
    for (int j = 0; j < col2; j++)
    {
      array2D2[i][j] = i + j;
    }
  }

  puts("\nOne-dimensional array:");
  print1DArray(arraySize, array);

  puts("\nFirst two-dimensional array:");
  print2DArray(row1, col1, array2D1);

  puts("\nSecond two-dimensional array:");
  print2DArray(row2, col2, array2D2);
}

void print1DArray(int size, int array[size])
{
  for (int i = 0; i < size; i++)
  {
    printf("array[%d] = %d\n", i, array[i]);
  }
}

void print2DArray(int row, int col, int arr[row][col])
{
  for (int i = 0; i < row; i++)
  {
    for (int j = 0; j < col; j++)
    {
      printf("%5d", arr[i][j]);
    }
    
    puts("");
  }
}
