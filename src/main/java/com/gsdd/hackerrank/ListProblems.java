package com.gsdd.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListProblems {

  /**
   * Problem Description: Given two lists of integers, list1 and list2, return a new list containing
   * all elements that are common to both lists. The order of elements in the result list does not
   * matter. Each common element should appear only once in the result list, even if it appears
   * multiple times in the input lists.
   *
   * <p>Example: Input: list1 = [1, 2, 2, 1], list2 = [2, 2] Expected Output: [2] (or [2] if
   * duplicates were removed internally, but [2, 2] would also be valid if we were keeping
   * frequency) Self-correction: The problem asks for "each common element should appear only once".
   * So [2] is correct.
   *
   * <p>Input: list1 = [4, 9, 5], list2 = [9, 4, 9, 8, 4] Expected Output: [9, 4] (or [4, 9])
   *
   * <p>Input: list1 = [1, 2], list2 = [3, 4] Expected Output: []
   */
  public static List<Integer> findIntersection(List<Integer> first, List<Integer> second) {
    if (first.isEmpty() || second.isEmpty()) {
      return new ArrayList<>(); // Return an empty mutable list as per common practice
    }

    // Use a HashSet to store elements from one list for O(1) average time lookups
    Set<Integer> set1 = new HashSet<>(first); // O(N) to build this set

    List<Integer> intersection = new ArrayList<>();
    // Use another HashSet to ensure uniqueness in the result,
    // in case list2 contains duplicates that are common.
    Set<Integer> seenInIntersection = new HashSet<>();

    // Iterate through the second list
    for (Integer num : second) {
      // Check if the element exists in the first set (O(1) average lookup)
      if (set1.contains(num)) {
        // Add to result only if not already added to prevent duplicates in result
        if (seenInIntersection.add(num)) { // add() returns true if element was new
          intersection.add(num);
        }
      }
    }
    return intersection;
  }

  /**
   * Problem Description: Given a List<Integer> nums, reverse the order of its elements in-place.
   * You are not allowed to create a new list.
   *
   * <p>Example: Input: nums = [1, 2, 3, 4, 5] Expected Output: nums becomes [5, 4, 3, 2, 1]
   *
   * <p>Input: nums = [1, 2, 3, 4] Expected Output: nums becomes [4, 3, 2, 1]
   */
  public static List<Integer> reverseList(List<Integer> nums) {
    if (nums.isEmpty() || nums.size() == 1) {
      return nums;
    }

    int left = 0;
    int right = nums.size() - 1;

    while (left < right) {
      // Swap the elements at the left and right pointers
      int temp = nums.get(left);
      nums.set(left, nums.get(right));
      nums.set(right, temp);

      left++;
      right--;
    }

    // return nums.stream().sorted(Comparator.reverseOrder()).toList();
    // return nums.reversed();
    return nums;
  }

  /**
   * Problem Description: Given a List<Integer> nums, move all 0's to the end of it while
   * maintaining the relative order of the non-zero elements. You must do this in-place without
   * making a copy of the list.
   *
   * <p>Example: Input: nums = [0, 1, 0, 3, 12] Expected Output: nums becomes [1, 3, 12, 0, 0]
   *
   * <p>Input: nums = [0] Expected Output: nums becomes [0]
   *
   * <p>Input: nums = [1] Expected Output: nums becomes [1]
   */
  public static List<Integer> moveZeros(List<Integer> nums) {
    if (nums == null || nums.isEmpty()) {
      return nums;
    }

    int writePointer = 0; // Pointer for where to place the next non-zero element

    // First pass: Move all non-zero elements to the front
    for (int readPointer = 0; readPointer < nums.size(); readPointer++) {
      if (nums.get(readPointer) != 0) {
        // Only write if it's necessary (i.e., if readPointer is ahead of writePointer
        // or if it's the first element)
        // This condition makes it truly in-place without unnecessary self-assignments
        if (readPointer != writePointer) {
          nums.set(writePointer, nums.get(readPointer));
        }
        writePointer++;
      }
    }

    // Second pass: Fill the rest of the list with zeros
    // These are the positions from 'writePointer' to the end of the list
    for (int i = writePointer; i < nums.size(); i++) {
      nums.set(i, 0);
    }
    return nums;
  }
}
