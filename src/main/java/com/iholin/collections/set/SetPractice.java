package com.iholin.collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {
    public static void main(String[] args) {
       Set<String> tags = new HashSet<>();
       tags.add("Java");
       tags.add("Spring");
       tags.add("SQL");
       tags.add("Git");
       tags.add("Docker");
       tags.add("Java");
       tags.add("SQL");

       Set<String> moreTags = Set.of("Java", "Kotlin", "Python");

        System.out.println(tags);

        System.out.println(tags.contains("Python"));

        System.out.println(tags.remove("Git"));

        System.out.println(tags.size());

        Set<String> union = new HashSet<>(tags);

        System.out.println(union.addAll(moreTags));

        System.out.println(union);

        Set<String> intersection = new HashSet<>(tags);

        System.out.println(intersection.retainAll(moreTags));

        System.out.println(intersection);

        Set<String> difference = new HashSet<>(tags);

        System.out.println(difference.removeAll(moreTags));

        System.out.println(difference);
    }

}
