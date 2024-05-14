// Fig. 24.29: JdbcRowSetTest.java
// Displaying the contents of the Authors table using JdbcRowSet;
package ch24.books_example;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {
    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/books";
    private static final String USERNAME = "marcelo.wollmann";
    private static final String PASSWORD = "teste maria db";

    public static void main(String[] args) {
        try (JdbcRowSet rowSet =
            RowSetProvider.newFactory().createJdbcRowSet()) {

            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT * FROM authors");
            rowSet.execute();

            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.printf("Authors Table of Books Database:%n%n");

            for (int i = 1; i <= numberOfColumns; i++) 
                System.out.printf("%-8s\t", metaData.getColumnName(i));

            System.out.println();

            while (rowSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", rowSet.getObject(i));
                System.out.println();
            }

            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
} 