package com.iholin.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContactFileWriter {
    private final String filePath;

    public ContactFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeContacts(List<Contact> contacts) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Contact contact : contacts) {
                writer.write(contact.toCsv());
                writer.newLine();
            }
        }
    }
}
