import org.StructuralPatterns.Flyweight.CharacterPropertiesFactory;
import org.StructuralPatterns.Flyweight.DocumentCharacter;
import org.StructuralPatterns.Flyweight.Document;
import org.junit.jupiter.api.Test;

import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void testSaveAndLoadDocument() {
        String text = "Hello";
        DocumentCharacter[] characters = new DocumentCharacter[] {
                new DocumentCharacter('H', CharacterPropertiesFactory.getProperties("Arial", "Red", 12)),
                new DocumentCharacter('e', CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14)),
                new DocumentCharacter('l', CharacterPropertiesFactory.getProperties("Verdana", "Black", 16)),
                new DocumentCharacter('l', CharacterPropertiesFactory.getProperties("Arial", "Red", 12)),
                new DocumentCharacter('o', CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14))
        };

        Document document = new Document(text, characters);
        document.saveToFile("testDocument.json");

        Document loadedDocument = Document.loadFromFile("testDocument.json");
        assertNotNull(loadedDocument, "Loaded document should not be null");
        assertEquals(text, loadedDocument.getContent(), "Loaded document content should match the original content");

        new File("testDocument.json").delete();
    }
}
