package org.StructuralPatterns.Flyweight;

public class DocumentCharacter {
    public final char character;
    public final CharacterProperties properties;

    public DocumentCharacter(char character, CharacterProperties properties) {
        this.character = character;
        this.properties = properties;
    }

    public void display() {
        System.out.println("Character: " + character + ", " + properties);
    }
}