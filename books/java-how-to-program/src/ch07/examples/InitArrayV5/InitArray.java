// Fig. 7.21: InitArray.java
// Initializing an array using command-line arguments.
package ch07.examples.InitArrayV5;

/**
 * InitArray
 */
public class InitArray {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.printf(
                "Error: Please re-enter the entire command, including%n" + 
                "an array size, initial value and increment.%n");
        } else {
            int arrayLength = Integer.parseInt(args[0]);
            int[] array = new int[arrayLength];

            int initialValue = Integer.parseInt(args[1]);
            int increment = Integer.parseInt(args[2]);

            for (int i = 0; i < array.length; i++) {
                array[i] = initialValue + increment * i;
            }

            System.out.printf("%s%8s%n", "Index", "Value");

            for (int counter = 0; counter < array.length; counter++)
                System.out.printf("%5d%8d%n", counter, array[counter]);
        }
    }
}