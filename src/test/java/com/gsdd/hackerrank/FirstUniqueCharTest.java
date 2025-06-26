package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FirstUniqueCharTest {

  // Assume your solution is in a class named 'MapAndTreeProblems'
  // and has a method 'firstUniqueChar(String s)'

  @Test
  void testExample1() {
    assertEquals(0, MapAndTreeProblems.firstUniqueChar("leetcode"));
  }

  @Test
  void testExample2() {
    assertEquals(2, MapAndTreeProblems.firstUniqueChar("loveleetcode"));
  }

  @Test
  void testNoUniqueChar() {
    assertEquals(-1, MapAndTreeProblems.firstUniqueChar("aabb"));
  }

  @Test
  void testSingleChar() {
    assertEquals(0, MapAndTreeProblems.firstUniqueChar("a"));
  }

  @Test
  void testEmptyString() {
    assertEquals(-1, MapAndTreeProblems.firstUniqueChar(""));
  }

  @Test
  void testComplexString() {
    assertEquals(4, MapAndTreeProblems.firstUniqueChar("ccacdcbeba")); // 'd' is at index 6
  }

  @Test
  void testAllUnique() {
    assertEquals(0, MapAndTreeProblems.firstUniqueChar("abcde"));
  }
}
