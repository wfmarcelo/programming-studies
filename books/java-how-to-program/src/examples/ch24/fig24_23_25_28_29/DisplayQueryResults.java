// Fig. 24.28: DisplayQueryResults.java
// Display the contents of the Authors table in the books database.
package ch24.fig24_23_25_28_29;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DisplayQueryResults extends JFrame {
    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/books";
    private static final String USERNAME = "marcelo.wollmann";
    private static final String PASSWORD = "teste maria db";

    private static final String DEFAULT_QUERY = "SELECT * FROM authors";

    private static ResultSetTableModel tableModel;

    public static void main(String[] args) {
        
        try {
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

            final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);

            JScrollPane scrollPane = new JScrollPane(queryArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            JButton submitButton = new JButton("Submit Query");

            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);

            JTable resultTable = new JTable(tableModel);

            JLabel filterLabel = new JLabel("Filter:");
            final JTextField filterText = new JTextField();
            JButton filterButton = new JButton("Apply Filter");

            Box boxSouth = Box.createHorizontalBox();

            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);

            JFrame window = new JFrame("Displaying Query Results");
            window.add(boxNorth, BorderLayout.NORTH);
            window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
            window.add(boxSouth, BorderLayout.SOUTH);

            submitButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try {
                            tableModel.setQuery(queryArea.getText());
                        } catch (SQLException sqlException) {
                            JOptionPane.showMessageDialog(null,
                                sqlException.getMessage(), "Database error", 
                                JOptionPane.ERROR_MESSAGE);

                            try {
                                tableModel.setQuery(DEFAULT_QUERY);
                                queryArea.setText(DEFAULT_QUERY);
                                
                            } catch (SQLException sqlException2) {
                                JOptionPane.showMessageDialog(null,
                                sqlException2.getMessage(), "Database error", 
                                JOptionPane.ERROR_MESSAGE);

                                tableModel.disconnectFromDatabase();

                                System.exit(1);
                            }
                        }
                    }
                }
            );

            final TableRowSorter<TableModel> sorter =
                new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);

            filterButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String text = filterText.getText();

                        if (text.length() == 0)
                            sorter.setRowFilter(null);
                        else {
                            try {
                                sorter.setRowFilter(
                                    RowFilter.regexFilter(text));
                            } catch (PatternSyntaxException pse) {
                                JOptionPane.showMessageDialog(null, 
                                    "Bad regex pattern", "Bad regex pattern",
                                    JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            );

            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            window.setSize(500, 250);
            window.setVisible(true);

            window.addWindowListener(
               new WindowAdapter() {
                    public void windowClosed(WindowEvent event) {
                        tableModel.disconnectFromDatabase();
                        System.exit(0);
                    }
                }
            );
            
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                sqlException.getMessage(), "Database error", 
                JOptionPane.ERROR_MESSAGE);
            
                tableModel.disconnectFromDatabase();
                System.exit(1);
        }

    }


    
}