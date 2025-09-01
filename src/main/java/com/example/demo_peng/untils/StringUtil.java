package com.example.demo_peng.untils;


import java.util.Optional;

public class StringUtil {

//    regular expression for three or more consecutive letters
    public static final String CANSECUTIVE_LETTERS_REGEX = "(.)\\1{2,}";

//    regular expression for lowercase letters
    public static final String LOWERCASE_LETTERS_REGEX = "^[a-z]+$";

//    The smallest letter
    public static final char SMALLEST_LETTER = 'a';

//    Return the previous letter in the alphabet based on a lowercase string; return null for the smallest letter.
    public static Optional<Character> getPreviousLetterFromLowercase(String input){
//        If the input is invalid, return null.
        if(!isLowercaseLetterOnly(input)){
            return Optional.empty();
        }
        char c = input.charAt(0);
        return (c == SMALLEST_LETTER) ? Optional.empty() : Optional.of((char) (c - 1));
    }

//    Determine whether it contains only lowercase letters.
    public static boolean isLowercaseLetterOnly(String input){
        return Optional.ofNullable(input)
                .filter(s -> !s.isBlank())
                .filter(s -> s.matches(LOWERCASE_LETTERS_REGEX))
                .isPresent();
    }
}
