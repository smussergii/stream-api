package com.solvd.streams;

import java.util.Arrays;

/**
 * Task 4.
 * A positive integer K and a sequence of non-empty strings stringList are given. Strings of the sequence contain
 * only numbers and capital letters of the Latin alphabet. Get from stringList all strings of length K ending in
 * a digit and sort them in ascending order. For example:
 * input: number = 2, {"8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B"}
 * output: {"A1", "S3"}
 */
public class Task04 {

    public static void main(String[] args) {
        String[] inputArr = new String[]{"8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B"};
        Arrays.stream(processArrayWithRegex(inputArr, 2)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayWithCharacterClass(inputArr, 2)).forEach(System.out::println);
    }

    public static String[] processArrayWithRegex(String[] inputArr, int givenStringLength) {
        return Arrays.stream(inputArr)
                .filter(inputString -> inputString.length() == givenStringLength
                        && String.valueOf(inputString.charAt(inputString.length() - 1)).matches("\\d"))
                .sorted()
                .toArray(String[]::new);
    }

    public static String[] processArrayWithCharacterClass(String[] inputArr, int givenStringLength) {
        return Arrays.stream(inputArr)
                .filter(inputString -> inputString.length() == givenStringLength
                        && Character.isDigit(inputString.charAt(inputString.length() - 1)))
                .sorted()
                .toArray(String[]::new);
    }
}
