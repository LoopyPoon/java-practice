package com.iholin.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContactNioReader {
    private final Path path;

    public ContactNioReader(String filePath) {
        this.path = Path.of(filePath);
    }

    public List<Contact> readContacts() throws IOException {
        List<Contact> contacts = new ArrayList<>();

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] parts = line.split(":", 2);
            if (parts.length == 2) {
                contacts.add(new Contact(parts[0], parts[1]));
            }
        }
        return contacts;
    }
}
