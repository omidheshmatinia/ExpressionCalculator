package com.github.omidheshmatinia.expressioncalculator.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialLanguageHelperTest {
    @Test
    public void makeItUniversal_shouldConvertArabicNumbers() throws Exception {
        String numbers="۰۱۲۳۴۵۶۷۸۹";
        numbers = SpecialLanguageHelper.makeItUniversal(numbers);
        assertEquals(numbers,"0123456789");
    }

    @Test
    public void makeItUniversal_shouldFail() throws Exception {
        String numbers="۱۲۳";
        numbers = SpecialLanguageHelper.makeItUniversal(numbers);
        assertNotEquals(numbers,"۱۲۳");
    }

    @Test(expected = NullPointerException.class)
    public void makeItUniversal_shouldThrowExceptionIfPassNull() throws Exception {
        SpecialLanguageHelper.makeItUniversal(null);
    }
}