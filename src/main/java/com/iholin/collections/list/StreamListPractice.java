package com.iholin.collections.list;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListPractice {
    public static void main(String[] args) {
        List<String> products = List.of(
                "Ноутбук", "Телефон", "Наушники", "Клавиатура",
                "Монитор", "Мышка", "Наушники", "Телефон"
        );

        List<Integer> prices = List.of(
                50000, 30000, 3000, 2000, 20000, 1000, 3500, 35000
        );

        System.out.println(products.stream()
                .filter((s) -> s.startsWith("Н"))
                .toList());

        System.out.println(products.stream()
                .distinct()
                .toList());

        System.out.println(products.stream()
                .map(String::toUpperCase)
                .toList());

        System.out.println(products.stream()
                .anyMatch(s -> s.contentEquals("Мышка")));

        System.out.println(products.stream()
                .sorted().
                toList());

        System.out.println(products.stream()
                .filter(s -> s.length() > 6)
                .count());

        System.out.println(products.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())));

        System.out.println(prices.stream()
                .mapToInt(Integer::intValue)
                .sum());

        System.out.println(prices.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt());

        System.out.println(prices.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt());

        System.out.println(prices.stream()
                .filter(p -> p > 10000)
                .sorted(Comparator.reverseOrder())
                .toList());

        System.out.println(prices.stream()
                .allMatch(p -> p > 0));

        System.out.println(prices.stream()
                .filter(p -> p > 5000)
                .count());
    }
}
