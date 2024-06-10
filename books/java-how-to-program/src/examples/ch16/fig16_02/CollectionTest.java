// Fig. 16.2: CollectionTest.java
// Collection interface demonstrated via an ArrayList object.
package ch16.fig16_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class CollectionTest {
    public static void main(String[] args) {
        String[] colors = { "MAGENTA", "RED", "WHITE", "BLUE", "CYAN" };
        List<String> list = new ArrayList<String>();

        for (String color : colors) {
            list.add(color);
        }

        String[] removeColors = { "RED", "WHITE", "BLUE" };
        List<String> removeList = new ArrayList<String>();

        for (String color : removeColors) {
            removeList.add(color);
        }

        System.out.println("ArrayList: ");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }

        removeColors(list, removeList);

        System.out.printf("%n%nArrayList after calling removeColors:%n");

        for (String color : list) {
            System.out.printf("%s ", color);
        }
        
        System.out.println();
    }

    private static void removeColors(Collection<String> collection1, Collection<String> collection2) {
        Iterator<String> iterator = collection1.iterator();

        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) 
                iterator.remove();
        }
    }
}
