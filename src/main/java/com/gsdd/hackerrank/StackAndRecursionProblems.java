package com.gsdd.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StackAndRecursionProblems {

  /**
   * Problem Description: Given a string s containing just the characters '(', ')', '{', '}', '[',
   * and ']', determine if the input string is valid.
   *
   * <p>An input string is valid if:
   *
   * <p>Open brackets must be closed by the same type of open brackets.
   *
   * <p>Open brackets must be closed in the correct order.
   *
   * <p>Every close bracket has a corresponding open bracket of the same type.
   *
   * <p>Example: Input: s = "()" Expected Output: true
   *
   * <p>Input: s = "()[]{}" Expected Output: true
   *
   * <p>Input: s = "(]" Expected Output: false
   *
   * <p>Input: s = "([{}])" Expected Output: true
   *
   * <p>Input: s = "{[]}" Expected Output: true
   */
  public static boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true; // An empty string is considered valid
    }

    // Use a Deque as a stack. ArrayDeque is efficient for this purpose.
    Deque<Character> stack = new ArrayDeque<>();

    // Create a map to quickly check for corresponding open brackets
    // Key: closing bracket, Value: corresponding opening bracket
    Map<Character, Character> bracketMap = new HashMap<>();
    bracketMap.put(')', '(');
    bracketMap.put('}', '{');
    bracketMap.put(']', '[');

    for (char c : s.toCharArray()) {
      // If it's an opening bracket, push it onto the stack
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      }
      // If it's a closing bracket
      else if (c == ')' || c == '}' || c == ']') {
        // Check if the stack is empty. If so, a closing bracket appeared without an opening one.
        if (stack.isEmpty()) {
          return false;
        }

        // Pop the top element (most recent opening bracket)
        char topChar = stack.pop();

        // Check if the popped character matches the corresponding opening bracket for 'c'
        if (bracketMap.get(c) != topChar) {
          return false; // Mismatched brackets
        }
      }
      // If any other character appears, the string is invalid (though problem states only brackets)
      // else { return false; } // Can add this check if non-bracket chars are possible
    }

    // After iterating through the string, if the stack is empty, all brackets are matched.
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    var queue = new ArrayDeque<String>();
    var stack = new ArrayDeque<String>();
    IntStream.range(0, 10)
        .forEach(
            i -> {
              queue.add("Queue " + i);
              stack.push("Stack " + i);
            });
    while (!queue.isEmpty()) {
      System.out.println("Current Queue Elements: ");
      queue.forEach(System.out::println);
      queue.poll();
    }
    while (!stack.isEmpty()) {
      System.out.println("Current Stack Elements: ");
      stack.forEach(System.out::println);
      stack.pop();
    }
  }
}
