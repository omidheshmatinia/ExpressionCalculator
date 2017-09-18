package com.github.omidheshmatinia.expressioncalculator.utils;

/**
 * convert Arabic and Persian numbers to english numbers
 */
public class SpecialLanguageHelper {
    private final static String[] arabicNumbers = {"۱","۲","۳","۴","۵","۶","۷","۸","۹","۰"};
    private final static String[] universalNumbers = {"1","2","3","4","5","6","7","8","9","0"};

    /**
     * convert all Arabic and Persian numbers to english numbers
     * @return expression in english number
     */
    public static String makeItUniversal(String expression){
        for(int i=0;i<universalNumbers.length;i++){
            expression = expression.replace(arabicNumbers[i],universalNumbers[i]);
        }
        return expression;
    }
}
