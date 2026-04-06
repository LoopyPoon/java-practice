package com.iholin.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ContactNioWriter {
    private final Path path;

    public ContactNioWriter(String filePath) {
        this.path = Path.of(filePath);
    }

    public void writeContact(List<Contact> contacts) throws IOException {
        List<String> lines = contacts.stream()
                .map(Contact::toCsv)
                .toList();

        Files.write(path, lines);
    }
}
