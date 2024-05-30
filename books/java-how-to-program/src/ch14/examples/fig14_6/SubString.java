// Fig. 14.6: SubString.java
// String class substring methods.
package ch14.examples.fig14_6;

public class SubString {
    public static void main(String[] args) {
        String letters = "abcdefghijklmabcdefghijklm";

        System.out.printf("Substring from index 20 to end is \"%s\"%n", 
            letters.substring(20));
        System.out.printf("%s \"%s\"%n",
            "Substring from index 3 up to, but not including 6 is", 
            letters.substring(3,6));
    }
}
