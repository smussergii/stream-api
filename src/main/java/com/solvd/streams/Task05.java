package com.solvd.streams;

import java.util.Arrays;

/**
 * Task 5.
 * A sequence of positive integer values integerList is given. Get sequence of string representations
 * of only odd integerList values and sort in ascending order. For example:
 * input: {1, 2, 3, 4, 5, 6}
 * output: {"1", "3", "5"}
 */
public class Task05 {

    public static void main(String[] args) {
        int[] inputArr = new int[]{1, 2, 3, 4, 5, 6, 15, 9, 7};
        Arrays.stream(processArrayUsingRemainderOperator(inputArr)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayUsingBitwiseANDOperator(inputArr)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayUsingBitwiseOROperator(inputArr)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayUsingBitwiseXOROperator(inputArr)).forEach(System.out::println);
    }

    public static String[] processArrayUsingRemainderOperator(int[] inputArr) {
        return Arrays.stream(inputArr)
                .filter(inputValue -> inputValue % 2 == 1)
                .mapToObj(String::valueOf)
                .sorted()
                .toArray(String[]::new);
    }

    public static String[] processArrayUsingBitwiseANDOperator(int[] inputArr) {
        return Arrays.stream(inputArr)
                .filter(inputValue -> (inputValue & 1) == 1)
                .mapToObj(String::valueOf)
                .sorted()
                .toArray(String[]::new);
    }

    public static String[] processArrayUsingBitwiseOROperator(int[] inputArr) {
        return Arrays.stream(inputArr)
                .filter(inputValue -> (inputValue | 1) == inputValue)
                .mapToObj(String::valueOf)
                .sorted()
                .toArray(String[]::new);
    }

    public static String[] processArrayUsingBitwiseXOROperator(int[] inputArr) {
        return Arrays.stream(inputArr)
                .filter(inputValue -> (inputValue ^ 1) < inputValue)
                .mapToObj(String::valueOf)
                .sorted()
                .toArray(String[]::new);
    }
}
