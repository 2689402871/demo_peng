package com.example.demo_peng.untils;


public class StringUtil {

//    连续3个或以上字母 正则表达式
    public static final String CANSECUTIVE_LETTERS_REGEX = "(.)\\1{2,}";

    public static final String LOWERCASE_LETTERS_REGEX = "^[a-z]+$";

//    最小字母
    public static final char SMALLEST_LETTER = 'a';

//    根据小写字符串 返回字母表中前一位字母  最小字母则返回null
    public static Character getPreviousLetterFromLowercase(String input){
//        输入不规范 则返回null
        if(!isLowercaseLetterOnly(input)){
            return null;
        }
        char[] chars = input.toCharArray();
        char c = chars[0];
        if(SMALLEST_LETTER == c){
            return null;
        }
        return (char)(c - 1);

    }

//    是否仅包含小写字母
    public static Boolean isLowercaseLetterOnly(String input){
        if(input == null || input.isBlank()){
            return false;
        }
        return input.matches(LOWERCASE_LETTERS_REGEX);
    }
}
