package org.StructuralPatterns.Flyweight;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Document {
    private final String content;
    private final DocumentCharacter[] characters;

    public Document(String content, DocumentCharacter[] characters) {
        this.content = content;
        this.characters = characters;
    }

    public void display() {
        for (DocumentCharacter dc : characters) {
            dc.display();
        }
    }

    public void saveToFile(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(this, writer);
            System.out.println("Document saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Document loadFromFile(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Document.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getContent() {
        return content;
    }
}
