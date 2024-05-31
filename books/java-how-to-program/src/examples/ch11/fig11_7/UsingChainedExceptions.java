// Fig. 11.7: UsingChainedExceptions.java
// Chained exceptions.
package ch11.fig11_7;

public class UsingChainedExceptions {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw new Exception("Exception thrown in method1", e);
        }
    }

    private static void method2() throws Exception {
        try {
            method3();
        } catch (Exception e) {
            throw new Exception("Exception tnrown in method2", e);
        }
    }

    private static void method3() throws Exception {
        throw new Exception("Exception thrown in method3");
    }
}
