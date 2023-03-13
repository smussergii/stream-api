package com.solvd.streams;

import java.util.Arrays;

/**
 * Task 3.
 * A sequence of non-empty strings stringList is given. Get a new sequence of strings,
 * where each string consists of the first and last characters of the corresponding string in the stringList sequence.
 * For example:
 * input: {"asd", "a", "basdw"}
 * output: {"ad", "aa", "bw"}
 */
public class Task03 {

    public static void main(String[] args) {
        String[] inputArr = new String[]{"asd", "a", "basdw"};
        Arrays.stream(processArrayWithStringBuilder(inputArr)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayWithCharArray(inputArr)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayWithStringClass(inputArr)).forEach(System.out::println);
    }

    public static String[] processArrayWithStringBuilder(String[] inputArr) {
        return Arrays.stream(inputArr)
                .map(inputString -> new StringBuilder().append(inputString.charAt(0)).append(inputString.charAt(inputString.length() - 1)).toString())
                .toArray(String[]::new);
    }

    public static String[] processArrayWithCharArray(String[] inputArr) {
        return Arrays.stream(inputArr)
                .map(inputString -> String.valueOf(new char[]{inputString.charAt(0), inputString.charAt(inputString.length() - 1)}))
                .toArray(String[]::new);
    }

    public static String[] processArrayWithStringClass(String[] inputArr) {
        return Arrays.stream(inputArr)
                .map(inputString -> String.valueOf(inputString.charAt(0)) + inputString.charAt(inputString.length() - 1))
                .toArray(String[]::new);
    }
}
