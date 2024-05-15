package ch02.exercises.exe2_24;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            
            int n1;
            int n2;
            int n3;
            int n4;
            int n5;

            System.out.print("Enter five integer separeted by spaces: ");
            n1 = input.nextInt();
            n2 = input.nextInt();
            n3 = input.nextInt();
            n4 = input.nextInt();
            n5 = input.nextInt();

            int smallest = n1;
            int largest = n1;

            if (n2 < smallest)
                smallest = n2;
            
            if (n3 < smallest)
                smallest = n3;
            
            if (n4 < smallest)
                smallest = n4;
            
            if (n5 < smallest)
                smallest = n5;
            
            if (n2 > largest)
                largest = n2;
                
            if (n3 > largest)
                largest = n3;
            
            if (n4 > largest)
                largest = n4;
            
            if (n5 > largest)
                largest = n5;


            System.out.printf("%d is the largest number in the group.%n%d is the smallest number in the group%n",
                largest, smallest);



        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}
