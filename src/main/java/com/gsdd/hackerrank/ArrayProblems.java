package com.gsdd.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayProblems {

  /**
   * Problem Description: Given an integer array nums, return true if any value appears at least
   * twice in the array, and return false if every element is distinct.
   *
   * <p>Example: Input: nums = [1, 2, 3, 1] Expected Output: true (Explanation: The number 1 appears
   * twice.)
   */
  public static boolean containsDuplicate(int[] array) {
    Set<Integer> seenNumbers = new HashSet<>(); // Use a HashSet to store seen numbers

    for (int num : array) {
      // If the number is already in the set, it's a duplicate
      if (seenNumbers.contains(num)) {
        return true;
      }
      // Otherwise, add it to the set
      seenNumbers.add(num);
    }

    // If we iterate through the entire array without finding duplicates
    return false;
  }

  /**
   * Challenge 1: Find the Missing Number Problem Description: You are given an array nums
   * containing n distinct numbers in the range [0, n]. Your task is to return the only number in
   * the range that is missing from the array.
   *
   * <p>Example: Input: nums = [3, 0, 1] Expected Output: 2 (Explanation: n = 3. All numbers are in
   * the range [0, 3]. 2 is the missing number.)
   */
  public static int findMissingNumber(int[] values) {
    Arrays.sort(values); // Sort in-place to avoid extra array, though stream also creates one.

    // Case 1: If 0 is missing
    if (values[0] != 0) {
      return 0;
    }

    // Case 2: Check for missing number in between
    for (int i = 0; i < values.length; i++) {
      if (values[i] != i) {
        return i; // This implies 'i' is the missing number
      }
    }

    // Case 3: If no number from 0 to n-1 is missing, then n is missing
    return values.length; // The missing number is 'n' (which is values.length)
  }

  /**
   * Problem Description: Given an integer array nums, rotate the array to the right by k steps,
   * where k is non-negative.
   *
   * <p>Example: Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3 Expected Output: [5, 6, 7, 1, 2, 3, 4]
   *
   * <p>Explanation:
   *
   * <p>rotate 1 step to the right: [7, 1, 2, 3, 4, 5, 6]
   *
   * <p>rotate 2 steps to the right: [6, 7, 1, 2, 3, 4, 5]
   *
   * <p>rotate 3 steps to the right: [5, 6, 7, 1, 2, 3, 4]
   */
  public static void rotate(int[] values, int k) {
    int n = values.length;
    if (n == 0 || k == 0) {
      return; // No rotation needed for empty array or k=0
    }

    k %= n; // Optimize k

    int[] rotated = new int[n]; // Temporary array

    for (int i = 0; i < n; i++) {
      // Calculate new position: (current_index + k) % total_length
      rotated[(i + k) % n] = values[i];
    }

    // Copy elements back to the original array
    System.arraycopy(rotated, 0, values, 0, n);
  }

  /**
   * Find the minimum possible number you can build with the digits of each number. The number
   * should not have leading zeros. Also sign of the number should be preserved.
   */
  public static int[] minimumNumber(int[] values) {
    for (int i = 0; i < values.length; i++) {
      int value = values[i];
      boolean isNegative = value < 0;
      StringBuilder sb = new StringBuilder();

      // Convert to absolute value and sort digits
      char[] digits = String.valueOf(Math.abs(value)).toCharArray();
      Arrays.sort(digits);

      if (isNegative) {
        for (int j = digits.length - 1; j >= 0; j--) {
          sb.append(digits[j]);
        }
      } else {
        // check arr for leading zeros
        if (digits[0] == '0') {
          // Find the first non-zero digit
          int firstNonZeroIndex = 0;
          while (firstNonZeroIndex < digits.length && digits[firstNonZeroIndex] == '0') {
            firstNonZeroIndex++;
          }
          // If we found a non-zero digit, swap it with the first digit
          if (firstNonZeroIndex < digits.length) {
            sb.append(digits[firstNonZeroIndex]);
            for (int j = 0; j < digits.length; j++) {
              if (j != firstNonZeroIndex) {
                sb.append(digits[j]);
              }
            }
          } else {
            sb.append('0'); // If all are zeros, just append one zero
          }
        } else {
          sb.append(digits);
        }
      }

      // Convert back to integer and store in the array
      values[i] = isNegative ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
    }
    return values;
  }

  /** Print a triangle of n size (n: number of rows) */
  public static String printTriangle(int n) {
    if (n <= 0) {
      return "";
    }
    if (n == 1) {
      return "1";
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("1\n");
      for (int i = 2; i <= n; i++) {
        sb.append(String.valueOf(i).repeat(Math.max(0, i)));
        sb.append("\n");
      }
      return sb.toString();
    }
  }
}
