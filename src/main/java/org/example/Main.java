package org.example;

import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        String password = generateRandomPassword(10);
        System.out.println(password);
    }

    // hasMinimumLength(String password) return boolean
    public static boolean hasMinimumLength(String password) {
        int passwordLength = password.length();
        return passwordLength > 7;
    }

    // containsDigit(String password) return boolean
    public static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // containsUpperAndLowerCase(String password) return boolean
    public static boolean containsUpperAndLowerCase(String password) {
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowercase = password.chars().anyMatch(Character::isLowerCase);
        return hasUppercase && hasLowercase;
    }

    // containsCommonUsedPassword(String password) return boolean
    public static boolean containsCommonUsedPassword(String password) {
        String[] weakPasswords = {"Hello123", "Password1", "Aa345678"};
        for (String weakPassword : weakPasswords) {
            if (weakPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    //containsSpecialChars(String password) return boolean
    public static boolean containsSpecialChars(String password) {
        return password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
    }

    //generatesRandomPassword() return String
    public static String generateRandomPassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 character.");
        }
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        String characters = uppercase + lowercase + digits + specialChars;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();

    }
}





