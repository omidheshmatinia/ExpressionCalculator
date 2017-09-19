package com.github.omidheshmatinia.expressioncalculator.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void calculateExpression_shouldPassAll() throws Exception {

        Calculator calc= new Calculator();
        assertEquals(22,calc.calculateExpression("4 * 5 + 2"),0.0);
        assertEquals(4,calc.calculateExpression("2 * sqrt(4)"),0.0);
        assertEquals(404,calc.calculateExpression("304 / 16 + 11 * (16 + 19)"),0.0);
        assertEquals(1137,calc.calculateExpression("32 * 4 + 1 + 6 * 34 * 8 - 12 * 52"),0.0);
        assertEquals(42,calc.calculateExpression("sqrt(32 * 4 / (2 + 6) * 113 - 8 * 12 + 52)"),0.0);
    }

    @Test
    public void calculateExpression_shouldNotBeCaseSensitive() throws Exception {
        Calculator calc= new Calculator();
        assertEquals(2,calc.calculateExpression("SqRt(4)"),0.0);
    }

    @Test(expected = RuntimeException.class)
    public void calculateExpression_throwExceptionOnUnrecognizedCharacters() throws Exception {
        Calculator calc= new Calculator();
        calc.calculateExpression("test(4)");
    }
}