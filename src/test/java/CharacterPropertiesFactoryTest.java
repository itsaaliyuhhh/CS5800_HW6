import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.StructuralPatterns.Flyweight.CharacterProperties;
import org.StructuralPatterns.Flyweight.CharacterPropertiesFactory;

class CharacterPropertiesFactoryTest {

    @Test
    void testGetPropertiesReusesInstances() {
        CharacterProperties properties1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties properties2 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);

        assertSame(properties1, properties2, "CharacterPropertiesFactory should reuse instances with the same properties");
    }

    @Test
    void testGetPropertiesCreatesNewInstances() {
        CharacterProperties properties1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties properties2 = CharacterPropertiesFactory.getProperties("Verdana", "Blue", 14);

        assertNotSame(properties1, properties2, "CharacterPropertiesFactory should create new instances for different properties");
    }
}
