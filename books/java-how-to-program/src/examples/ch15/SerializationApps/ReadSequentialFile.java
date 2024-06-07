// Fig. 15.11: ReadSequentialFile.java
// Reading a file of objects sequentially with ObjectInputStream
// and displaying each record.
package ch15.SerializationApps;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadSequentialFile {
    private static ObjectInputStream input;

    public static void main(String[] args) {
        openFile();
        readRecords();
        closeFile();
    }

    private static void openFile() {
        try {
            input = new ObjectInputStream(
                Files.newInputStream(Paths.get("clients.ser")));
            
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    private static void readRecords() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
            "First Name", "Last Name", "Balance");

        try {
            while (true) {
                Account record = (Account) input.readObject();

                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                    record.account(), record.firstName(), 
                    record.lastName(), record.balance());
            }
        } catch (EOFException endOfFileException) {
            System.out.printf("%nNo more records%n");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Invalid object type. Terminating.");
        } catch (IOException ioException) {
            System.err.println("Error reading from file. Terminating");
        }
    }

    private static void closeFile() {
        try {
            if (input != null)
                input.close();
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating");
            System.exit(1);
        }
    }
}
