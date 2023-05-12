package br.edu.utfpr.td.tsi.projeto_delegacia.utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String PHONE_REGEX = "^\\(\\d{2}\\) 9 \\d{4}-\\d{4}$";

    private static boolean isValidRegex(String value, String regex) {
        return Pattern.matches(regex, value);
    }

    public static boolean isEmailValid(String value) {
        return isValidRegex(value, EMAIL_REGEX);
    }

    public static boolean isPhoneValid(String value) {
        return isValidRegex(value, PHONE_REGEX);
    }

}
