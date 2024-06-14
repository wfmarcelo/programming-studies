// Fig. 16.9: Sort3.java
// Collections method sort with a custom Comparator object.
package ch16.fig16_08_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch08.fig8_5_6.Time;

public class Sort3 {
    public static void main(String[] args) {
        List<Time> list = new ArrayList<>();

        list.add(new Time(6, 24, 34));
        list.add(new Time(18, 14, 58));
        list.add(new Time(6, 05, 34));
        list.add(new Time(12, 14, 58));
        list.add(new Time(6, 24, 22));

        System.out.printf("Unsorted array elements:%n%s%n", list);

        Collections.sort(list, new TimeComparator());

        System.out.printf("Sorted list elements:%n%s%n", list);
    }
}
