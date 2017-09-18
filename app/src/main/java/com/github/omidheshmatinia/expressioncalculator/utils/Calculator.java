package com.github.omidheshmatinia.expressioncalculator.utils;

public class Calculator {

    private int currentPosition = -1, currentChar;
    private String mainExpression;
    private String invalidText="";

    public double calculateExpression(String expression) throws RuntimeException{
        if(expression==null || expression.trim().length() == 0)
            throw new ArithmeticException("Wrong mathematical expression. your expression is null or empty");
        currentPosition = -1;
        expression = expression.toLowerCase();
        expression = SpecialLanguageHelper.makeItUniversal(expression);
        expression = expression.replaceAll(" ","");
        expression = expression.replaceAll("\n","");
        mainExpression = expression;
        return calc();
    }

    void nextChar() {
        currentPosition++;
        if(currentPosition < mainExpression.length()) {
            currentChar = mainExpression.charAt(currentPosition);
        } else {
            currentChar = -1;
        }
    }


    private double calc() {
        nextChar();
        double x = parseExpression();
        return x;
    }

    private double parseExpression() {
        double x = parseTerm();
        while(true) {
            if      (goToNextIfCurrentIndexIsEqual('+')) x += parseTerm();
            else if (goToNextIfCurrentIndexIsEqual('-')) x -= parseTerm();
            else return x;
        }
    }

    private double parseTerm() {
        double x = parseFactor();
        while (true){
            if      (goToNextIfCurrentIndexIsEqual('*')) x *= parseFactor();
            else if (goToNextIfCurrentIndexIsEqual('/')) x /= parseFactor();
            else return x;
        }
    }

    double parseFactor() {
        if (goToNextIfCurrentIndexIsEqual('+')) return parseFactor();
        if (goToNextIfCurrentIndexIsEqual('-')) return -parseFactor();

        double x;
        int startPos = currentPosition;
        if (goToNextIfCurrentIndexIsEqual('(')) {
            x = parseExpression();
            goToNextIfCurrentIndexIsEqual(')');
        } else if (isNumber((char)currentChar)) {
            while (isNumber((char)currentChar)) {
                nextChar();
            }
            x = Integer.parseInt(mainExpression.substring(startPos, currentPosition));
        } else if (isCharacter((char)currentChar)) {
            while (isCharacter((char)currentChar)) {
                invalidText+=(char)currentChar;
                nextChar();
            }
            String func = mainExpression.substring(startPos, this.currentPosition);
            x = parseFactor();
            if (func.equals("sqrt")) x = Math.sqrt(x);
            else throw new RuntimeException("Unknown function: " + func);
        } else {
            throw new RuntimeException("Unexpected: " + invalidText);
        }

        if (goToNextIfCurrentIndexIsEqual('^')) x = Math.pow(x, parseFactor());

        return x;
    }


    private boolean goToNextIfCurrentIndexIsEqual(char c){
        if(currentChar == c){
            nextChar();
            return true;
        }
        return false;
    }

    private boolean isCharacter(char c){
        return (c >= 'a' && c <= 'z');
    }

    private boolean isNumber(char c) {
        return (c>='0' && c<='9');
    }

}
