package tp2_junit.test;
import tp2_junit.RomanNumerals;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralsTest {
  @Test
  public void testToInteger1() {
    assertEquals(1, RomanNumerals.toInteger("I"));
    assertEquals(5, RomanNumerals.toInteger("V"));
  }
  
  @Test
  public void testToInteger2() {
    assertEquals(1, RomanNumerals.toIntegerLetter('I'));
    assertEquals(5, RomanNumerals.toIntegerLetter('V'));
    assertEquals(10, RomanNumerals.toIntegerLetter('X'));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testToInteger2bad2() {
    assertEquals(2, RomanNumerals.toInteger("III"));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testToInteger2Bad3() {
    assertEquals(3, RomanNumerals.toInteger("II"));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testToInteger2Bad4() {
    assertEquals(-3, RomanNumerals.toInteger("II"));
  }
  
  @Test
  public void testToInteger4() {
    assertEquals("IV", RomanNumerals.ToRomanNumerals(4));
  }

}
