package io.github.adnenre.stringutils;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testIsEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty("hello"));
    }

    @Test
    public void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank("   "));
        assertFalse(StringUtils.isBlank("hello"));
        assertFalse(StringUtils.isBlank(" hello "));
    }

    @Test
    public void testReverse() {
        assertNull(StringUtils.reverse(null));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    public void testCapitalize() {
        assertNull(StringUtils.capitalize(null));
        assertEquals("", StringUtils.capitalize(""));
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("Hello", StringUtils.capitalize("Hello"));
        assertEquals("H", StringUtils.capitalize("h"));
    }

    @Test
    public void testCountOccurrences() {
        assertEquals(0, StringUtils.countOccurrences(null, "a"));
        assertEquals(0, StringUtils.countOccurrences("hello", null));
        assertEquals(0, StringUtils.countOccurrences("hello", ""));
        assertEquals(2, StringUtils.countOccurrences("hellohello", "hello"));
        assertEquals(3, StringUtils.countOccurrences("ababab", "ab"));
        assertEquals(0, StringUtils.countOccurrences("abc", "d"));
    }
}