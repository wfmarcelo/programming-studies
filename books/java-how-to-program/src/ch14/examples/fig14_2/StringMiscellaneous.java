// Fig. 14.2: StringMiscellaneous.java
// This application demonstrates the length, charAt and getChars
// methods of the String class.
package ch14.examples.fig14_2;

public class StringMiscellaneous {
    public static void main(String[] args) {
        String s1 = "hello there";
        char[] charArray = new char[5];

        System.out.printf("s1: %s", s1);

        System.out.printf("%nLength of s1: %d", s1.length());

        System.out.printf("%nThe string reversed is: ");
        for (int i = s1.length() - 1; i >= 0; i--)
            System.out.printf("%c ", s1.charAt(i));

        s1.getChars(0, 5, charArray, 0);
        System.out.printf("%nThe character array is: ");

        for (char character : charArray) 
            System.out.print(character);

        System.out.println();
    }
}
