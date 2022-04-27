package com.gsdd.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCake {

  // Complete the birthdayCakeCandles function below.
  static int birthdayCakeCandles(int[] ar) {
    int max = Arrays.stream(ar).max().getAsInt();
    return (int) Arrays.stream(ar).filter(i -> i == max).count();
  }

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arCount = SCANNER.nextInt();
    SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[arCount];

    String[] arItems = SCANNER.nextLine().split(" ");
    SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < arCount; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = birthdayCakeCandles(ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    SCANNER.close();
  }
}
