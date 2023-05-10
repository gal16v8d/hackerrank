package com.gsdd.hackerrank;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Factorial {

  private static final IntFunction<Long> RECURSIVE_FACTORIAL = (n) -> recursiveFactorial(n);

  // just to illustrate, not performant for this case
  private static final IntFunction<Long> ITERATIVE_FACTORIAL = (n) -> {
    Deque<Integer> queue =
        new ArrayDeque<>(IntStream.rangeClosed(0, n).boxed().toList());
    long result = 0;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      result = current == 0 ? 1 : current * result;
    }
    return result;
  };

  public static long recursiveFactorial(int n) {
    return n == 0 ? 1 : (n * recursiveFactorial(n - 1));
  }

  private static void measuredFunction(IntFunction<Long> factorialFunction, Integer value,
      String message) {
    Instant start = Instant.now();
    System.out.println(message.formatted(factorialFunction.apply(value)));
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("ellapsed -> " + timeElapsed);
  }

  public static void main(String[] args) {
    measuredFunction(RECURSIVE_FACTORIAL, 50, "recursive: %s");
    measuredFunction(ITERATIVE_FACTORIAL, 50, "iterative: %s");
  }
}
