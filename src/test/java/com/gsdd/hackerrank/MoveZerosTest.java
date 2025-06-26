package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MoveZerosTest {

  // Assume your solution is in a class named 'ListProblems'
  // and has a method 'moveZeros(List<Integer> nums)'

  @Test
  void testExample1() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 0, 3, 12));
    List<Integer> expected = Arrays.asList(1, 3, 12, 0, 0);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testSingleZero() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0));
    List<Integer> expected = Arrays.asList(0);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testSingleNonZero() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1));
    List<Integer> expected = Arrays.asList(1);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testNoZeros() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
    List<Integer> expected = Arrays.asList(1, 2, 3);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testAllZeros() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 0));
    List<Integer> expected = Arrays.asList(0, 0, 0);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testZerosAtEnd() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 0, 0));
    List<Integer> expected = Arrays.asList(1, 2, 0, 0);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }

  @Test
  void testMixedZeros() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 2, 0, 3));
    List<Integer> expected = Arrays.asList(1, 2, 3, 0, 0, 0, 0);
    ListProblems.moveZeros(nums);
    assertEquals(expected, nums);
  }
}
