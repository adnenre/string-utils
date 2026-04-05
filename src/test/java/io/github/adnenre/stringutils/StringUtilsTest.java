package io.github.adnenre.stringutils;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    // ==================== 1. Null / Empty / Blank ====================
    @Test
    public void testIsEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("a"));
        assertFalse(StringUtils.isEmpty(" abc "));
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(null));
        assertFalse(StringUtils.isNotEmpty(""));
        assertTrue(StringUtils.isNotEmpty(" "));
        assertTrue(StringUtils.isNotEmpty("a"));
        assertTrue(StringUtils.isNotEmpty(" abc "));
    }

    @Test
    public void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank("   "));
        assertTrue(StringUtils.isBlank("\t\n\r"));
        assertFalse(StringUtils.isBlank(" a "));
        assertFalse(StringUtils.isBlank("hello"));
        assertFalse(StringUtils.isBlank("  x  "));
    }

    @Test
    public void testIsNotBlank() {
        assertFalse(StringUtils.isNotBlank(null));
        assertFalse(StringUtils.isNotBlank(""));
        assertFalse(StringUtils.isNotBlank("   "));
        assertTrue(StringUtils.isNotBlank(" a "));
        assertTrue(StringUtils.isNotBlank("hello"));
    }

    @Test
    public void testDefaultIfNull() {
        assertEquals("default", StringUtils.defaultIfNull(null, "default"));
        assertEquals("hello", StringUtils.defaultIfNull("hello", "default"));
        assertEquals("", StringUtils.defaultIfNull("", "default"));
        assertEquals(" ", StringUtils.defaultIfNull(" ", "default"));
    }

    @Test
    public void testDefaultIfEmpty() {
        assertEquals("default", StringUtils.defaultIfEmpty(null, "default"));
        assertEquals("default", StringUtils.defaultIfEmpty("", "default"));
        assertEquals("hello", StringUtils.defaultIfEmpty("hello", "default"));
        assertEquals(" ", StringUtils.defaultIfEmpty(" ", "default"));
    }

    @Test
    public void testDefaultIfBlank() {
        assertEquals("default", StringUtils.defaultIfBlank(null, "default"));
        assertEquals("default", StringUtils.defaultIfBlank("", "default"));
        assertEquals("default", StringUtils.defaultIfBlank("   ", "default"));
        assertEquals("hello", StringUtils.defaultIfBlank("hello", "default"));
        assertEquals(" hello ", StringUtils.defaultIfBlank(" hello ", "default"));
    }

    // ==================== 2. Trimming & Whitespace ====================
    @Test
    public void testTrim() {
        assertNull(StringUtils.trim(null));
        assertEquals("", StringUtils.trim(""));
        assertEquals("", StringUtils.trim("   "));
        assertEquals("abc", StringUtils.trim(" abc "));
        assertEquals("abc", StringUtils.trim("abc"));
        assertEquals("a b c", StringUtils.trim(" a b c "));
    }

    @Test
    public void testTrimToNull() {
        assertNull(StringUtils.trimToNull(null));
        assertNull(StringUtils.trimToNull(""));
        assertNull(StringUtils.trimToNull("   "));
        assertEquals("abc", StringUtils.trimToNull(" abc "));
        assertEquals("a b c", StringUtils.trimToNull(" a b c "));
        assertNull(StringUtils.trimToNull(" \t\n\r "));
    }

    @Test
    public void testTrimToEmpty() {
        assertEquals("", StringUtils.trimToEmpty(null));
        assertEquals("", StringUtils.trimToEmpty(""));
        assertEquals("", StringUtils.trimToEmpty("   "));
        assertEquals("abc", StringUtils.trimToEmpty(" abc "));
        assertEquals("a b c", StringUtils.trimToEmpty(" a b c "));
    }

    @Test
    public void testRemoveWhitespace() {
        assertNull(StringUtils.removeWhitespace(null));
        assertEquals("", StringUtils.removeWhitespace(""));
        assertEquals("", StringUtils.removeWhitespace("   "));
        assertEquals("abc", StringUtils.removeWhitespace(" a b c "));
        assertEquals("abc", StringUtils.removeWhitespace("a\tb\nc\r"));
        assertEquals("HelloWorld", StringUtils.removeWhitespace("Hello World"));
    }

    // ==================== 3. Case Conversion ====================
    @Test
    public void testToLowerCase() {
        assertNull(StringUtils.toLowerCase(null));
        assertEquals("", StringUtils.toLowerCase(""));
        assertEquals("hello", StringUtils.toLowerCase("HELLO"));
        assertEquals("hello world", StringUtils.toLowerCase("Hello World"));
        assertEquals("123", StringUtils.toLowerCase("123"));
    }

    @Test
    public void testToUpperCase() {
        assertNull(StringUtils.toUpperCase(null));
        assertEquals("", StringUtils.toUpperCase(""));
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("HELLO WORLD", StringUtils.toUpperCase("Hello World"));
    }

    @Test
    public void testCapitalize() {
        assertNull(StringUtils.capitalize(null));
        assertEquals("", StringUtils.capitalize(""));
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("Hello", StringUtils.capitalize("HELLO"));
        assertEquals("Hello world", StringUtils.capitalize("hello world"));
        assertEquals("A", StringUtils.capitalize("a"));
        assertEquals("Abc", StringUtils.capitalize("abc"));
        assertEquals(" hello", StringUtils.capitalize(" hello"));
    }

    @Test
    public void testUncapitalize() {
        assertNull(StringUtils.uncapitalize(null));
        assertEquals("", StringUtils.uncapitalize(""));
        assertEquals("hello", StringUtils.uncapitalize("Hello"));
        assertEquals("hELLO", StringUtils.uncapitalize("HELLO"));
        assertEquals("hello WORLD", StringUtils.uncapitalize("Hello WORLD"));
        assertEquals("a", StringUtils.uncapitalize("A"));
    }

    @Test
    public void testSwapCase() {
        assertNull(StringUtils.swapCase(null));
        assertEquals("", StringUtils.swapCase(""));
        assertEquals("hELLO", StringUtils.swapCase("Hello"));
        assertEquals("HELLO world", StringUtils.swapCase("hello WORLD"));
        assertEquals("123", StringUtils.swapCase("123"));
        assertEquals("aBc", StringUtils.swapCase("AbC"));
    }

    // ==================== 4. Substring Extraction ====================
    @Test
    public void testSubstringAfter() {
        assertNull(StringUtils.substringAfter(null, "a"));
        assertNull(StringUtils.substringAfter("abc", null));
        assertEquals("", StringUtils.substringAfter("abc", "d"));
        assertEquals("bc", StringUtils.substringAfter("abc", "a"));
        assertEquals("c", StringUtils.substringAfter("abc", "ab"));
        assertEquals("", StringUtils.substringAfter("abc", "abc"));
        assertEquals("aa", StringUtils.substringAfter("aaa", "a"));
    }

    @Test
    public void testSubstringBefore() {
        assertNull(StringUtils.substringBefore(null, "a"));
        assertNull(StringUtils.substringBefore("abc", null));
        assertEquals("abc", StringUtils.substringBefore("abc", "d"));
        assertEquals("", StringUtils.substringBefore("abc", "a"));
        assertEquals("a", StringUtils.substringBefore("abc", "b"));
        assertEquals("ab", StringUtils.substringBefore("abc", "c"));
        assertEquals("", StringUtils.substringBefore("abc", "abc"));
    }

    @Test
    public void testSubstringAfterLast() {
        assertNull(StringUtils.substringAfterLast(null, "a"));
        assertNull(StringUtils.substringAfterLast("abc", null));
        assertEquals("", StringUtils.substringAfterLast("abc", "d"));
        assertEquals("bc", StringUtils.substringAfterLast("abcabc", "a"));
        assertEquals("c", StringUtils.substringAfterLast("abcabc", "b"));
        assertEquals("", StringUtils.substringAfterLast("abc", "c"));
    }

    @Test
    public void testSubstringBeforeLast() {
        assertNull(StringUtils.substringBeforeLast(null, "a"));
        assertNull(StringUtils.substringBeforeLast("abc", null));
        assertEquals("abc", StringUtils.substringBeforeLast("abc", "d"));
        assertEquals("abcab", StringUtils.substringBeforeLast("abcabc", "c"));
        assertEquals("abca", StringUtils.substringBeforeLast("abcabc", "bc"));
        assertEquals("", StringUtils.substringBeforeLast("abc", "a"));
    }

    @Test
    public void testSubstringBetween() {
        assertNull(StringUtils.substringBetween(null, "a", "b"));
        assertNull(StringUtils.substringBetween("abc", null, "b"));
        assertNull(StringUtils.substringBetween("abc", "a", null));
        assertEquals("b", StringUtils.substringBetween("abc", "a", "c"));
        assertEquals("ba", StringUtils.substringBetween("abac", "a", "c"));
        assertNull(StringUtils.substringBetween("abc", "x", "y"));
        assertEquals("bcd", StringUtils.substringBetween("abcd ef", "a", " ef"));
    }

    // ==================== 5. String Checks ====================
    @Test
    public void testContains() {
        assertFalse(StringUtils.contains(null, "a"));
        assertFalse(StringUtils.contains("abc", null));
        assertTrue(StringUtils.contains("abc", "a"));
        assertTrue(StringUtils.contains("abc", "ab"));
        assertTrue(StringUtils.contains("abc", ""));
        assertFalse(StringUtils.contains("abc", "d"));
    }

    @Test
    public void testContainsIgnoreCase() {
        assertFalse(StringUtils.containsIgnoreCase(null, "a"));
        assertFalse(StringUtils.containsIgnoreCase("abc", null));
        assertTrue(StringUtils.containsIgnoreCase("abc", "A"));
        assertTrue(StringUtils.containsIgnoreCase("abc", "AB"));
        assertTrue(StringUtils.containsIgnoreCase("abc", ""));
        assertFalse(StringUtils.containsIgnoreCase("abc", "D"));
    }

    @Test
    public void testStartsWith() {
        assertFalse(StringUtils.startsWith(null, "a"));
        assertFalse(StringUtils.startsWith("abc", null));
        assertTrue(StringUtils.startsWith("abc", "a"));
        assertTrue(StringUtils.startsWith("abc", "ab"));
        assertTrue(StringUtils.startsWith("abc", ""));
        assertFalse(StringUtils.startsWith("abc", "b"));
    }

    @Test
    public void testEndsWith() {
        assertFalse(StringUtils.endsWith(null, "c"));
        assertFalse(StringUtils.endsWith("abc", null));
        assertTrue(StringUtils.endsWith("abc", "c"));
        assertTrue(StringUtils.endsWith("abc", "bc"));
        assertTrue(StringUtils.endsWith("abc", ""));
        assertFalse(StringUtils.endsWith("abc", "b"));
    }

    @Test
    public void testEquals() {
        assertTrue(StringUtils.equals(null, null));
        assertFalse(StringUtils.equals(null, "abc"));
        assertFalse(StringUtils.equals("abc", null));
        assertTrue(StringUtils.equals("abc", "abc"));
        assertFalse(StringUtils.equals("abc", "ABC"));
        assertTrue(StringUtils.equals("", ""));
    }

    @Test
    public void testEqualsIgnoreCase() {
        assertTrue(StringUtils.equalsIgnoreCase(null, null));
        assertFalse(StringUtils.equalsIgnoreCase(null, "abc"));
        assertFalse(StringUtils.equalsIgnoreCase("abc", null));
        assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
        assertTrue(StringUtils.equalsIgnoreCase("abc", "abc"));
        assertFalse(StringUtils.equalsIgnoreCase("abc", "abd"));
        assertTrue(StringUtils.equalsIgnoreCase("", ""));
    }

    // ==================== 6. Removal / Replacement ====================
    @Test
    public void testRemoveStart() {
        assertNull(StringUtils.removeStart(null, "a"));
        assertEquals("abc", StringUtils.removeStart("abc", null));
        assertEquals("bc", StringUtils.removeStart("abc", "a"));
        assertEquals("abc", StringUtils.removeStart("abc", "b"));
        assertEquals("", StringUtils.removeStart("abc", "abc"));
        assertEquals("abc", StringUtils.removeStart("abc", ""));
    }

    @Test
    public void testRemoveEnd() {
        assertNull(StringUtils.removeEnd(null, "c"));
        assertEquals("abc", StringUtils.removeEnd("abc", null));
        assertEquals("ab", StringUtils.removeEnd("abc", "c"));
        assertEquals("abc", StringUtils.removeEnd("abc", "b"));
        assertEquals("", StringUtils.removeEnd("abc", "abc"));
        assertEquals("abc", StringUtils.removeEnd("abc", ""));
    }

    @Test
    public void testRemove() {
        assertNull(StringUtils.remove(null, "a"));
        assertEquals("abc", StringUtils.remove("abc", null));
        assertEquals("bc", StringUtils.remove("abc", "a"));
        assertEquals("ac", StringUtils.remove("abc", "b"));
        assertEquals("ab", StringUtils.remove("abc", "c"));
        assertEquals("", StringUtils.remove("abc", "abc"));
        assertEquals("abc", StringUtils.remove("abc", ""));
    }

    @Test
    public void testReplace() {
        assertNull(StringUtils.replace(null, "a", "b"));
        assertEquals("abc", StringUtils.replace("abc", null, "b"));
        assertEquals("abc", StringUtils.replace("abc", "a", null));
        assertEquals("bbc", StringUtils.replace("abc", "a", "b"));
        assertEquals("aba", StringUtils.replace("aca", "c", "b"));
        assertEquals("xaxbxcx", StringUtils.replace("abc", "", "x"));
    }

    @Test
    public void testReplaceAll() {
        assertNull(StringUtils.replaceAll(null, "\\d", "x"));
        assertEquals("abc", StringUtils.replaceAll("abc", null, "x"));
        assertEquals("abc", StringUtils.replaceAll("abc", "\\d", null));
        assertEquals("xxx", StringUtils.replaceAll("123", "\\d", "x"));
        assertEquals("a-b-c", StringUtils.replaceAll("a.b.c", "\\.", "-"));
        assertEquals("", StringUtils.replaceAll("abc", ".*", ""));
    }

    // ==================== 7. Padding & Repetition ====================
    @Test
    public void testRepeat() {
        assertNull(StringUtils.repeat(null, 3));
        assertEquals("", StringUtils.repeat("a", 0));
        assertEquals("", StringUtils.repeat("a", -1));
        assertEquals("aaa", StringUtils.repeat("a", 3));
        assertEquals("abab", StringUtils.repeat("ab", 2));
        assertEquals("", StringUtils.repeat("", 5));
    }

    @Test
    public void testLeftPad() {
        assertNull(StringUtils.leftPad(null, 5, ' '));
        assertEquals("abc", StringUtils.leftPad("abc", 3, ' '));
        assertEquals("  abc", StringUtils.leftPad("abc", 5, ' '));
        assertEquals("00abc", StringUtils.leftPad("abc", 5, '0'));
        assertEquals("abc", StringUtils.leftPad("abc", 2, ' '));
        assertEquals("***", StringUtils.leftPad("", 3, '*'));
    }

    @Test
    public void testRightPad() {
        assertNull(StringUtils.rightPad(null, 5, ' '));
        assertEquals("abc", StringUtils.rightPad("abc", 3, ' '));
        assertEquals("abc  ", StringUtils.rightPad("abc", 5, ' '));
        assertEquals("abc00", StringUtils.rightPad("abc", 5, '0'));
        assertEquals("abc", StringUtils.rightPad("abc", 2, ' '));
        assertEquals("***", StringUtils.rightPad("", 3, '*'));
    }

    // ==================== 8. Joining & Splitting ====================
    @Test
    public void testJoin() {
        assertNull(StringUtils.join(null, ","));
        assertEquals("", StringUtils.join(new Object[] {}, ","));
        assertEquals("a,b,c", StringUtils.join(new Object[] { "a", "b", "c" }, ","));
        assertEquals("1-2-3", StringUtils.join(new Object[] { 1, 2, 3 }, "-"));
        assertEquals("null,null", StringUtils.join(new Object[] { null, null }, ","));
        assertEquals("abc", StringUtils.join(new Object[] { "a", "b", "c" }, null));
        assertEquals("abc", StringUtils.join(new Object[] { "a", "b", "c" }, ""));
    }

    @Test
    public void testSplit() {
        assertNull(StringUtils.split(null, ","));
        assertNull(StringUtils.split("a,b,c", null));
        assertArrayEquals(new String[] { "a", "b", "c" }, StringUtils.split("a,b,c", ","));
        assertArrayEquals(new String[] { "a", "b", "c" }, StringUtils.split("a.b.c", "\\."));
        assertArrayEquals(new String[] { "abc" }, StringUtils.split("abc", ","));
        assertArrayEquals(new String[] { "", "", "" }, StringUtils.split(",,", ","));
    }

    // ==================== 9. Reverse & Rotate ====================
    @Test
    public void testReverse() {
        assertNull(StringUtils.reverse(null));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("a", StringUtils.reverse("a"));
        assertEquals("  ", StringUtils.reverse("  "));
        assertEquals("321", StringUtils.reverse("123"));
    }

    @Test
    public void testReverseWords() {
        assertNull(StringUtils.reverseWords(null));
        assertEquals("", StringUtils.reverseWords(""));
        assertEquals("world hello", StringUtils.reverseWords("hello world"));
        assertEquals("c b a", StringUtils.reverseWords("a b c"));
        assertEquals("hello", StringUtils.reverseWords("hello"));
        assertEquals("world hello", StringUtils.reverseWords("hello world  "));
    }

    // ==================== 10. Count & Index ====================
    @Test
    public void testCountOccurrences() {
        assertEquals(0, StringUtils.countOccurrences(null, "a"));
        assertEquals(0, StringUtils.countOccurrences("abc", null));
        assertEquals(0, StringUtils.countOccurrences("abc", ""));
        assertEquals(2, StringUtils.countOccurrences("ababa", "aba"));
        assertEquals(3, StringUtils.countOccurrences("aaaa", "aa"));
        assertEquals(1, StringUtils.countOccurrences("abc", "abc"));
        assertEquals(0, StringUtils.countOccurrences("abc", "d"));
    }

    @Test
    public void testCountMatches() {
        assertEquals(0, StringUtils.countMatches(null, 'a'));
        assertEquals(0, StringUtils.countMatches("", 'a'));
        assertEquals(2, StringUtils.countMatches("abca", 'a'));
        assertEquals(3, StringUtils.countMatches("aaa", 'a'));
        assertEquals(0, StringUtils.countMatches("abc", 'd'));
    }

    @Test
    public void testIndexOf() {
        assertEquals(-1, StringUtils.indexOf(null, "a", 0));
        assertEquals(-1, StringUtils.indexOf("abc", null, 0));
        assertEquals(1, StringUtils.indexOf("abc", "b", 0));
        assertEquals(2, StringUtils.indexOf("abcabc", "c", 2));
        assertEquals(-1, StringUtils.indexOf("abc", "d", 0));
        assertEquals(0, StringUtils.indexOf("abc", "a", -1));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(-1, StringUtils.lastIndexOf(null, "a"));
        assertEquals(-1, StringUtils.lastIndexOf("abc", null));
        assertEquals(5, StringUtils.lastIndexOf("abcabc", "c"));
        assertEquals(3, StringUtils.lastIndexOf("abcabc", "a"));
        assertEquals(-1, StringUtils.lastIndexOf("abc", "d"));
        assertEquals(2, StringUtils.lastIndexOf("aaa", "a"));
    }

    // ==================== 11. Abbreviation ====================
    @Test
    public void testAbbreviate() {
        assertNull(StringUtils.abbreviate(null, 10));
        assertEquals("a...", StringUtils.abbreviate("abc", 10));
        assertEquals("abcde...", StringUtils.abbreviate("abcdefghijk", 6));
        assertEquals("ab...", StringUtils.abbreviate("abcdef", 4));
        assertEquals("a...", StringUtils.abbreviate("abc", 3));
        assertEquals("a...", StringUtils.abbreviate("abcdef", 5));
        assertEquals("abc", StringUtils.abbreviate("abc", 0));
    }

    // ==================== 12. Difference ====================
    @Test
    public void testDifference() {
        assertEquals("", StringUtils.difference(null, "abc"));
        assertEquals("", StringUtils.difference("abc", null));
        assertEquals("", StringUtils.difference("abc", "abc"));
        assertEquals("xyz", StringUtils.difference("abc", "abcxyz"));
        assertEquals("cdef", StringUtils.difference("ab", "abcdef"));
        assertEquals("", StringUtils.difference("abc", "ab"));
        assertEquals("", StringUtils.difference("", ""));
    }

    // ==================== 13. Misc Utilities ====================
    @Test
    public void testGetDigits() {
        assertNull(StringUtils.getDigits(null));
        assertEquals("", StringUtils.getDigits(""));
        assertEquals("123", StringUtils.getDigits("a1b2c3"));
        assertEquals("", StringUtils.getDigits("abc"));
        assertEquals("9876543210", StringUtils.getDigits(" 98 76 54 32 10 "));
    }

    @Test
    public void testGetAlpha() {
        assertNull(StringUtils.getAlpha(null));
        assertEquals("", StringUtils.getAlpha(""));
        assertEquals("abc", StringUtils.getAlpha("a1b2c3"));
        assertEquals("", StringUtils.getAlpha("123"));
        assertEquals("HelloWorld", StringUtils.getAlpha("Hello123World!"));
    }

    @Test
    public void testIsNumeric() {
        assertFalse(StringUtils.isNumeric(null));
        assertFalse(StringUtils.isNumeric(""));
        assertTrue(StringUtils.isNumeric("123"));
        assertTrue(StringUtils.isNumeric("000"));
        assertFalse(StringUtils.isNumeric("12a"));
        assertFalse(StringUtils.isNumeric("12.3"));
        assertFalse(StringUtils.isNumeric(" "));
    }

    @Test
    public void testIsAlpha() {
        assertFalse(StringUtils.isAlpha(null));
        assertFalse(StringUtils.isAlpha(""));
        assertTrue(StringUtils.isAlpha("abc"));
        assertTrue(StringUtils.isAlpha("ABC"));
        assertFalse(StringUtils.isAlpha("123"));
        assertFalse(StringUtils.isAlpha("abc123"));
        assertFalse(StringUtils.isAlpha("a b"));
    }

    @Test
    public void testIsAlphanumeric() {
        assertFalse(StringUtils.isAlphanumeric(null));
        assertFalse(StringUtils.isAlphanumeric(""));
        assertTrue(StringUtils.isAlphanumeric("abc123"));
        assertTrue(StringUtils.isAlphanumeric("ABC"));
        assertTrue(StringUtils.isAlphanumeric("123"));
        assertFalse(StringUtils.isAlphanumeric("abc!"));
        assertFalse(StringUtils.isAlphanumeric("a b"));
    }
}