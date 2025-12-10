package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void reverse_WithValidString_ReturnsReversedString() {
        Assertions.assertEquals("GNITSET", StringUtils.reverse("TESTING"));
    }

    @Test
    public void reverse_WithNullInput_ReturnsNull() {
        Assertions.assertNull(StringUtils.reverse(null));
    }

    @Test
    public void isEmpty_WithNull_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    public void isEmpty_WithEmptyString_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void isEmpty_WithNonEmptyString_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.isEmpty("TESTING"));
    }

    @Test
    public void isBlank_WithNull_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.isBlank(null));
    }

    @Test
    public void isBlank_WithEmptyString_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.isBlank(""));
    }

    @Test
    public void isBlank_WithWhitespace_ReturnsTrue() {
        Assertions.assertTrue(StringUtils.isBlank("       "));
    }

    @Test
    public void isBlank_WithNonBlankString_ReturnsFalse() {
        Assertions.assertFalse(StringUtils.isBlank("TESTING"));
    }

    @Test
    public void findFirst_WithUniquePrefix_ReturnsMatchingItem() {
        String[] items = {"apple", "banjo", "cars", "dragon"};
        Assertions.assertEquals("banjo", StringUtils.findFirst(items, "ba"));
    }

    @Test
    public void findFirst_WithMultipleMatches_ReturnsFirstMatch() {
        String[] items = {"apple", "banjo", "cars", "bank"};
        Assertions.assertEquals("banjo", StringUtils.findFirst(items, "ba"));
    }

    @Test
    public void findFirst_WithNoMatches_ReturnsNull() {
        String[] items = {"apple", "banjo", "cars", "bank"};
        Assertions.assertNull(StringUtils.findFirst(items, "zz"));
    }

    @Test
    public void findFist_WithSomeNullItems_ReturnsNull() {
        String[] items = {"apple", null, "cars", null};
        Assertions.assertEquals("cars", StringUtils.findFirst(items, "c"));
    }

    @Test
    public void findFist_WithAllNullItems_ReturnsNull() {
        String[] items = {null, null, null, null};
        Assertions.assertEquals(null, StringUtils.findFirst(items, "c"));
    }

    @Test
    public void findFirst_WithNullPrefix_ThrowsNullPointerException() {
        String[] items = {"apple", "banjo", "cars", "bank"};
        Assertions.assertThrows(NullPointerException.class, () -> StringUtils.findFirst(items, null));
    }

    @Test
    public void split_WithWhiteSpaceDelim_ReturnsArray() {
        Assertions.assertArrayEquals(new String[]{"split", "this", "string"}, StringUtils.split("split this string", " "));
    }

    @Test
    public void split_WithEmptyDelim_ReturnsArray() {
        Assertions.assertArrayEquals(new String[]{"s", "p", "l", "i", "t", " ", "s", "t", "r", "i", "n", "g"}, StringUtils.split("split string", ""));
    }

    @Test
    public void split_WithNullDelim_ReturnsArray() {
        Assertions.assertThrows(NullPointerException.class, () -> StringUtils.split("split this string", null));
    }

    @Test
    public void split_WithStringDelim_ReturnsArray() {
        Assertions.assertArrayEquals(new String[]{"split-", "-string"}, StringUtils.split("split-this-string", "this"));
    }

    @Test
    public void split_WithEmptyInput_ReturnsArray() {
        Assertions.assertArrayEquals(new String[]{""}, StringUtils.split("", "-"));
    }

    @Test
    public void split_WithNullInput_ReturnsEmptyArray() {
        Assertions.assertArrayEquals(new String[0], StringUtils.split(null, "-"));
    }

    @Test
    public void parseUser_validUserCsv_returnsUser() {
        Assertions.assertEquals(new User("First", "Last", 25, "email"), StringUtils.parseUser("First,Last,25,email"));
    }

    @Test
    public void parseUser_invalidUserId_returnsUser() {
        Assertions.assertThrows(NumberFormatException.class, () -> StringUtils.parseUser("First,Last,email,25"));
    }

    @Test
    public void parseUser_invalidUserCsvLength_returnsUser() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.parseUser("First,Last,25"));
    }
}
