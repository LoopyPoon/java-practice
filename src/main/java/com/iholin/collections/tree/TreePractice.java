package com.iholin.collections.tree;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreePractice {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>();
        nums.add(50);
        nums.add(10);
        nums.add(30);
        nums.add(20);
        nums.add(40);

        System.out.println(nums);

        TreeSet<Integer> tree = new TreeSet<>(nums);

        System.out.println(tree.first());
        System.out.println(tree.last());
        System.out.println(tree.lower(30));
        System.out.println(tree.higher(30));
        System.out.println(tree.floor(30));
        System.out.println(tree.ceiling(30));
        System.out.println(tree.headSet(30));
        System.out.println(tree.tailSet(30));
        System.out.println(tree.subSet(10,50));

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Банан", 50);
        map.put("Арбуз", 200);
        map.put("Вишня", 80);

        System.out.println(map);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.lowerKey("Банан"));
        System.out.println(map.higherKey("Банан"));
        System.out.println(map.headMap("Вишня"));
        System.out.println(map.tailMap("Банан"));


    }
}
