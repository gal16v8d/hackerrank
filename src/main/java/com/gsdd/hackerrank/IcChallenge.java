package com.gsdd.hackerrank;

import java.util.Arrays;
import java.util.stream.Collectors;

//@formatter:off
/*
 * Write a program that parses a sentence and replaces each word with the
 * following: 
 * 
 * <p>
 * 1) The first letter of the word 
 * 2) The number of distinct characters between first and last character 
 * 3) The last letter of the word.
 * </p>
 * 
 * For example, Smooth would become S3h. Words are separated by spaces or
 * non-alphabetic characters and these separators should be maintained in their
 * original form and location in the answer. A few of the things we will be
 * looking at is accuracy, efficiency, solution completeness.
 */
//@formatter:on
public class IcChallenge {
  
  private static String convert(String input) {
    StringBuilder wordOutput = new StringBuilder();
    String[] splitTempWord = input.split("[^a-zA-Z]+");
    String newWord = splitTempWord[0];
    int last = newWord.length() - 1;
    String tempWord = newWord.substring(1, last);
    wordOutput.append(input.charAt(0));
    long middlePart = tempWord.chars().distinct().count();
    wordOutput.append(middlePart == 0 ? "" : middlePart);
    wordOutput.append(input.substring(input.indexOf(newWord) + last));
    return wordOutput.toString();
  }

  public static String wordParser(String input) {
    String[] words = input.split(" ");
    return Arrays.stream(words).map(IcChallenge::convert).collect(Collectors.joining(" "));
  }

  public static void main(String[] args) {
    String output =
        wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
    System.out.println(output);
    // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
  }
}
