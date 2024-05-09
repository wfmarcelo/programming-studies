// Fig. 6.9: Scope.java
// Scope class demonstrates field and local variable scopes.
package ch06.examples.Scope;

/**
 * Scope
 */
public class Scope {

    private static int x = 1;

    public static void main(String[] args) {
        int x = 5;

        System.out.printfn("local x in main is %d%n", x);

        useLocalVariable();
        useField();
        useLocalVariable();
        useField();

        System.out.printf("%nlocal x in main is %d%n", x);
    }

    public static void useLocalVariable() {
        int x = 25;

        System.out.printf(
            "%nlocal x on entering method useLocalVariable is %d%n", x);
        x++;
        System.out.printf(
            "local x before exiting method useLocalVariable is %d%n", x);
        
    }

    
}