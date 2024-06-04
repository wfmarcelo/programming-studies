// Fig. 14.24: RegexMatches.java
// Classes Pattern and Matcher.
package ch14.fig14_24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public static void main(String[] args) {
        Pattern expression =
            Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");

        String string1 = "Jane's Brithday is 05-12-75\n" +
            "Dave's Birthday is 11-04-68\n" +
            "John's Birthday is 04-28-73\n" +
            "Joe's Birthday is 12-17-77";

        
        Matcher matcher = expression.matcher(string1);

        while(matcher.find())
            System.out.println(matcher.group());
    }
}
