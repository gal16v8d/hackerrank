package com.gsdd.hackerrank;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class VmChallengeTest {

  private static Stream<Arguments> convertParams() {
    return Stream.of(
        Arguments.of("1, 2, 3", List.of(1, 2, 3)),
        Arguments.of("2-6", List.of(2, 3, 4, 5, 6)),
        Arguments.of("1, 3-5, 9", List.of(1, 3, 4, 5, 9)));
  }

  @ParameterizedTest
  @MethodSource({"convertParams"})
  void testConvertFromInput(String input, List<Integer> output) {
    Assertions.assertArrayEquals(output.toArray(), VmChallenge.convertFromInput(input).toArray());
  }
}
