// Fig. 7.24: ArrayListCollection.java
// Generic ArrayList<T> collection demonstration.
package ch07.fig7_24;

import java.util.ArrayList;

public class ArrayListCollection {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<String>();

        items.add("red");
        items.add(0, "yellow");

        System.out.print(
            "Display list contents with counter-controlled loop:");

        for (int index = 0; index < items.size(); index++) {
            System.out.printf(" %s", items.get(index));
        }

        display(items,
            "%nDisplay list contents with enhanced for statement:");

        items.add("green");
        items.add("yellow");
        display(items, "List with two new elements:");

        items.remove("yellow");
        display(items, "Remove first instance of yellow:");

        items.remove(1);
        display(items, "Remove second list element (green)");

        System.out.printf("\"red\" is %sin the list%n",
            items.contains("red") ? "": "not");

        System.out.printf("Size: %s%n", items.size());
    }

    private static void display(ArrayList<String> items, String header) {
        System.out.printf(header);

        for (String item : items) 
            System.out.printf(" %s", item);

        System.out.println();
    }
}
