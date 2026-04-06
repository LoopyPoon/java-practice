package com.iholin.streams;

import com.iholin.io.Contact;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInterviewTasks {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 3, 8, 1, 9, 2, 7, 4, 6, 3, 8, 1);

        List<String> words = List.of(
                "java", "spring", "hibernate", "java",
                "stream", "lambda", "spring", "api"
        );

        List<Contact> contacts = List.of(
                new Contact("Иван", "+79001111111"),
                new Contact("Пётр", "+79002222222"),
                new Contact("Дима", "+79003333333"),
                new Contact("Иван", "+79004444444"),
                new Contact("Александр", "+79005555555"),
                new Contact("Дмитрий", "+79006666666"),
                new Contact("Пётр", "+79007777777"),
                new Contact("Анна", "+79008888888"),
                new Contact("Анна", "+79009999999")
        );

        int sumEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sumEvenNumbers);

        Optional<Integer> secondBiggestNumber = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findAny();

        secondBiggestNumber.ifPresent(System.out::println);

        List<Integer> duplicateNumbers = numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) > 1)
                .distinct()
                .toList();

        System.out.println(duplicateNumbers);

        Map<Integer, Long> groupingNumbersByCount = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        List<Integer> duplicateNumbersGroup = groupingNumbersByCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(duplicateNumbersGroup);

        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(duplicates);
    }
}
