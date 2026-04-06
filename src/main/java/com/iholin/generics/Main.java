package com.iholin.generics;

import com.iholin.io.Contact;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage<Contact> contacts = new Storage<>();
        contacts.add(new Contact("Ivan", "123"));
        contacts.add(new Contact("Dima", "456"));
        Contact first = contacts.get(0);
        System.out.println(first);
        Contact second = contacts.get(1);
        System.out.println(second);
        contacts.remove(0);
        List<Contact> contactList = contacts.getAll();
        contactList.forEach(System.out::println);
        contacts.printAll();

    }
}
