package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReverseListInPlaceTest {

  // Assume your solution is in a class named 'ListProblems'
  // and has a method 'reverseList(List<Integer> nums)'

  @Test
  void testOddLengthList() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
    ListProblems.reverseList(nums); // Method modifies nums in-place
    assertEquals(expected, nums);
  }

  @Test
  void testEvenLengthList() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    List<Integer> expected = Arrays.asList(4, 3, 2, 1);
    ListProblems.reverseList(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testSingleElementList() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(10));
    List<Integer> expected = Arrays.asList(10);
    ListProblems.reverseList(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testEmptyList() {
    List<Integer> nums = new ArrayList<>();
    List<Integer> expected = Arrays.asList();
    ListProblems.reverseList(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testTwoElementsList() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(7, 8));
    List<Integer> expected = Arrays.asList(8, 7);
    ListProblems.reverseList(nums);
    assertEquals(expected, nums);
  }
}
