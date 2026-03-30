package com.iholin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "java is great and java is fast and java is fun";
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split(" ");

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                var n = map.get(word);
                map.replace(word, n + 1);
            }
        }

        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}