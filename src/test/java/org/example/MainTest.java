package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void test_hasMinimumLength() {
        String examplePass = "Hello123";
        boolean expected = true;
        boolean actual = Main.hasMinimumLength(examplePass);
        assertEquals(expected, actual);
    }

    @Test
    void test_containsDigit() {
        String examplePass = "Hello1";
        boolean expected = true;
        boolean actual = Main.containsDigit(examplePass);
        assertEquals(expected, actual);
    }

    @Test
    void test_containsUpperAndLowerCase() {
        String examplePass = "Hello";
        boolean expected = true;
        boolean actual = Main.containsUpperAndLowerCase(examplePass);
        assertEquals(expected, actual);
    }

    @Test
    void test_containsCommonUsedPassword() {
        String examplePass = "Hello123";
        boolean expected = true;
        boolean actual = Main.containsCommonUsedPassword(examplePass);
        assertEquals(expected, actual);
    }

    @Test
    void test_containsSpecialChars() {
        String examplePass = "Hello!@#";
        boolean expected = true;
        boolean actual = Main.containsSpecialChars(examplePass);
        assertEquals(expected, actual);
    }

    // tests for generating random password
    @Test
    void test_generatesRandomPasswordForLength() {
        String password = Main.generateRandomPassword(12);
        assertEquals(12, password.length());
    }

    @Test
    public void testPasswordMinimumLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Main.generateRandomPassword(7));
        assertEquals("Password length must be at least 8 character.", exception.getMessage());
    }

    @Test
    void test_generatesRandomPasswordForDigit() {
        String password = Main.generateRandomPassword(14);
        assertTrue(password.chars().anyMatch(Character::isDigit));
    }

    @Test
    void test_generatesRandomPasswordForUpperAndLowerCase() {
        String password = Main.generateRandomPassword(14);
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowercase = password.chars().anyMatch(Character::isLowerCase);
        assertTrue(hasUppercase && hasLowercase);
    }

    @Test
    void test_generatesRandomPasswordForSpecialChars() {
        String password = Main.generateRandomPassword(14);
        boolean hasSpecialChar = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        assertTrue(hasSpecialChar);
    }

}