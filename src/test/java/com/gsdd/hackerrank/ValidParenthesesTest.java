package com.gsdd.hackerrank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

  // Assume your solution is in a class named 'StackAndRecursionProblems'
  // and has a method 'isValid(String s)'

  @Test
  void testExample1() {
    assertTrue(StackAndRecursionProblems.isValid("()"));
  }

  @Test
  void testExample2() {
    assertTrue(StackAndRecursionProblems.isValid("()[]{}"));
  }

  @Test
  void testExample3() {
    assertFalse(StackAndRecursionProblems.isValid("(]"));
  }

  @Test
  void testNestedParentheses() {
    assertTrue(StackAndRecursionProblems.isValid("([{}])"));
  }

  @Test
  void testMismatchedOpen() {
    assertFalse(StackAndRecursionProblems.isValid("((("));
  }

  @Test
  void testMismatchedClose() {
    assertFalse(StackAndRecursionProblems.isValid(")))"));
  }

  @Test
  void testIncorrectOrder() {
    assertFalse(StackAndRecursionProblems.isValid("([)]"));
  }

  @Test
  void testEmptyString() {
    assertTrue(StackAndRecursionProblems.isValid(""));
  }

  @Test
  void testComplexValid() {
    assertTrue(StackAndRecursionProblems.isValid("{([])}{()}"));
  }

  @Test
  void testComplexInvalid() {
    assertFalse(StackAndRecursionProblems.isValid("((()))]"));
  }
}
