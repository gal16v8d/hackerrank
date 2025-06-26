package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RotateArrayTest {

  // Assume the class with your solution is named 'ArrayProblems'
  // and has a method 'rotate(int[] nums, int k)' that modifies the array in-place

  @Test
  void testExample1() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    ArrayProblems.rotate(nums, k);
    assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, nums);
  }

  @Test
  void testExample2() {
    int[] nums = {-1, -100, 3, 99};
    int k = 2;
    ArrayProblems.rotate(nums, k);
    assertArrayEquals(new int[] {3, 99, -1, -100}, nums);
  }

  @Test
  void testKLargerThanArrayLength() {
    int[] nums = {1, 2};
    int k = 3;
    ArrayProblems.rotate(nums, k);
    assertArrayEquals(new int[] {2, 1}, nums);
  }

  @Test
  void testKEqualToArrayLength() {
    int[] nums = {1, 2, 3, 4};
    int k = 4;
    ArrayProblems.rotate(nums, k);
    assertArrayEquals(new int[] {1, 2, 3, 4}, nums);
  }

  @Test
  void testSingleElement() {
    int[] nums = {1};
    int k = 5;
    ArrayProblems.rotate(nums, k);
    assertArrayEquals(new int[] {1}, nums);
  }

  @Test
  void testEmptyArray() {
    int[] nums = {};
    int k = 10;
    ArrayProblems.rotate(nums, k);
    assertArrayEquals(new int[] {}, nums);
  }
}
