// Fig. 16.8: TimeComparator.java
// Custom Comparator class that compares two Time2 objects.
package ch16.fig16_08_09;

import java.util.Comparator;

import ch08.fig8_5_6.Time;

public class TimeComparator implements Comparator<Time> {

    @Override
    public int compare(Time time1, Time time2) {
        int hourDifference = time1.getHour() - time2.getHour();

        if (hourDifference != 0)
            return hourDifference;

        int minuteDifference = time1.getMinute() - time2.getMinute();

        if (minuteDifference != 0)
            return minuteDifference;

        int secondDifference = time1.getSecond() - time2.getSecond();
        return secondDifference;
        
    }

}
