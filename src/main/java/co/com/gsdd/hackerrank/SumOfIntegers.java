package co.com.gsdd.hackerrank;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfIntegers {

    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Enter the quantity of inputs: ");
            int howManyInputs = userInput.nextInt();
            userInput.nextLine();
            System.out.println("Enter the numbers separated by spaces: ");
            String numericInputs = userInput.nextLine();
            List<String> listOfValues = Stream.of(numericInputs.split("\\s")).collect(Collectors.toList());
            if (listOfValues.size() != howManyInputs) {
                throw new IllegalArgumentException("You must enter only " + howManyInputs + " elements");
            } else {
                int sum = 0;
                for (String value : listOfValues) {
                    sum += Integer.parseInt(value);
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            System.err.println("Please check your input and try again");
            e.printStackTrace();
        }
    }
}
