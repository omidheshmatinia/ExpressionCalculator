package com.github.omidheshmatinia.expressioncalculator.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterHelperTest {

    String[] alphabets = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] numbers = new String[]{"0","1","2","3","4","5","6","7","8","9"};
    @Test
    public void isCharacter_allAlphabetsShouldBeValid() throws Exception {
        for(int i=0;i<alphabets.length;i++){
            Assert.assertEquals(CharacterHelper.isCharacter(alphabets[i].charAt(0)),true);
        }
    }

    @Test
    public void isCharacter_allNumbersShouldNotBeValid() throws Exception {
        for(int i=0;i<numbers.length;i++){
            Assert.assertEquals(CharacterHelper.isCharacter(numbers[i].charAt(0)),false);
        }
    }

    @Test
    public void isNumber_allNumbersShouldBeValid() throws Exception {
        for(int i=0;i<numbers.length;i++){
            Assert.assertEquals(CharacterHelper.isNumber(numbers[i].charAt(0)),true);
        }
    }

    @Test
    public void isNumber_allAlphabetsShouldNotBeValid() throws Exception {
        for(int i=0;i<alphabets.length;i++){
            Assert.assertEquals(CharacterHelper.isNumber(alphabets[i].charAt(0)),false);
        }
    }

}