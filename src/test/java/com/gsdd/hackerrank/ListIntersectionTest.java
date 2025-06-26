package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections; // For sorting to compare lists
import java.util.List;
import org.junit.jupiter.api.Test;

class ListIntersectionTest {

  // Assume your solution is in a class named 'ListProblems'
  // and has a method 'findIntersection(List<Integer> list1, List<Integer> list2)'

  // Helper to sort lists for comparison (since order doesn't matter)
  private List<Integer> sortList(List<Integer> list) {
    List<Integer> sortedList = new ArrayList<>(list);
    Collections.sort(sortedList);
    return sortedList;
  }

  @Test
  void testExample1() {
    List<Integer> list1 = Arrays.asList(1, 2, 2, 1);
    List<Integer> list2 = Arrays.asList(2, 2);
    List<Integer> expected = Arrays.asList(2);
    assertEquals(sortList(expected), sortList(ListProblems.findIntersection(list1, list2)));
  }

  @Test
  void testExample2() {
    List<Integer> list1 = Arrays.asList(4, 9, 5);
    List<Integer> list2 = Arrays.asList(9, 4, 9, 8, 4);
    List<Integer> expected = Arrays.asList(9, 4);
    assertEquals(sortList(expected), sortList(ListProblems.findIntersection(list1, list2)));
  }

  @Test
  void testNoCommonElements() {
    List<Integer> list1 = Arrays.asList(1, 2);
    List<Integer> list2 = Arrays.asList(3, 4);
    List<Integer> expected = Arrays.asList();
    assertTrue(ListProblems.findIntersection(list1, list2).isEmpty());
  }

  @Test
  void testEmptyLists() {
    List<Integer> list1 = Arrays.asList();
    List<Integer> list2 = Arrays.asList();
    assertTrue(ListProblems.findIntersection(list1, list2).isEmpty());
  }

  @Test
  void testOneEmptyList() {
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList();
    assertTrue(ListProblems.findIntersection(list1, list2).isEmpty());
  }

  @Test
  void testLargerLists() {
    List<Integer> list1 = Arrays.asList(1, 5, 2, 8, 3, 5, 9);
    List<Integer> list2 = Arrays.asList(3, 1, 7, 5, 0, 8);
    List<Integer> expected = Arrays.asList(1, 3, 5, 8);
    assertEquals(sortList(expected), sortList(ListProblems.findIntersection(list1, list2)));
  }
}
