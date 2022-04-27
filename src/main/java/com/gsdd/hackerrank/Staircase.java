package com.gsdd.hackerrank;

import java.util.Scanner;

public class Staircase {

  // Complete the staircase function below.
  static void staircase(int n) {
    for (int i = 1; i <= n; i++) {
      StringBuilder sb = new StringBuilder(n);
      System.out.println(sb.replace(n - 2, n - 1, "#"));
    }

  }

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    int n = SCANNER.nextInt();
    SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    staircase(n);

    SCANNER.close();
  }
}
