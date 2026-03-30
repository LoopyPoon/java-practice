package com.iholin.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

    public static void main(String[] args) {
        Map<Integer, String> catalog = new HashMap<>();

        catalog.put(1, "Ноутбук");
        catalog.put(2, "Телефон");
        catalog.put(3, "Наушники");
        catalog.put(4, "Клавиатура");
        catalog.put(5, "Монитор");

        System.out.println(catalog.get(3));

        System.out.println(catalog.containsKey(7));

        System.out.println(catalog.containsValue("Телефон"));

        System.out.println("Товар удален: " + catalog.remove(4));

        System.out.println(catalog.size());

        System.out.println(catalog.keySet());

        System.out.println(catalog.values());

        catalog.forEach((i, s) -> System.out.println(i + ": " + s));

        System.out.println(catalog.getOrDefault(7, "Товар не найден"));

        System.out.println(catalog.putIfAbsent(3, "Планшет"));

        Map<String, Double> prices = new HashMap<>();

        System.out.println("Цена на ноутбук: " + prices.merge("Ноутбук", 10000.0, (oldPrice, newPrice) -> oldPrice + 1000));
        System.out.println("Цена на ноутбук: " + prices.merge("Ноутбук", 10000.0, Math::max));

        System.out.println("Цена на ноутбук после изменения: " + prices.compute("Ноутбук", (k, v) -> (v == null) ? 10000.0 : v + (v * 20 / 100)));

        prices.replaceAll((k, v) -> v * 0.9);
        prices.forEach((k,v) -> System.out.println(k + ": " + v));

        System.out.println("Планшет: " + prices.computeIfAbsent("Планшет", k -> 500.0));

    }


}
