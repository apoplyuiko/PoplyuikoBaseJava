package org.example.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

public class Task1 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private static void maxMinValuesForPrimitives() {
        out.println("Char min = " + (int) (Character.MIN_VALUE));
        out.println("Char max = " + (int) (Character.MAX_VALUE));
        out.println("In Java, boolean is a separate variable. " +
                "This is not an analogue of 1 or 0, as, for example, in JavaScript and PHP.");
        out.println("Example boolean variables: " + Boolean.FALSE + " and " + Boolean.TRUE);
        out.println("Byte min = " + (Byte.MIN_VALUE));
        out.println("Byte max = " + (Byte.MAX_VALUE));
        out.println("Short min = " + (Short.MIN_VALUE));
        out.println("Short max = " + (Short.MAX_VALUE));
        out.printf("Int max = %d\n", Integer.MAX_VALUE);
        out.printf("Int min = %d\n", Integer.MIN_VALUE);
        out.printf("Long min = %d\n", Long.MIN_VALUE);
        out.printf("Long max = %d\n", Long.MAX_VALUE);
        out.println("Float min = " + (-Float.MAX_VALUE - 1));
        out.println("Float max = " + (Float.MAX_VALUE));
        out.println("Double max = " + (-Double.MAX_VALUE - 1));
        out.println("Double max = " + (Double.MAX_VALUE));
        out.println("String length from 0 to " + Integer.MAX_VALUE + " characters");
        int[] array = {1, 2, 3, 4, 5, 6, 6, 8};
        out.println("Elements in Array can be stored in a list or set at most " + Integer.MAX_VALUE);
        out.println("Array example: " + Arrays.toString(array));
        out.println("Array length: " + array.length);
        menuSelectTasks();
    }

    private static void maxMinForInputsValues() {
        int firstNumber;
        out.print("Enter the first integer: ");
        while (true) {
            try {
                firstNumber = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the first integer: ");
            }
        }
        int secondNumber;
        out.print("Enter the second integer: ");
        while (true) {
            try {
                secondNumber = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the second integer: ");
            }
        }
        if (firstNumber > secondNumber) {
            out.printf("\nThe first number is greater than the second: %d > %d", firstNumber, secondNumber);
        } else if (firstNumber < secondNumber) {
            out.printf("\nThe second number is greater than the first: %d > %d", secondNumber, firstNumber);
        } else {
            out.printf("\nThe second number is equals the first: %d = %d", firstNumber, secondNumber);
        }
        menuSelectTasks();
    }

    private static boolean isPrime(int number) {
        int j;
        boolean isPrime;
        isPrime = true;
        for (j = 2; j <= number / j; j++) {
            if ((number % j) == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    private static void primeNumbersFromInterval() {
        int a = 0;
        int b = 0;

        do {
            out.print("Enter the first integer: ");
            try {
                a = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.print("Enter the first integer: ");
            }
        } while (a <= 0);
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
        menuSelectTasks();
    }

    private static int selectFromRange() {
        int selectItem;
        do {
            out.print("\nEnter task number: ");
            try {
                selectItem = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                out.print("\nEnter task number: ");
            }
        } while (true);
        return selectItem;
    }

    private static void fillYouCart() {
        List<String> list = new ArrayList<>();
        do {
            out.println("\n0. Call menu");
            out.println("1. Show cart");
            out.println("2. Add product to cart");
            out.println("3. Clear cart");
            var selectItem = selectFromRange();
            switch (selectItem) {
                case 0 -> menuSelectTasks();
                case 1 -> showCart(list);
                case 2 -> addProductToCart(list);
                case 3 -> list.clear();
                default -> out.println("Oops, something wrong !");
            }
            if (selectItem == 0) {
                break;
            }
        } while (true);
    }

    private static void addProductToCart(List<String> list) {
        out.println("The product's name:");
        String product;
        do {
            try {
                product = reader.readLine();
                list.add(product);
                break;
            } catch (IOException e) {
                out.print("Enter the product name without special characters!\n");
            }
        } while (true);
    }

    private static void showCart(List<String> list) {
        if (list.isEmpty()) {
            out.println("\nCart is empty");
        } else {
            out.print("\nProducts name:\n");
            for (String item : list) {
                out.println(item);
            }
        }
    }

    private static void menuSelectTasks() {
        out.println("\n0. Exit.");
        out.println("1. Print variables to the console (maximum and minimum values for primitives). \n" +
                "Expected variables are char, boolean, byte, short, int, long, float, double, String, Array.");
        out.println("2. A console application that will accept any 2 numbers and show which one is larger.");
        out.println("3. Prime numbers from the interval.");
        out.println("4. Shopping basket.");
        var selectItem = selectFromRange();
        switch (selectItem) {
            case 0 -> exit(0);
            case 1 -> maxMinValuesForPrimitives();
            case 2 -> maxMinForInputsValues();
            case 3 -> primeNumbersFromInterval();
            case 4 -> fillYouCart();
            default -> out.println("Oops, something wrong !");
        }
    }

    private static void passwordRequest() {
        String password = "";
        String readPassword = "";
        while (true) {
            if (password.isEmpty()) {
                out.println("Create a password!");
            } else {
                out.println("Enter a password:");
            }
            try {
                if (password.isEmpty()) {
                    password = reader.readLine();
                } else {
                    readPassword = reader.readLine();
                }
            } catch (IOException e) {
                out.println("Password is not correct!");
            }
            if (!readPassword.isEmpty()) {
                if (password.equals(readPassword)) {
                    out.println("Password entered");
                    break;
                }
                out.println("Password is not correct!");
            }
        }
    }

    public static void main(String[] args) {
        passwordRequest();
        menuSelectTasks();
    }
}
