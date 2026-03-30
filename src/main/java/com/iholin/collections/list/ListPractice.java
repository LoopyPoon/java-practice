package com.iholin.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPractice {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("Ноутбук");
        products.add("Телефон");
        products.add("Наушники");
        products.add("Телефон");
        products.add("Монитор");

        products.forEach(System.out::println);

        System.out.println(products.get(2));

        System.out.println(products.size());

        System.out.println(products.contains("Наушники"));

        System.out.println(products.indexOf("Телефон"));

        System.out.println(products.lastIndexOf("Телефон"));

        System.out.println(products.remove(0));

        System.out.println(products.remove("Монитор"));

        products.add(1, "Клавиатура");

        System.out.println(products.set(0, "Планшет"));

        System.out.println(products.subList(1,3));

        Collections.sort(products);

        products.forEach(System.out::println);

        Collections.reverse(products);

        products.forEach(System.out::println);

        products.clear();

        products.forEach(System.out::println);

        System.out.println(products.isEmpty());

        products.stream().sorted().forEach(System.out::println);

    }
}
