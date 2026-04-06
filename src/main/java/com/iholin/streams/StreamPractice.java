package com.iholin.streams;

import com.iholin.io.Contact;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Contact> contacts = List.of(
                new Contact("Иван", "+79001111111"),
                new Contact("Пётр", "+79002222222"),
                new Contact("Дима", "+79003333333"),
                new Contact("Иван", "+79004444444"),
                new Contact("Александр", "+79005555555"),
                new Contact("Дмитрий", "+79006666666"),
                new Contact("Пётр", "+79007777777")
        );

        List<Contact> petrList = contacts.stream()
                .filter(name -> name.getName().equals("Пётр"))
                .toList();

        System.out.println(petrList);

        List<String> sortUniqList = contacts.stream()
                .map(Contact::getName)
                .distinct()
                .sorted()
                .toList();

        System.out.println(sortUniqList);

        Optional<Contact> biggestName = contacts.stream()
                .max(Comparator.comparing(c -> c.getName().length()));

        biggestName.ifPresent(System.out::println);

        Map<String, List<Contact>> groupingContacts = contacts.stream()
                .collect(Collectors.groupingBy(Contact::getName));

        System.out.println(groupingContacts);

        long contactsBiggestThen4 = contacts.stream()
                .map(Contact::getName)
                .filter(name -> name.length() > 4)
                .count();

        System.out.println(contactsBiggestThen4);

        String oneLineContacts = contacts.stream()
                .map(Contact::getName)
                .collect(Collectors.joining(", "));

        System.out.println(oneLineContacts);
    }
}
