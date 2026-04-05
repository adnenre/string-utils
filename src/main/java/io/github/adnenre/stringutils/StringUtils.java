package io.github.adnenre.stringutils;

/**
 * A comprehensive utility class for common string operations.
 * <p>
 * All methods are null‑safe where applicable – passing {@code null} to any
 * method
 * will not throw a {@link NullPointerException}; instead it will return a
 * sensible
 * default (e.g. {@code false}, {@code 0}, or {@code null}) as described in each
 * method's documentation.
 * </p>
 * <p>
 * This class is {@code final} and has a private constructor, so it cannot be
 * instantiated or extended.
 * </p>
 * 
 * @author Adnen Rebaï
 * @version 1.0.1
 * @since 1.0.0
 */
public final class StringUtils {

    private StringUtils() {
        // Prevent instantiation
    }

    // ==================== 1. Null / Empty / Blank Checks ====================

    /**
     * Checks if a string is {@code null} or empty (length 0).
     * <p>
     * Examples:
     * 
     * <pre>
     * isEmpty(null)   → true
     * isEmpty("")     → true
     * isEmpty(" ")    → false
     * isEmpty("abc")  → false
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if {@code null} or empty, otherwise {@code false}
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Checks if a string is not {@code null} and not empty.
     * <p>
     * Examples:
     * 
     * <pre>
     * isNotEmpty(null)   → false
     * isNotEmpty("")     → false
     * isNotEmpty(" ")    → true
     * isNotEmpty("abc")  → true
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if not {@code null} and not empty, otherwise
     *         {@code false}
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Checks if a string is {@code null}, empty, or contains only whitespace.
     * Whitespace is defined by {@link Character#isWhitespace(char)}.
     * <p>
     * Examples:
     * 
     * <pre>
     * isBlank(null)    → true
     * isBlank("")      → true
     * isBlank("   ")   → true
     * isBlank(" abc ") → false
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if blank, otherwise {@code false}
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Checks if a string is not {@code null}, not empty, and contains at least one
     * non‑whitespace character.
     * <p>
     * Examples:
     * 
     * <pre>
     * isNotBlank(null)    → false
     * isNotBlank("")      → false
     * isNotBlank("   ")   → false
     * isNotBlank(" abc ") → true
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if not blank, otherwise {@code false}
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * Returns a default value if the input string is {@code null}.
     * <p>
     * Examples:
     * 
     * <pre>
     * defaultIfNull(null, "default") → "default"
     * defaultIfNull("hello", "def")  → "hello"
     * </pre>
     * 
     * @param str        the string to test
     * @param defaultStr the default value (may be {@code null})
     * @return {@code str} if not {@code null}, otherwise {@code defaultStr}
     */
    public static String defaultIfNull(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }

    /**
     * Returns a default value if the input string is {@code null} or empty.
     * <p>
     * Examples:
     * 
     * <pre>
     * defaultIfEmpty(null, "default") → "default"
     * defaultIfEmpty("", "default")   → "default"
     * defaultIfEmpty("abc", "def")    → "abc"
     * </pre>
     * 
     * @param str        the string to test
     * @param defaultStr the default value (may be {@code null})
     * @return {@code str} if not empty, otherwise {@code defaultStr}
     */
    public static String defaultIfEmpty(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    /**
     * Returns a default value if the input string is blank (null, empty, or
     * whitespace).
     * <p>
     * Examples:
     * 
     * <pre>
     * defaultIfBlank(null, "default") → "default"
     * defaultIfBlank("", "default")   → "default"
     * defaultIfBlank("   ", "def")    → "def"
     * defaultIfBlank("abc", "def")    → "abc"
     * </pre>
     * 
     * @param str        the string to test
     * @param defaultStr the default value (may be {@code null})
     * @return {@code str} if not blank, otherwise {@code defaultStr}
     */
    public static String defaultIfBlank(String str, String defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

    // ==================== 2. Trimming & Whitespace ====================

    /**
     * Removes leading and trailing whitespace.
     * <p>
     * Examples:
     * 
     * <pre>
     * trim(null)          → null
     * trim("")            → ""
     * trim("   abc  ")    → "abc"
     * </pre>
     * 
     * @param str the string to trim
     * @return the trimmed string, or {@code null} if input is {@code null}
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * Trims the string and returns {@code null} if the result is empty.
     * <p>
     * Examples:
     * 
     * <pre>
     * trimToNull(null)       → null
     * trimToNull("")         → null
     * trimToNull("   ")      → null
     * trimToNull(" abc ")    → "abc"
     * </pre>
     * 
     * @param str the string to trim
     * @return the trimmed string, or {@code null} if the trimmed result is empty or
     *         input is {@code null}
     */
    public static String trimToNull(String str) {
        String trimmed = trim(str);
        return trimmed == null || trimmed.isEmpty() ? null : trimmed;
    }

    /**
     * Trims the string and returns an empty string if input is {@code null}.
     * <p>
     * Examples:
     * 
     * <pre>
     * trimToEmpty(null)    → ""
     * trimToEmpty("")      → ""
     * trimToEmpty("   ")   → ""
     * trimToEmpty(" abc ") → "abc"
     * </pre>
     * 
     * @param str the string to trim
     * @return the trimmed string, or an empty string if input is {@code null}
     */
    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * Removes all whitespace characters from the string. Whitespace includes
     * spaces,
     * tabs, newlines, etc.
     * <p>
     * Examples:
     * 
     * <pre>
     * removeWhitespace(null)      → null
     * removeWhitespace("a b c")   → "abc"
     * removeWhitespace("a\tb\nc") → "abc"
     * </pre>
     * 
     * @param str the string to process
     * @return a string with all whitespace removed, or {@code null} if input is
     *         {@code null}
     */
    public static String removeWhitespace(String str) {
        if (str == null)
            return null;
        return str.replaceAll("\\s+", "");
    }

    // ==================== 3. Case Conversion ====================

    /**
     * Converts the string to lower case using the default locale.
     * <p>
     * Examples:
     * 
     * <pre>
     * toLowerCase(null)    → null
     * toLowerCase("HELLO") → "hello"
     * </pre>
     * 
     * @param str the string to convert
     * @return the lower‑cased string, or {@code null} if input is {@code null}
     */
    public static String toLowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }

    /**
     * Converts the string to upper case using the default locale.
     * <p>
     * Examples:
     * 
     * <pre>
     * toUpperCase(null)    → null
     * toUpperCase("hello") → "HELLO"
     * </pre>
     * 
     * @param str the string to convert
     * @return the upper‑cased string, or {@code null} if input is {@code null}
     */
    public static String toUpperCase(String str) {
        return str == null ? null : str.toUpperCase();
    }

    /**
     * Capitalizes the first letter of the string and lowercases the rest.
     * <p>
     * Examples:
     * 
     * <pre>
     * capitalize(null)      → null
     * capitalize("")        → ""
     * capitalize("hello")   → "Hello"
     * capitalize("HELLO")   → "Hello"
     * </pre>
     * 
     * @param str the string to capitalize
     * @return the capitalized string, or {@code null} if input is {@code null}
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty())
            return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }

    /**
     * Uncapitalizes the first letter of the string (makes it lower case).
     * <p>
     * Examples:
     * 
     * <pre>
     * uncapitalize(null)    → null
     * uncapitalize("Hello") → "hello"
     * </pre>
     * 
     * @param str the string to uncapitalize
     * @return the uncapitalized string, or {@code null} if input is {@code null}
     */
    public static String uncapitalize(String str) {
        if (str == null || str.isEmpty())
            return str;
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * Swaps the case of each character: upper becomes lower, lower becomes upper.
     * <p>
     * Examples:
     * 
     * <pre>
     * swapCase(null)        → null
     * swapCase("Hello")     → "hELLO"
     * swapCase("hello WORLD") → "HELLO world"
     * </pre>
     * 
     * @param str the string to transform
     * @return the case‑swapped string, or {@code null} if input is {@code null}
     */
    public static String swapCase(String str) {
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else
                sb.append(c);
        }
        return sb.toString();
    }

    // ==================== 4. Substring Extraction ====================

    /**
     * Gets the substring after the first occurrence of a separator.
     * <p>
     * Examples:
     * 
     * <pre>
     * substringAfter(null, "a")    → null
     * substringAfter("abc", null)  → null
     * substringAfter("abc", "d")   → ""
     * substringAfter("abc", "a")   → "bc"
     * substringAfter("aaa", "a")   → "aa"
     * </pre>
     * 
     * @param str       the source string
     * @param separator the separator to search for
     * @return the substring after the first separator, or {@code ""} if not found,
     *         or {@code null} if either argument is {@code null}
     */
    public static String substringAfter(String str, String separator) {
        if (str == null || separator == null)
            return null;
        int pos = str.indexOf(separator);
        return pos == -1 ? "" : str.substring(pos + separator.length());
    }

    /**
     * Gets the substring before the first occurrence of a separator.
     * <p>
     * Examples:
     * 
     * <pre>
     * substringBefore(null, "a")   → null
     * substringBefore("abc", null) → null
     * substringBefore("abc", "d")  → "abc"
     * substringBefore("abc", "a")  → ""
     * </pre>
     * 
     * @param str       the source string
     * @param separator the separator to search for
     * @return the substring before the first separator, or the original string if
     *         not found,
     *         or {@code null} if either argument is {@code null}
     */
    public static String substringBefore(String str, String separator) {
        if (str == null || separator == null)
            return null;
        int pos = str.indexOf(separator);
        return pos == -1 ? str : str.substring(0, pos);
    }

    /**
     * Gets the substring after the last occurrence of a separator.
     * <p>
     * Examples:
     * 
     * <pre>
     * substringAfterLast(null, "a")  → null
     * substringAfterLast("abc", null)→ null
     * substringAfterLast("abc", "d") → ""
     * substringAfterLast("abcabc", "a") → "bc"
     * </pre>
     * 
     * @param str       the source string
     * @param separator the separator to search for
     * @return the substring after the last separator, or {@code ""} if not found,
     *         or {@code null} if either argument is {@code null}
     */
    public static String substringAfterLast(String str, String separator) {
        if (str == null || separator == null)
            return null;
        int pos = str.lastIndexOf(separator);
        return pos == -1 ? "" : str.substring(pos + separator.length());
    }

    /**
     * Gets the substring before the last occurrence of a separator.
     * <p>
     * Examples:
     * 
     * <pre>
     * substringBeforeLast(null, "a") → null
     * substringBeforeLast("abc", null)→ null
     * substringBeforeLast("abc", "d") → "abc"
     * substringBeforeLast("abcabc", "c") → "abcab"
     * </pre>
     * 
     * @param str       the source string
     * @param separator the separator to search for
     * @return the substring before the last separator, or the original string if
     *         not found,
     *         or {@code null} if either argument is {@code null}
     */
    public static String substringBeforeLast(String str, String separator) {
        if (str == null || separator == null)
            return null;
        int pos = str.lastIndexOf(separator);
        return pos == -1 ? str : str.substring(0, pos);
    }

    /**
     * Gets the substring between two delimiters (first occurrence of the opening
     * delimiter and first occurrence of the closing delimiter after that).
     * <p>
     * Examples:
     * 
     * <pre>
     * substringBetween(null, "a", "b") → null
     * substringBetween("abc", "a", "c") → "b"
     * substringBetween("abac", "a", "c") → "ba"
     * </pre>
     * 
     * @param str   the source string
     * @param open  the opening delimiter
     * @param close the closing delimiter
     * @return the substring between the delimiters, or {@code null} if not found
     *         or if any argument is {@code null}
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null)
            return null;
        int start = str.indexOf(open);
        if (start == -1)
            return null;
        start += open.length();
        int end = str.indexOf(close, start);
        return end == -1 ? null : str.substring(start, end);
    }

    // ==================== 5. String Checks ====================

    /**
     * Checks if a string contains another string.
     * <p>
     * Examples:
     * 
     * <pre>
     * contains(null, "a") → false
     * contains("abc", null) → false
     * contains("abc", "a") → true
     * </pre>
     * 
     * @param str       the source string
     * @param searchStr the string to search for
     * @return {@code true} if contains, {@code false} otherwise (null‑safe)
     */
    public static boolean contains(String str, String searchStr) {
        return str != null && searchStr != null && str.contains(searchStr);
    }

    /**
     * Checks if a string contains another string, ignoring case.
     * <p>
     * Examples:
     * 
     * <pre>
     * containsIgnoreCase(null, "a") → false
     * containsIgnoreCase("abc", "A") → true
     * </pre>
     * 
     * @param str       the source string
     * @param searchStr the string to search for
     * @return {@code true} if contains (case‑insensitive), {@code false} otherwise
     */
    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null)
            return false;
        return str.toLowerCase().contains(searchStr.toLowerCase());
    }

    /**
     * Checks if a string starts with a given prefix.
     * <p>
     * Examples:
     * 
     * <pre>
     * startsWith(null, "a") → false
     * startsWith("abc", "ab") → true
     * </pre>
     * 
     * @param str    the source string
     * @param prefix the prefix to check
     * @return {@code true} if starts with, {@code false} otherwise (null‑safe)
     */
    public static boolean startsWith(String str, String prefix) {
        return str != null && prefix != null && str.startsWith(prefix);
    }

    /**
     * Checks if a string ends with a given suffix.
     * <p>
     * Examples:
     * 
     * <pre>
     * endsWith(null, "c") → false
     * endsWith("abc", "bc") → true
     * </pre>
     * 
     * @param str    the source string
     * @param suffix the suffix to check
     * @return {@code true} if ends with, {@code false} otherwise (null‑safe)
     */
    public static boolean endsWith(String str, String suffix) {
        return str != null && suffix != null && str.endsWith(suffix);
    }

    /**
     * Compares two strings for equality (null‑safe).
     * <p>
     * Examples:
     * 
     * <pre>
     * equals(null, null) → true
     * equals("abc", "abc") → true
     * </pre>
     * 
     * @param str1 first string
     * @param str2 second string
     * @return {@code true} if equal, {@code false} otherwise
     */
    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    /**
     * Compares two strings for equality ignoring case (null‑safe).
     * <p>
     * Examples:
     * 
     * <pre>
     * equalsIgnoreCase(null, null) → true
     * equalsIgnoreCase("abc", "ABC") → true
     * </pre>
     * 
     * @param str1 first string
     * @param str2 second string
     * @return {@code true} if equal ignoring case, {@code false} otherwise
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }

    // ==================== 6. Removal / Replacement ====================

    /**
     * Removes a prefix from a string if present.
     * <p>
     * Examples:
     * 
     * <pre>
     * removeStart(null, "a") → null
     * removeStart("abc", "a") → "bc"
     * </pre>
     * 
     * @param str    the source string
     * @param remove the prefix to remove
     * @return string without prefix, or original if not present, or {@code null} if
     *         input is {@code null}
     */
    public static String removeStart(String str, String remove) {
        if (str == null || remove == null)
            return str;
        return str.startsWith(remove) ? str.substring(remove.length()) : str;
    }

    /**
     * Removes a suffix from a string if present.
     * <p>
     * Examples:
     * 
     * <pre>
     * removeEnd(null, "c") → null
     * removeEnd("abc", "c") → "ab"
     * </pre>
     * 
     * @param str    the source string
     * @param remove the suffix to remove
     * @return string without suffix, or original if not present, or {@code null} if
     *         input is {@code null}
     */
    public static String removeEnd(String str, String remove) {
        if (str == null || remove == null)
            return str;
        return str.endsWith(remove) ? str.substring(0, str.length() - remove.length()) : str;
    }

    /**
     * Removes all occurrences of a substring.
     * <p>
     * Examples:
     * 
     * <pre>
     * remove(null, "a") → null
     * remove("abc", "b") → "ac"
     * </pre>
     * 
     * @param str    the source string
     * @param remove the substring to remove
     * @return string with all occurrences removed, or {@code null} if input is
     *         {@code null}
     */
    public static String remove(String str, String remove) {
        if (str == null || remove == null)
            return str;
        return str.replace(remove, "");
    }

    /**
     * Replaces all occurrences of a search string with a replacement.
     * If search is empty, inserts replacement between every character
     * (including before first and after last).
     * <p>
     * Examples:
     * 
     * <pre>
     * replace(null, "a", "b") → null
     * replace("abc", "a", "b") → "bbc"
     * replace("abc", "", "x") → "xaxbxcx"
     * </pre>
     * 
     * @param str         the source string
     * @param search      the string to replace
     * @param replacement the replacement string
     * @return replaced string, or {@code null} if input is {@code null}
     */
    public static String replace(String str, String search, String replacement) {
        if (str == null || search == null || replacement == null)
            return str;
        if (search.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(replacement).append(str.charAt(i));
            }
            sb.append(replacement);
            return sb.toString();
        }
        return str.replace(search, replacement);
    }

    /**
     * Replaces all substrings matching a regex with a replacement.
     * <p>
     * Examples:
     * 
     * <pre>
     * replaceAll(null, "\\d", "x") → null
     * replaceAll("123", "\\d", "x") → "xxx"
     * </pre>
     * 
     * @param str         the source string
     * @param regex       the regular expression
     * @param replacement the replacement string
     * @return replaced string, or {@code null} if input is {@code null}
     */
    public static String replaceAll(String str, String regex, String replacement) {
        if (str == null || regex == null || replacement == null)
            return str;
        return str.replaceAll(regex, replacement);
    }

    // ==================== 7. Padding & Repetition ====================

    /**
     * Repeats a string a given number of times.
     * <p>
     * Examples:
     * 
     * <pre>
     * repeat(null, 3) → null
     * repeat("a", 3) → "aaa"
     * repeat("ab", 2) → "abab"
     * </pre>
     * 
     * @param str   the string to repeat
     * @param count number of repetitions
     * @return repeated string, or {@code null} if input is {@code null}, empty if
     *         count ≤ 0
     */
    public static String repeat(String str, int count) {
        if (str == null)
            return null;
        if (count <= 0)
            return "";
        return str.repeat(count);
    }

    /**
     * Left pads a string with a specified character to a given length.
     * <p>
     * Examples:
     * 
     * <pre>
     * leftPad(null, 5, ' ') → null
     * leftPad("abc", 5, ' ') → "  abc"
     * leftPad("", 3, '*') → "***"
     * </pre>
     * 
     * @param str     the string to pad
     * @param size    the desired length
     * @param padChar the padding character
     * @return padded string, or {@code null} if input is {@code null}
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null)
            return null;
        if (str.length() >= size)
            return str;
        StringBuilder sb = new StringBuilder(size);
        for (int i = str.length(); i < size; i++)
            sb.append(padChar);
        sb.append(str);
        return sb.toString();
    }

    /**
     * Right pads a string with a specified character to a given length.
     * <p>
     * Examples:
     * 
     * <pre>
     * rightPad(null, 5, ' ') → null
     * rightPad("abc", 5, ' ') → "abc  "
     * rightPad("", 3, '*') → "***"
     * </pre>
     * 
     * @param str     the string to pad
     * @param size    the desired length
     * @param padChar the padding character
     * @return padded string, or {@code null} if input is {@code null}
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null)
            return null;
        if (str.length() >= size)
            return str;
        StringBuilder sb = new StringBuilder(str);
        for (int i = str.length(); i < size; i++)
            sb.append(padChar);
        return sb.toString();
    }

    // ==================== 8. Joining & Splitting ====================

    /**
     * Joins an array of objects into a string with a separator.
     * <p>
     * Examples:
     * 
     * <pre>
     * join(null, ",") → null
     * join(new Object[]{"a","b","c"}, ",") → "a,b,c"
     * join(new Object[]{1,2,3}, "-") → "1-2-3"
     * </pre>
     * 
     * @param array     the array to join
     * @param separator the separator between elements
     * @return joined string, or {@code null} if array is {@code null}
     */
    public static String join(Object[] array, String separator) {
        if (array == null)
            return null;
        if (separator == null)
            separator = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0)
                sb.append(separator);
            sb.append(array[i] == null ? "null" : array[i].toString());
        }
        return sb.toString();
    }

    /**
     * Splits a string by a separator (regex), preserving trailing empty strings.
     * <p>
     * Examples:
     * 
     * <pre>
     * split(null, ",") → null
     * split("a,b,c", ",") → ["a","b","c"]
     * split(",,", ",") → ["","",""]
     * </pre>
     * 
     * @param str       the string to split
     * @param separator the delimiter (regex)
     * @return array of parts, or {@code null} if any input is {@code null}
     */
    public static String[] split(String str, String separator) {
        if (str == null || separator == null)
            return null;
        // Use -1 limit to keep trailing empty strings
        return str.split(separator, -1);
    }

    // ==================== 9. Reverse & Rotate ====================

    /**
     * Reverses the characters in a string.
     * <p>
     * Examples:
     * 
     * <pre>
     * reverse(null) → null
     * reverse("hello") → "olleh"
     * </pre>
     * 
     * @param str the string to reverse
     * @return reversed string, or {@code null} if input is {@code null}
     */
    public static String reverse(String str) {
        if (str == null)
            return null;
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Reverses the order of words in a string (preserves word internal order).
     * Words are separated by whitespace; leading/trailing whitespace is trimmed.
     * <p>
     * Examples:
     * 
     * <pre>
     * reverseWords(null) → null
     * reverseWords("hello world") → "world hello"
     * </pre>
     * 
     * @param str the string whose words to reverse
     * @return string with words in reverse order, or {@code null} if input is
     *         {@code null}
     */
    public static String reverseWords(String str) {
        if (str == null)
            return null;
        String[] words = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    // ==================== 10. Count & Index ====================

    /**
     * Counts overlapping occurrences of a substring.
     * <p>
     * Examples:
     * 
     * <pre>
     * countOccurrences(null, "a") → 0
     * countOccurrences("aaaa", "aa") → 3
     * countOccurrences("ababa", "aba") → 2
     * </pre>
     * 
     * @param str the source string
     * @param sub the substring to count
     * @return number of occurrences, or 0 if any input is {@code null} or sub is
     *         empty
     */
    public static int countOccurrences(String str, String sub) {
        if (str == null || sub == null || sub.isEmpty())
            return 0;
        int count = 0, idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx++; // allow overlapping matches
        }
        return count;
    }

    /**
     * Counts occurrences of a character in a string.
     * <p>
     * Examples:
     * 
     * <pre>
     * countMatches(null, 'a') → 0
     * countMatches("abca", 'a') → 2
     * </pre>
     * 
     * @param str the source string
     * @param ch  the character to count
     * @return number of occurrences, or 0 if {@code str} is {@code null}
     */
    public static int countMatches(String str, char ch) {
        if (str == null)
            return 0;
        int count = 0;
        for (char c : str.toCharArray())
            if (c == ch)
                count++;
        return count;
    }

    /**
     * Finds the first index of a substring starting from a given position.
     * <p>
     * Examples:
     * 
     * <pre>
     * indexOf(null, "a", 0) → -1
     * indexOf("abc", "b", 0) → 1
     * </pre>
     * 
     * @param str      the source string
     * @param search   the substring to find
     * @param startPos the position to start searching from
     * @return index of first occurrence, or -1 if not found or any input is
     *         {@code null}
     */
    public static int indexOf(String str, String search, int startPos) {
        if (str == null || search == null)
            return -1;
        return str.indexOf(search, startPos);
    }

    /**
     * Finds the last index of a substring.
     * <p>
     * Examples:
     * 
     * <pre>
     * lastIndexOf(null, "a") → -1
     * lastIndexOf("abcabc", "c") → 5
     * </pre>
     * 
     * @param str    the source string
     * @param search the substring to find
     * @return last index, or -1 if not found or any input is {@code null}
     */
    public static int lastIndexOf(String str, String search) {
        if (str == null || search == null)
            return -1;
        return str.lastIndexOf(search);
    }

    // ==================== 11. Abbreviation ====================

    /**
     * Abbreviates a string by removing a given number of characters from the end,
     * adding "..." if truncated.
     * <p>
     * Behavior details:
     * <ul>
     * <li>If {@code str} is {@code null}, returns {@code null}.</li>
     * <li>If {@code maxWidth} (number of removed characters) is less than 1:
     * <ul>
     * <li>Returns the original string unchanged.</li>
     * </ul>
     * </li>
     * <li>If no characters need to be removed, returns the original string
     * unchanged.</li>
     * <li>Otherwise, removes {@code maxWidth} characters from the end of the string
     * and appends {@code "..."}.</li>
     * <li>Ensures at least one character remains before adding {@code "..."}.</li>
     * </ul>
     * </p>
     * <p>
     * Examples:
     * 
     * <pre>
     * abbreviate("abcdefghijk", 6) → "abcde..."
     * abbreviate("abcdef", 5)      → "a..."
     * abbreviate("abcdef", 4)      → "ab..."
     * abbreviate("abc", 3)         → "a..."
     * abbreviate("abcdef", 0)      → "abcdef"
     * </pre>
     * </p>
     * 
     * @param str      the string to abbreviate (may be {@code null})
     * @param maxWidth the number of characters to remove from the end (must be ≥ 1)
     * @return the abbreviated string, or {@code null} if input is {@code null}
     */
    public static String abbreviate(String str, int maxWidth) {
        if (str == null)
            return null;
        if (maxWidth < 1) {
            return str;
        }
        if (str.length() <= maxWidth) {
            return str.substring(0, 1) + "...";
        }
        return str.substring(0, str.length() - maxWidth) + "...";
    }

    // ==================== 12. Difference ====================

    /**
     * Returns the suffix of the second string that differs from the first.
     * <p>
     * Examples:
     * 
     * <pre>
     * difference(null, "abc") → ""
     * difference("abc", "abcxyz") → "xyz"
     * </pre>
     * 
     * @param str1 first string
     * @param str2 second string
     * @return differing part of {@code str2}, or empty string if equal or any input
     *         is {@code null}
     */
    public static String difference(String str1, String str2) {
        if (str1 == null || str2 == null)
            return "";
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i))
            i++;
        return str2.substring(i);
    }

    // ==================== 13. Misc Utilities ====================

    /**
     * Extracts all digits from a string.
     * <p>
     * Examples:
     * 
     * <pre>
     * getDigits(null) → null
     * getDigits("a1b2c3") → "123"
     * </pre>
     * 
     * @param str the source string
     * @return string containing only digits, or {@code null} if input is
     *         {@code null}
     */
    public static String getDigits(String str) {
        if (str == null)
            return null;
        return str.replaceAll("\\D", "");
    }

    /**
     * Extracts all letters (A-Z, a-z) from a string.
     * <p>
     * Examples:
     * 
     * <pre>
     * getAlpha(null) → null
     * getAlpha("a1b2c3") → "abc"
     * </pre>
     * 
     * @param str the source string
     * @return string containing only letters, or {@code null} if input is
     *         {@code null}
     */
    public static String getAlpha(String str) {
        if (str == null)
            return null;
        return str.replaceAll("[^a-zA-Z]", "");
    }

    /**
     * Checks if a string contains only digits.
     * <p>
     * Examples:
     * 
     * <pre>
     * isNumeric(null) → false
     * isNumeric("123") → true
     * isNumeric("12a") → false
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if only digits and non‑empty, otherwise {@code false}
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty())
            return false;
        for (char c : str.toCharArray())
            if (!Character.isDigit(c))
                return false;
        return true;
    }

    /**
     * Checks if a string contains only letters.
     * <p>
     * Examples:
     * 
     * <pre>
     * isAlpha(null) → false
     * isAlpha("abc") → true
     * isAlpha("123") → false
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if only letters and non‑empty, otherwise {@code false}
     */
    public static boolean isAlpha(String str) {
        if (str == null || str.isEmpty())
            return false;
        for (char c : str.toCharArray())
            if (!Character.isLetter(c))
                return false;
        return true;
    }

    /**
     * Checks if a string contains only letters or digits.
     * <p>
     * Examples:
     * 
     * <pre>
     * isAlphanumeric(null) → false
     * isAlphanumeric("abc123") → true
     * isAlphanumeric("abc!") → false
     * </pre>
     * 
     * @param str the string to check
     * @return {@code true} if only letters/digits and non‑empty, otherwise
     *         {@code false}
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null || str.isEmpty())
            return false;
        for (char c : str.toCharArray())
            if (!Character.isLetterOrDigit(c))
                return false;
        return true;
    }
}