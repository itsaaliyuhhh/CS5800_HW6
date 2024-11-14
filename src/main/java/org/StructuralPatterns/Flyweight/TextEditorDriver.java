package org.StructuralPatterns.Flyweight;

public class TextEditorDriver {
    public static void main(String[] args) {
        String text = "HelloWorldCS5800";
        DocumentCharacter[] characters = new DocumentCharacter[text.length()];

        characters[0] = new DocumentCharacter('H', CharacterPropertiesFactory.getProperties("Arial", "Red", 12));
        characters[1] = new DocumentCharacter('e', CharacterPropertiesFactory.getProperties("Arial", "Red", 12));
        characters[2] = new DocumentCharacter('l', CharacterPropertiesFactory.getProperties("Arial", "Blue", 14));
        characters[3] = new DocumentCharacter('l', CharacterPropertiesFactory.getProperties("Arial", "Blue", 14));
        characters[4] = new DocumentCharacter('o', CharacterPropertiesFactory.getProperties("Arial", "Black", 16));
        characters[5] = new DocumentCharacter('W', CharacterPropertiesFactory.getProperties("Calibri", "Red", 12));
        characters[6] = new DocumentCharacter('o', CharacterPropertiesFactory.getProperties("Calibri", "Red", 12));
        characters[7] = new DocumentCharacter('r', CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14));
        characters[8] = new DocumentCharacter('l', CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14));
        characters[9] = new DocumentCharacter('D', CharacterPropertiesFactory.getProperties("Calibri", "Black", 16));
        characters[10] = new DocumentCharacter('C', CharacterPropertiesFactory.getProperties("Verdana", "Red", 12));
        characters[11] = new DocumentCharacter('S', CharacterPropertiesFactory.getProperties("Verdana", "Red", 12));
        characters[12] = new DocumentCharacter('5', CharacterPropertiesFactory.getProperties("Verdana", "Blue", 14));
        characters[13] = new DocumentCharacter('8', CharacterPropertiesFactory.getProperties("Verdana", "Blue", 14));
        characters[14] = new DocumentCharacter('0', CharacterPropertiesFactory.getProperties("Verdana", "Black", 16));
        characters[15] = new DocumentCharacter('0', CharacterPropertiesFactory.getProperties("Verdana", "Black", 16));

        Document document = new Document(text, characters);

        document.saveToFile("document.json");

        Document loadedDocument = Document.loadFromFile("document.json");
        if (loadedDocument != null) {
            System.out.println("Loaded document:");
            loadedDocument.display();
        }
    }
}
