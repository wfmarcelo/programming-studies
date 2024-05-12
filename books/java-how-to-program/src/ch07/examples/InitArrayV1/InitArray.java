// Dig. 7.2: InitArray.java
// Initializing the elements od an array to default values of zero.
package ch07.examples.InitArrayV1;

/**
 * InitArray
 */
public class InitArray {
    public static void main(String[] args) {
        int[] array = new int[10];

        System.out.printf("%s%8s%n", "Index", "Value");

        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
    
}