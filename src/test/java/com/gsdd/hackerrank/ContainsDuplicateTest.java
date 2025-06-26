package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ContainsDuplicateTest {

  // Assume the class with your solution is named 'ArrayProblems'
  // and has a method 'containsDuplicate(int[] nums)'

  @Test
  void testExample1() {
    int[] nums = {1, 2, 3, 1};
    assertTrue(ArrayProblems.containsDuplicate(nums));
  }

  @Test
  void testExample2() {
    int[] nums = {1, 2, 3, 4};
    assertFalse(ArrayProblems.containsDuplicate(nums));
  }

  @Test
  void testAllDuplicates() {
    int[] nums = {7, 7, 7, 7};
    assertTrue(ArrayProblems.containsDuplicate(nums));
  }

  @Test
  void testEmptyArray() {
    int[] nums = {};
    assertFalse(ArrayProblems.containsDuplicate(nums));
  }

  @Test
  void testLargeDistinctArray() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertFalse(ArrayProblems.containsDuplicate(nums));
  }
}
