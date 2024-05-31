// Fig. 8.4: ThisTest.java
// this used implicitly and explicitly to refer to members of an object.
package ch08.fig8_4;

public class ThisTest {
    public static void main(String[] args) {
        SimpleTime time = new SimpleTime(15, 31, 19);
        System.out.println(time.buildString());
    }
}

class SimpleTime {
    private int hour;
    private int minute;
    private int second;

    public SimpleTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String buildString() {
        return String.format("%24s: %s%n%24s: %s", 
            "this.toUniversalString()", this.toUniversalString(),
            "toUniversalString()", toUniversalString());
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", 
            this.hour, this.minute, this.second);
    }
}