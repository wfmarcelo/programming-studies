// Class with package access instance variables
package ch08.examples.packageTest;

class PackageData {
    int number;
    String string;
    
    public PackageData() {
        number = 0;
        string = "Hello";
    }

    @Override
    public String toString() {
        return String.format("number: %d; string: %s", number, string);
    }
}