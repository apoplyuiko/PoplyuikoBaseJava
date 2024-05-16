package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

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
        subMenu(1);
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
            out.printf("\nThe first number is greater than the second: %d > %d", numb1, numb2);
        } else if (numb1 < numb2) {
            out.printf("\nThe second number is greater than the first: %d > %d", numb2, numb1);
        } else {
            out.printf("\nThe second number is equals the first: %d = %d", numb1, numb2);
        }
        subMenu(2);
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
        subMenu(3);
    }

    private static int selectFromRange(int b) {
        int numb = 0;
        do {
            out.printf("\nEnter task number %d-%d: ", 0, b);
            try {
                numb = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.printf("\nEnter task number %d-%d: ", 0, b);
            }
        } while (numb < 0 || numb > b);
        return numb;
    }

    private static void fillYouCart() {
        List<String> list = new ArrayList<>();
        while (true) {
            out.println("\n0. Call menu");
            out.println("1. Show cart");
            out.println("2. Add product to cart");
            out.println("3. Empty cart");
            var numb = selectFromRange(3);
            switch (numb) {
                case 0 -> subMenu(4);
                case 1 -> showCart(list);
                case 2 -> addProductToCart(list);
                default -> list.clear();
            }
        }
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

    private static void subMenu(int i) {
        out.println("\n0. Exit.");
        out.println("1. Return to main menu.");
        out.println("2. Repeat the operation.");
        var numb = selectFromRange(2);

        switch (numb) {
            case 0 -> exit(0);
            case 1 -> menuSelectTasks();
            case 2 -> {
                switch (i) {
                    case 0 -> exit(0);
                    case 1 -> maxMinValuesForPrimitives();
                    case 2 -> maxMinForInputsValues();
                    case 3 -> primeNumbersFromInterval();
                    case 4 -> fillYouCart();
                    default -> out.println("Oops, something wrong !");
                }
            }
            default -> out.println("Oops, something wrong !");
        }
    }

    private static void menuSelectTasks() {
        out.println("\n0. Exit.");
        out.println("1. Print variables to the console (maximum and minimum values for primitives). \n" +
                "Expected variables are char, boolean, byte, short, int, long, float, double, String, Array.");
        out.println("2. A console application that will accept any 2 numbers and show which one is larger.");
        out.println("3. Prime numbers from the interval.");
        out.println("4. Shopping basket.");
        var numb = selectFromRange(4);
        switch (numb) {
            case 0 -> exit(0);
            case 1 -> maxMinValuesForPrimitives();
            case 2 -> maxMinForInputsValues();
            case 3 -> primeNumbersFromInterval();
            case 4 -> fillYouCart();
            default -> out.println("Oops, something wrong !");
        }
    }

    private static void passwordRequest() {
        String password = "Dunice!";
        String readPassword = "";
        while (true) {
            out.println("Enter password!");
            try {
                readPassword = reader.readLine();
            } catch (IOException e) {
                out.println("Password is not correct!");
            }
            if (password.equals(readPassword)) {
                out.println("Password entered");
                break;
            }
            out.println("Password is not correct!");
        }
    }

    public static void main(String[] args) {
        passwordRequest();
        menuSelectTasks();
    }
}
