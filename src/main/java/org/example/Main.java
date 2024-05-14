package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private static void maxValueInt() {
        out.printf("Int max = %d\n", Integer.MAX_VALUE);
    }

    private static void minValueInt() {
        out.printf("Int min = %d\n", Integer.MIN_VALUE);
    }

    private static void maxValueLong() {
        out.printf("Long max = %d\n", Long.MAX_VALUE);
    }

    private static void minValueLong() {
        out.printf("Long min = %d\n", Long.MIN_VALUE);
    }

    private static void maxValueFloat() {
        out.println("Float max = " + (Float.MAX_VALUE));
    }

    private static void minValueFloat() {
        out.println("Float min = " + (-Float.MAX_VALUE - 1));
    }

    private static void maxValueDouble() {
        out.println("Double max = " + (Double.MAX_VALUE));
    }

    private static void minValueDouble() {
        out.println("Double max = " + (-Double.MAX_VALUE - 1));
    }

    private static void minValueChar() {
        out.println("Char min = " + (int) (Character.MIN_VALUE));
    }

    private static void maxValueChar() {
        out.println("Char max = " + (int) (Character.MAX_VALUE));
    }

    private static void sizeBoolean() {
        out.println("In Java, boolean is a separate variable. " +
                "This is not an analogue of 1 or 0, as, for example, in JavaScript and PHP.");
        out.println("Example boolean variables: " + Boolean.FALSE + " and " + Boolean.TRUE);
    }

    private static void maxValueByte() {
        out.println("Byte max = " + (Byte.MAX_VALUE));
    }

    private static void minValueByte() {
        out.println("Byte min = " + (Byte.MIN_VALUE));
    }

    private static void maxValueShort() {
        out.println("Short max = " + (Short.MAX_VALUE));
    }

    private static void minValueShort() {
        out.println("Short min = " + (Short.MIN_VALUE));
    }

    private static void sizeString() {
        out.println("String length from 0 to " + Integer.MAX_VALUE + " characters");
    }

    private static void sizeArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 6, 8};
        out.println("Elements in Array can be stored in a list or set at most " + Integer.MAX_VALUE);
        out.println("Array example: " + Arrays.toString(array));
        out.println("Array length: " + array.length);
    }

    private static void maxMinValuesForPrimitives() {
        minValueChar();
        maxValueChar();
        sizeBoolean();
        minValueByte();
        maxValueByte();
        minValueShort();
        maxValueShort();
        minValueInt();
        maxValueInt();
        minValueLong();
        maxValueLong();
        minValueFloat();
        maxValueFloat();
        minValueDouble();
        maxValueDouble();
        sizeString();
        sizeArray();
    }

    private static void maxMinForInputsValues() {
        int numb1 = 0;
        boolean checkInt = false;
        out.print("Enter the first integer: ");
        while (!checkInt) {
            try {
                numb1 = Integer.parseInt(reader.readLine());
                checkInt = true;
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the first integer: ");
            }
        }
        int numb2 = 0;
        out.print("Enter the second integer: ");
        checkInt = false;
        while (!checkInt) {
            try {
                numb2 = Integer.parseInt(reader.readLine());
                checkInt = true;
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the second integer: ");
            }
        }
        if (numb1 > numb2) {
            out.printf("The first number is greater than the second: %d > %d", numb1, numb2);
        } else if (numb1 < numb2) {
            out.printf("The second number is greater than the first: %d > %d", numb2, numb1);
        } else {
            out.printf("The second number is equals the first: %d = %d", numb1, numb2);
        }
    }

    private static boolean isPrime(int number) {
        int j;
        boolean isPrime;
        isPrime = true;
        // проверить, делится ли число без остатка
        for (j = 2; j <= number / j; j++) {
            if ((number % j) == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    private static void primeNumbersFromInterval() {
        int a = -1;
        int b = -1;

        do {
            out.print("Enter the first integer: ");
            try {
                a = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the first integer: ");
            }
        } while (a < 0);
        do {
            out.print("Enter the second integer: ");
            try {
                b = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the second integer: ");
            }
        } while (b < a);
        out.println("Result:");
        for (var i = 1; i <= b; i += 2) {
            if (isPrime(i) && i >= a) {
                out.printf("%d ", i);
            }
        }
    }

    private static void menuSelectTasks() {
        out.println("1. Print variables to the console (maximum and minimum values for primitives). \n" +
                "Expected variables are char, boolean, byte, short, int, long, float, double, String, Array.");
        out.println("2. A console application that will accept any 2 numbers and show which one is larger.");
        out.println("3. Prime numbers from the interval.");
        int numb = 0;
        do {
            out.print("Enter task number 1-6: ");
            try {
                numb = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.print("Enter task number 1-6: ");
            }
        } while (numb < 1 || numb > 6);

        switch (numb) {
            case 1 -> maxMinValuesForPrimitives();
            case 2 -> maxMinForInputsValues();
            case 3 -> primeNumbersFromInterval();
            default -> out.println("Oops, something wrong !");
        }
    }

    public static void main(String[] args) {
        menuSelectTasks();
    }
}
