package com.github.omidheshmatinia.expressioncalculator.utils;

public class CharacterHelper {

    public static boolean isCharacter(char c){
        return (c >= 'a' && c <= 'z');
    }

    public static boolean isNumber(char c) {
        return (c>='0' && c<='9');
    }
}
