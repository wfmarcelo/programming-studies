// Fig. 16.18: WordTypeCount.java
// Program counts the number of occurrences of each word in a String.
package ch16.fig16_18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordTypeCount {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap);
        displayMap(myMap);
    }

    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet();

        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : sortedKeys)
            System.out.printf("%-10s%10s%n", key, map.get(key));

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }

    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        String[] tokens = input.split(" ");

        for (String token : tokens) {
            String word = token.toLowerCase();

            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else
                map.put(word, 1);
        }
    }
}
