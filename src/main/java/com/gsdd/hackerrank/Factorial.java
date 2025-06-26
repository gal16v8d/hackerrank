package com.gsdd.hackerrank;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class Factorial {

  private static final int TEST_VAL = 50;
  private static final IntFunction<Long> RECURSIVE_FACTORIAL = Factorial::recursiveFactorial;

  // just to illustrate, not performant for this case
  private static final IntFunction<Long> ITERATIVE_FACTORIAL =
      (n) -> {
        Deque<Integer> queue = new ArrayDeque<>(IntStream.rangeClosed(0, n).boxed().toList());
        long result = 0;
        while (!queue.isEmpty()) {
          int current = queue.poll();
          result = current == 0 ? 1 : current * result;
        }
        return result;
      };

  private int value;

  // Benchmark methods

  @Setup
  public void setUp() {
    value = TEST_VAL;
  }

  @Benchmark
  public void recursiveFactorialBenchMarked() {
    RECURSIVE_FACTORIAL.apply(value);
  }

  @Benchmark
  public void iterativeFactorialBenchMarked() {
    ITERATIVE_FACTORIAL.apply(value);
  }

  public static long recursiveFactorial(int n) {
    return n == 0 ? 1 : (n * recursiveFactorial(n - 1));
  }

  private static void measuredFunction(
      IntFunction<Long> factorialFunction, Integer value, String message) {
    Instant start = Instant.now();
    System.out.printf((message) + "%n", factorialFunction.apply(value));
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("elapsed -> " + timeElapsed);
  }

  public static void main(String[] args) throws RunnerException {
    measuredFunction(RECURSIVE_FACTORIAL, TEST_VAL, "recursive: %s");
    measuredFunction(ITERATIVE_FACTORIAL, TEST_VAL, "iterative: %s");
    // measures
    Options options =
        new OptionsBuilder()
            .include(Factorial.class.getSimpleName())
            .forks(1)
            .warmupIterations(5)
            .measurementIterations(10)
            .build();

    new Runner(options).run();
  }
}
