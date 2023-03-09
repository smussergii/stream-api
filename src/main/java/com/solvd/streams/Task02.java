package com.solvd.streams;

import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * Task
 * Write functional programming lambda expressions using Java 8 streams. Each task must be solved with one
 * lambda expressions. Put lambda expressions in the return statement1.
 * At the Low level, you need to solve the following tasks:
 * Task 2.
 * A sequence of non-empty strings stringList is given. Get a sequence of ascending sorted integer values equal to the lengths of the strings included in the stringList sequence. For example:
 * input: {"Hello", "world", "!", "Good", "morning", "!"}
 * output: {1, 1, 4, 5, 5, 7}
 */
public class Task02 {

    public static void main(String[] args) {
        String[] inputArr = new String[]{"Hello", "world", "!", "Good", "morning", "!"};

        Arrays.stream(processArrayWithExternalLambda(inputArr)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayWithoutExternalLambda(inputArr)).forEach(System.out::println);
    }

    public static int[] processArrayWithExternalLambda(String[] inputArr) {
        return Arrays.stream(inputArr)
                .mapToInt(input -> getFunction().applyAsInt(input))
                .sorted()
                .toArray();
    }

    public static ToIntFunction<String> getFunction() {
        return input -> input.length();
    }

    public static int[] processArrayWithoutExternalLambda(String[] inputArr) {
        return Arrays.stream(inputArr)
                .mapToInt(String::length)
                .sorted()
                .toArray();
    }
}
