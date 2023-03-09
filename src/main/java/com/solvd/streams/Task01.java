package com.solvd.streams;

import java.util.Arrays;
import java.util.function.BiPredicate;

/**
 * Task
 * Write functional programming lambda expressions using Java 8 streams. Each task must be solved with one
 * lambda expressions. Put lambda expressions in the return statement1.
 * At the Low level, you need to solve the following tasks:
 * Task 1.
 * The character C and a sequence of non-empty strings stringList are given. Get a new sequence of strings
 * with more than one character from the stringList, starting and ending with C. For example:
 * input: Symbol = 'a', {"Hello", "qwerty", "asda", "asdfa", "as", "a"}
 * output: {"asda", "asdfa"}
 */
public class Task01 {

    public static void main(String[] args) {
        String[] inputArr = new String[]{"Hello", "qwerty", "asda", "asdfa", "as", "a", "hdgyh", "hh", "mam"};
        Arrays.stream(processArrayWithExternalLambda(inputArr, 'a')).forEach(System.out::println);
        System.out.println();
        Arrays.stream(processArrayWithoutExternalLambda(inputArr, 'h')).forEach(System.out::println);
    }

    public static String[] processArrayWithExternalLambda(String[] inputArr, char givenChar) {
        return Arrays.stream(inputArr)
                .filter(inputString -> getPredicate().test(inputString, givenChar))
                .toArray(String[]::new);
    }

    public static BiPredicate<String, Character> getPredicate() {
        return (input, ch) -> input.length() > 1
                && input.charAt(0) == ch
                && input.charAt(input.length() - 1) == ch;
    }

    public static String[] processArrayWithoutExternalLambda(String[] inputArr, char givenChar) {
        return Arrays.stream(inputArr)
                .filter(inputString -> inputString.length() > 1
                        && inputString.charAt(0) == givenChar
                        && inputString.charAt(inputString.length() - 1) == givenChar)
                .toArray(String[]::new);
    }
}
