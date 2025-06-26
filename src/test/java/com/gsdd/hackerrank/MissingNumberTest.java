package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MissingNumberTest {

  // Assume the class with your solution is named 'ArrayProblems'
  // and has a method 'findMissingNumber(int[] nums)'

  @Test
  void testExample1() {
    int[] nums = {3, 0, 1};
    assertEquals(2, ArrayProblems.findMissingNumber(nums));
  }

  @Test
  void testExample2() {
    int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    assertEquals(8, ArrayProblems.findMissingNumber(nums));
  }

  @Test
  void testSingleElementMissingZero() {
    int[] nums = {1};
    assertEquals(0, ArrayProblems.findMissingNumber(nums));
  }

  @Test
  void testSingleElementMissingOne() {
    int[] nums = {0};
    assertEquals(1, ArrayProblems.findMissingNumber(nums));
  }
}
