package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    final static String PATH_FILE = "d:\\words.txt";
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_FILE))) {
            String line;
            Map<String, Integer> map = new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split(",\s+")) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }

            }
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
            sortedList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}