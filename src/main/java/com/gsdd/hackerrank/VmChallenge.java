package com.gsdd.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;

/*
 * Please write code that will convert the string input to the list of elements.
 * The input string consists of elements or element range. The separator of
 * elements or ranges is comma. Range is defined as follows: a start number;
 * dash; end number.
 * 
 * Ex: "1, 2, 3" -> [1, 2, 3] "2-6" -> [2, 3, 4, 5, 6] "1, 3-5, 9" -> [1, 3, 4,
 * 5, 9]
 */
@UtilityClass
public class VmChallenge {

  private static final String OUT_FORMAT = "Input: %s | Output: %s";
  private static final List<String> TEST_DATA = List.of("1, 2, 3", "2-6", "1, 3-5, 9");

  public static List<Integer> convertFromInput(String input) {
    List<Integer> finalDataList = new ArrayList<>();
    String[] data = input.split(", ");
    for (String element : data) {
      if (element.contains("-")) {
        String[] dashElements = element.split("-");
        List<Integer> rangeData = IntStream
            .rangeClosed(Integer.parseInt(dashElements[0]), Integer.parseInt(dashElements[1]))
            .boxed()
            .toList();
        finalDataList.addAll(rangeData);
      } else {
        finalDataList.add(Integer.parseInt(element));
      }
    }
    return finalDataList;
  }

  public static void main(String[] args) {
    for (String input : TEST_DATA) {
      List<Integer> finalDataList = convertFromInput(input);
      System.out.println(OUT_FORMAT.formatted(input, finalDataList.toString()));
    }
  }
}
