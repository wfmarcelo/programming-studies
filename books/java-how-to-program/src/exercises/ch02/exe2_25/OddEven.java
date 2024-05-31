package ch02.exe2_25;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            
            System.out.print("Input an integer: ");
            int number = input.nextInt();

            if (number % 2 == 0)
                System.out.printf("%d is even%n", number);
                
            if (number % 2 != 0)
                System.out.printf("%d is odd%n", number);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
