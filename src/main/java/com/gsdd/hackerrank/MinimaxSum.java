package com.gsdd.hackerrank;

import java.util.Scanner;

public class MinimaxSum {

  // Complete the miniMaxSum function below.
  static void miniMaxSum(int[] arr) {
    long aux = 0;
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (j != i) {
          aux = aux + arr[j];
        }
      }
      if (aux > max) {
        max = aux;
      }
      if (aux < min) {
        min = aux;
      }
      aux = 0;
    }
    System.out.print(min + " " + max);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int[] arr = new int[5];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < 5; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    miniMaxSum(arr);

    scanner.close();
  }
}
