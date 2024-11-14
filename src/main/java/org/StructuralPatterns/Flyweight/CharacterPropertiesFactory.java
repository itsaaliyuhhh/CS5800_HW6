package org.StructuralPatterns.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private static final Map<String, CharacterProperties> propertiesMap = new HashMap<>();

    public static CharacterProperties getProperties(String font, String color, int size) {
        String key = font + color + size;
        propertiesMap.putIfAbsent(key, new CharacterProperties(font, color, size));
        return propertiesMap.get(key);
    }
}