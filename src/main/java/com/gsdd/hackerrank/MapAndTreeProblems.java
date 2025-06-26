package com.gsdd.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MapAndTreeProblems {

  /**
   * Problem Description: Given a string s, find the first non-repeating character in it and return
   * its index. If it does not exist, return -1.
   *
   * <p>Example: Input: s = "leetcode" Expected Output: 0 (The character 'l' is at index 0 and
   * appears only once)
   *
   * <p>Input: s = "loveleetcode" Expected Output: 2 (The character 'l' is repeated, 'o' is
   * repeated, 'v' is at index 2 and appears only once)
   *
   * <p>Input: s = "aabb" Expected Output: -1
   */
  public static int firstUniqueChar(String s) {
    if (s == null || s.isEmpty()) {
      return -1; // Handle null or empty string
    }

    // Step 1: Create a frequency map for characters
    Map<Character, Integer> charCounts = new HashMap<>();

    // Populate the frequency map
    // Iterate through the string once to count character occurrences
    for (char c : s.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }

    // Step 2: Iterate through the string again to find the first unique character
    // This second pass is crucial to maintain the order of appearance
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charCounts.get(c) == 1) {
        return i; // Found the first non-repeating character, return its index
      }
    }

    // If no non-repeating character is found after checking all characters
    return -1;
  }

  /**
   * Problem Description: Given an integer array nums and an integer k, return the kth largest
   * element in the array. Note that it is the kth largest element in the sorted order, not the kth
   * distinct element.
   *
   * <p>Example: Input: nums = [3,2,1,5,6,4], k = 2 Expected Output: 5 (Sorted array: [1,2,3,4,5,6],
   * 2nd largest is 5)
   *
   * <p>Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Expected Output: 4 (Sorted array:
   * [1,2,2,3,3,4,5,5,6], 4th largest is 4)
   */
  public static int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
      // As discussed, for valid test cases this won't be hit
      throw new IllegalArgumentException(
          "Invalid input: nums array is null/empty or k is out of range.");
    }

    // Step 1: Use a TreeMap to store frequencies. Keys (numbers) will be naturally sorted.
    // TreeMap<Number, Frequency>
    TreeMap<Integer, Integer> frequencies = new TreeMap<>();
    for (int num : nums) {
      frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
    }

    // Step 2: Traverse the TreeMap in descending order of keys (numbers)
    // Keep a running count of elements encountered from the largest side
    int count = 0;
    // The descendingMap() method provides a reverse-ordered view of the map
    for (Map.Entry<Integer, Integer> entry : frequencies.descendingMap().entrySet()) {
      count += entry.getValue(); // Add the frequency of the current number to our total count

      // If our total count is now >= k, then the current number (entry.getKey())
      // is the k-th largest element.
      if (count >= k) {
        return entry.getKey();
      }
    }

    // This line should theoretically not be reached if k is always valid (k <= nums.length)
    return -1; // Or throw an error if k is invalid
  }

  /**
   * Problem Description: Given an array of strings strs, group the anagrams together. You can
   * return the answer in any order. An Anagram is a word or phrase formed by rearranging the
   * letters of a different word or phrase, typically using all the original letters exactly once.
   *
   * <p>Example: Input: strs = ["eat","tea","tan","ate","nat","bat"] Expected Output:
   * [["bat"],["nat","tan"],["ate","eat","tea"]] (The order of inner lists and the strings within
   * them doesn't strictly matter for the output, but the groups must be correct.)
   *
   * <p>Input: strs = [""] Expected Output: [[""]]
   *
   * <p>Input: strs = ["a"] Expected Output: [["a"]]
   */
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>(); // Return an empty list if input is null or empty
    }

    // Use a HashMap to map the sorted string (canonical form) to a list of its anagrams
    Map<String, List<String>> anagramGroups = new HashMap<>();

    for (String s : strs) {
      // 1. Convert the string to a character array
      char[] charArray = s.toCharArray();

      // 2. Sort the character array. This creates the "canonical form" for anagrams.
      Arrays.sort(charArray);

      // 3. Convert the sorted character array back to a string. This will be our map key.
      String canonicalKey = new String(charArray);

      // 4. Get the list associated with this key, or create a new list if the key doesn't exist.
      // Then, add the original string 's' to this list.
      anagramGroups.computeIfAbsent(canonicalKey, k -> new ArrayList<>()).add(s);
      /*
       * The above line is a concise way of doing:
       * List<String> currentGroup = anagramGroups.get(canonicalKey);
       * if (currentGroup == null) {
       * currentGroup = new ArrayList<>();
       * anagramGroups.put(canonicalKey, currentGroup);
       * }
       * currentGroup.add(s);
       */
    }

    // The values of the map are the lists of grouped anagrams.
    // Collect them into a new List and return.
    return new ArrayList<>(anagramGroups.values());
  }
}
