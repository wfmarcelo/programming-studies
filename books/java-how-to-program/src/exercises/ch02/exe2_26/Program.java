package ch02.exe2_26;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter two integers separeted by space: ");
            int n1 = input.nextInt();
            int n2 = input.nextInt();

            if (n1 % n2 == 0) 
                System.out.printf("%d is multiple of %d%n", n1, n2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
