package com.iholin.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactFileReader {
    private final String filePath;

    public ContactFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Contact> readContacts() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String name = parts[0];
                    String phone = parts[1];
                    contacts.add(new Contact(name, phone));
                }
            }
        }
        return contacts;
    }
}
