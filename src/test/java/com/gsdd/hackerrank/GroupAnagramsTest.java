package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class GroupAnagramsTest {

  // Assume your solution is in a class named 'MapAndTreeProblems'
  // and has a method 'groupAnagrams(String[] strs)'

  // Helper to sort the inner lists and the outer list of lists for consistent comparison
  private List<List<String>> sortAndNormalize(List<List<String>> result) {
    for (List<String> innerList : result) {
      Collections.sort(innerList); // Sort strings within each group
    }
    // Sort the outer list of lists based on the first element of each inner list
    // This makes the comparison deterministic for testing
    Collections.sort(result, (l1, l2) -> l1.get(0).compareTo(l2.get(0)));
    return result;
  }

  @Test
  void testExample1() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("bat"));
    expected.add(Arrays.asList("nat", "tan"));
    expected.add(Arrays.asList("ate", "eat", "tea"));

    List<List<String>> actual = MapAndTreeProblems.groupAnagrams(strs);
    assertTrue(
        sortAndNormalize(expected).equals(sortAndNormalize(actual)),
        "Expected: " + sortAndNormalize(expected) + ", Actual: " + sortAndNormalize(actual));
  }

  @Test
  void testEmptyString() {
    String[] strs = {""};
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList(""));

    List<List<String>> actual = MapAndTreeProblems.groupAnagrams(strs);
    assertTrue(sortAndNormalize(expected).equals(sortAndNormalize(actual)));
  }

  @Test
  void testSingleCharacter() {
    String[] strs = {"a"};
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("a"));

    List<List<String>> actual = MapAndTreeProblems.groupAnagrams(strs);
    assertTrue(sortAndNormalize(expected).equals(sortAndNormalize(actual)));
  }

  @Test
  void testNoAnagrams() {
    String[] strs = {"hello", "world", "java"};
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("hello"));
    expected.add(Arrays.asList("java"));
    expected.add(Arrays.asList("world"));

    List<List<String>> actual = MapAndTreeProblems.groupAnagrams(strs);
    assertTrue(sortAndNormalize(expected).equals(sortAndNormalize(actual)));
  }

  @Test
  void testAllAnagrams() {
    String[] strs = {"listen", "silent", "enlist"};
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("enlist", "listen", "silent"));

    List<List<String>> actual = MapAndTreeProblems.groupAnagrams(strs);
    assertTrue(sortAndNormalize(expected).equals(sortAndNormalize(actual)));
  }

  @Test
  void testMixedCaseNotAnagrams() {
    String[] strs = {"cat", "act", "Tac"}; // "Tac" is not anagram of "cat" unless case-insensitive
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("act", "cat"));
    expected.add(Arrays.asList("Tac"));

    List<List<String>> actual = MapAndTreeProblems.groupAnagrams(strs);
    assertTrue(sortAndNormalize(expected).equals(sortAndNormalize(actual)));
  }
}
