# String Utils

[![Maven Central](https://img.shields.io/maven-central/v/io.github.adnenre/string-utils/1.1.2)](https://central.sonatype.com/artifact/io.github.adnenre/string-utils/1.1.2)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-11%2B-blue)](https://adoptium.net/)

A lightweight, null‑safe Java utility library with 50+ useful string operations. No external dependencies – pure Java.

## Features

- ✅ **Null‑safe** – no more `NullPointerException` when processing strings.
- ✅ **Overlapping substring counting** – counts every occurrence, even overlapping.
- ✅ **Comprehensive** – from basic checks to advanced manipulation.
- ✅ **Well tested** – 100% coverage with edge cases.
- ✅ **No dependencies** – only the Java standard library.

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
<groupId>io.github.adnenre</groupId>
<artifactId>string-utils</artifactId>
<version>1.1.2</version>
</dependency>
```

### Gradle

```shell
implementation 'io.github.adnenre:string-utils:1.1.2'
```

### Gradle (Kotlin DSL)

```shell
implementation("io.github.adnenre:string-utils:1.1.2")
```

## Quick Examples

### Plain Java

```java
import io.github.adnenre.stringutils.StringUtils;

public class Demo {
public static void main(String[] args) {
// Null safety
System.out.println(StringUtils.isEmpty(null)); // true
System.out.println(StringUtils.defaultIfBlank(null, "default")); // "default"

        // Trimming
        System.out.println(StringUtils.trimToNull("   "));    // null

        // Substring extraction
        System.out.println(StringUtils.substringAfter("abc@example.com", "@")); // "example.com"

        // Counting (overlapping)
        System.out.println(StringUtils.countOccurrences("aaaa", "aa")); // 3

        // Case manipulation
        System.out.println(StringUtils.capitalize("hello"));  // "Hello"
        System.out.println(StringUtils.swapCase("Hello"));    // "hELLO"

        // Abbreviation
        System.out.println(StringUtils.abbreviate("abcdefghijk", 6)); // "abc..."
    }

}
```

### Spring Boot Application

You can use `StringUtils` anywhere in your Spring components, services, or controllers:

```java
import io.github.adnenre.stringutils.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/format")
    public String formatString(@RequestParam String input) {
        if (StringUtils.isBlank(input)) {
            return "Input was blank";
        }
        String trimmed = StringUtils.trim(input);
        String capitalized = StringUtils.capitalize(trimmed);
        return capitalized;
    }

    @GetMapping("/count")
    public int countSubstring(@RequestParam String text,
                              @RequestParam String sub) {
        return StringUtils.countOccurrences(text, sub);
    }

}
```

## Available Methods

The class `io.github.adnenre.stringutils.StringUtils` provides the following categories:

### 1. Null / Empty / Blank Checks

- `isEmpty(String)`, `isNotEmpty(String)`
- `isBlank(String)`, `isNotBlank(String)`
- `defaultIfNull(String, String)`, `defaultIfEmpty(String, String)`, `defaultIfBlank(String, String)`

### 2. Trimming & Whitespace

- `trim(String)`, `trimToNull(String)`, `trimToEmpty(String)`
- `removeWhitespace(String)`

### 3. Case Conversion

- `toLowerCase(String)`, `toUpperCase(String)`
- `capitalize(String)`, `uncapitalize(String)`
- `swapCase(String)`

### 4. Substring Extraction

- `substringAfter(String, String)`, `substringBefore(String, String)`
- `substringAfterLast(String, String)`, `substringBeforeLast(String, String)`
- `substringBetween(String, String, String)`

### 5. String Checks

- `contains(String, String)`, `containsIgnoreCase(String, String)`
- `startsWith(String, String)`, `endsWith(String, String)`
- `equals(String, String)`, `equalsIgnoreCase(String, String)`

### 6. Removal / Replacement

- `removeStart(String, String)`, `removeEnd(String, String)`
- `remove(String, String)`
- `replace(String, String, String)`, `replaceAll(String, String, String)`

### 7. Padding & Repetition

- `repeat(String, int)`
- `leftPad(String, int, char)`, `rightPad(String, int, char)`

### 8. Joining & Splitting

- `join(Object[], String)`
- `split(String, String)` (preserves trailing empty strings)

### 9. Reverse & Rotate

- `reverse(String)`, `reverseWords(String)`

### 10. Count & Index

- `countOccurrences(String, String)` – counts overlapping occurrences
- `countMatches(String, char)`
- `indexOf(String, String, int)`, `lastIndexOf(String, String)`

### 11. Abbreviation

- `abbreviate(String, int)` – truncates with `...` respecting total length

### 12. Difference

- `difference(String, String)`

### 13. Misc Utilities

- `getDigits(String)`, `getAlpha(String)`
- `isNumeric(String)`, `isAlpha(String)`, `isAlphanumeric(String)`

## Documentation

Full Javadoc is available on [Maven Central](https://central.sonatype.com/artifact/io.github.adnenre/string-utils/1.1.2/javadoc) or via the [javadoc.io](https://javadoc.io/doc/io.github.adnenre/string-utils) service.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request on [GitHub](https://github.com/adnenre/string-utils).

## License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

**Author:** Adnen Rebai – [adnenre.dev](https://adnenre.dev)
