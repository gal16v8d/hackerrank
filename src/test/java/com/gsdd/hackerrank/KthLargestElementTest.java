package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestElementTest {

  // Assume your solution is in a class named 'MapAndTreeProblems'
  // and has a method 'findKthLargest(int[] nums, int k)'

  @Test
  void testExample1() {
    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    assertEquals(5, MapAndTreeProblems.findKthLargest(nums, k));
  }

  @Test
  void testExample2() {
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    assertEquals(4, MapAndTreeProblems.findKthLargest(nums, k));
  }

  @Test
  void testSmallestK() {
    int[] nums = {1, 2, 3, 4, 5};
    int k = 1;
    assertEquals(5, MapAndTreeProblems.findKthLargest(nums, k)); // 1st largest
  }

  @Test
  void testLargestK() {
    int[] nums = {1, 2, 3, 4, 5};
    int k = 5;
    assertEquals(1, MapAndTreeProblems.findKthLargest(nums, k)); // 5th largest
  }

  @Test
  void testDuplicates() {
    int[] nums = {7, 6, 5, 4, 3, 2, 1};
    int k = 5;
    assertEquals(3, MapAndTreeProblems.findKthLargest(nums, k));
  }

  @Test
  void testNegativeNumbers() {
    int[] nums = {-1, -5, -2, 0, 3, 1};
    int k = 3; // Sorted: [-5, -2, -1, 0, 1, 3], 3rd largest is -1
    assertEquals(0, MapAndTreeProblems.findKthLargest(nums, k));
  }
}
