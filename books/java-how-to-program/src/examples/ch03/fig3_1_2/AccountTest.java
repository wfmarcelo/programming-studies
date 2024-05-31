package ch03.fig3_1_2;

// Fig. 3.2: AccountTest.java
// Creating and manipulating an Account object.


import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account();

        System.out.printf("Initial name is: %s%n%n", myAccount.getName());

        System.out.println("Please enter the name:");
        String theName = input.nextLine();
        myAccount.setName(theName);
        System.out.println();


        System.out.printf("Name in object myAccount is:%n%s%n",
            myAccount.getName());

        input.close();
    }
    
}
