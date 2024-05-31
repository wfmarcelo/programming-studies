// Fig. 11.5: UsingExceptions.java
// try...catch...finally exception handling mechanism.
package ch11.fig11_5;

/**
 * UsingExceptions
 */
public class UsingExceptions {

    public static void main(String[] args) {
        try {
            throwException();
        } catch (Exception exception) {
            System.err.println("Exception handled in main");
        }

        doesNotThrowException();
    }

    private static void doesNotThrowException() {
        try {
            System.out.println("Method doesNotThrowException");
        } catch (Exception exception) {
            System.err.println(exception);
        } finally {
            System.err.println(
                "Finally executed in doesNotThrowException");
        }

        System.out.println("End of method doesNotThrowException");
    }

    private static void throwException() throws Exception {
        try {
            System.out.println("Method throwException");
            throw new Exception();
        } catch (Exception exception) {
            System.err.println(
                "Exception handled in method throwException");
            throw exception;
        } finally {
            System.err.println("Finally executed in throwException");
        }
    }
}