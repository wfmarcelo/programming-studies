// Fig. 7.4: InitArray.java
// Calculating the values to be placed into the elements of an array.
package ch07.examples.InitArrayV3;

/**
 * InitArray
 */
public class InitArray {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 10;
        int[] array = new int[ARRAY_LENGTH];

        for (int counter = 0; counter < array.length; counter++)
            array[counter] = 2 + 2 * counter;

        System.out.printf("%s%8s%n", "Index", "Value");
        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
    
}