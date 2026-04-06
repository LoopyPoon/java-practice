package com.iholin.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "contacts.txt";
        String nioFilePath = "nio_contacts.txt";

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Иван", "+79995704724"));
        contacts.add(new Contact("Виктор", "+79005704725"));

        ContactFileWriter writer = new ContactFileWriter(filePath);
        try {
            writer.writeContacts(contacts);
            System.out.println("Контакты записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactFileReader reader = new ContactFileReader(filePath);
        List<Contact> loadContacts = new ArrayList<>();
        try {
            loadContacts = reader.readContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Contact contact : loadContacts) {
            System.out.println(contact.getName() + " : " + contact.getPhoneNumber());
        }

        ContactFileWriter nioWriter = new ContactFileWriter(nioFilePath);
        try {
            nioWriter.writeContacts(contacts);
            System.out.println("Контакты nio записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactNioReader nioReader = new ContactNioReader(nioFilePath);
        List<Contact> nioLoader = new ArrayList<>();
        try {
            nioLoader = nioReader.readContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Contact contact : nioLoader) {
            System.out.println(contact.getName() + " : " + contact.getPhoneNumber());
        }
    }
}
