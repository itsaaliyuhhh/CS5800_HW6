import org.StructuralPatterns.Flyweight.CharacterProperties;
import org.StructuralPatterns.Flyweight.CharacterPropertiesFactory;
import org.StructuralPatterns.Flyweight.DocumentCharacter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DocumentCharacterTest {

    @Test
    void testDisplay() {
        CharacterProperties properties = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        DocumentCharacter character = new DocumentCharacter('H', properties);

        assertEquals('H', character.character, "Character should be 'H'");
        assertEquals(properties, character.properties, "CharacterProperties should match the assigned properties");
    }
}
