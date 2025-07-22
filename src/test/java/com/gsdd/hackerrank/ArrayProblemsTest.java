package com.gsdd.hackerrank;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayProblemsTest {

  @Test
  void testMinimumNumber() {
    int[] minNumberArray = {3501, -367, 70800420, 60084, 59901, -20800030, 707821701, 100101};
    int[] expected = {1035, -763, 20000478, 40068, 10599, -83200000, 100127778, 100011};
    Assertions.assertArrayEquals(expected, ArrayProblems.minimumNumber(minNumberArray));
  }

  @ParameterizedTest
  @MethodSource({"printTriangleProvider"})
  void testPrintTriangle(int input, String expectedOutput) {
    String result = ArrayProblems.printTriangle(input);
    Assertions.assertEquals(expectedOutput, result);
  }

  private static Stream<Arguments> printTriangleProvider() {
    return Stream.of(
        Arguments.of(1, "1"),
        Arguments.of(2, "1\n22\n"),
        Arguments.of(3, "1\n22\n333\n"),
        Arguments.of(4, "1\n22\n333\n4444\n"),
        Arguments.of(5, "1\n22\n333\n4444\n55555\n"),
        Arguments.of(6, "1\n22\n333\n4444\n55555\n666666\n"),
        Arguments.of(7, "1\n22\n333\n4444\n55555\n666666\n7777777\n"));
  }
}
