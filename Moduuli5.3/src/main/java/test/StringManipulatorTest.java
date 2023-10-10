package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    private StringManipulator stringManipulator;

    @BeforeEach
    void setUp() {
        stringManipulator = new StringManipulator();
    }

    @Test
    void testConcatenate() {
        String result = stringManipulator.concatenate("Hello, ", "world!");
        assertEquals("Hello, world!", result);
    }

    @Test
    void testFindLength() {
        int length = stringManipulator.findLength("JUnit");
        assertEquals(5, length);
    }

    @Test
    void testConvertToUpperCase() {
        String result = stringManipulator.convertToUpperCase("lowercase");
        assertEquals("LOWERCASE", result);
    }

    @Test
    void testConvertToLowerCase() {
        String result = stringManipulator.convertToLowerCase("UPPERCASE");
        assertEquals("uppercase", result);
    }

    @Test
    void testContainsSubstring() {
        boolean contains = stringManipulator.containsSubstring("Hello, world!", "world");
        assertTrue(contains);

        contains = stringManipulator.containsSubstring("Hello, world!", "universe");
        assertFalse(contains);
    }
}
