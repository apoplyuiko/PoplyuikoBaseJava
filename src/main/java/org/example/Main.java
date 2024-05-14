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

    static BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    static int n = 9;

    static int[] countProduct = new int[n];

    static String[] basket = new String[n];

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
            out.printf("The first number is greater than the second: %d > %d", numb1, numb2);
        } else if (numb1 < numb2) {
            out.printf("The second number is greater than the first: %d > %d", numb2, numb1);
        } else {
            out.printf("The second number is equals the first: %d = %d", numb1, numb2);
        }
        subMenu(2);
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
        subMenu(3);
    }

    private static void printProducts() {
        out.println();
        out.println("product list (To select, enter the product number):");
        for (int i = 0; i < n; i++) {
            var str = countProduct[i] <= 0 ? "" : " (" + countProduct[i] + ")";
            var temp = ((i + 1) % 3 != 0) ? " " : "\n";
            out.print((i + 1) + "." + basket[i] + str + temp);
        }
    }

    private static int selectFromRange(int a, int b) {
        int numb = 0;
        do {
            out.printf("Enter task number %d-%d: ", a, b);
            try {
                numb = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.printf("Enter task number %d-%d: ", a, b);
            }
        } while (numb < a || numb > b);
        return numb;
    }

    private static void shoppingBasket() {
        var numberProduct = 0;
        do {
            printProducts();
            out.println("0. call menu");
            numberProduct = selectFromRange(0, n);
            numberProduct--;
            if (numberProduct == -1) {
                subMenu(4);
            }
            var temp = countProduct[numberProduct] <= 0 ? "" : "3. Remove from cart\n";
            out.println("1. Add to Basket\n2. To the selection of goods\n" + temp);
            var b = countProduct[numberProduct] <= 0 ? 2 : 3;
            var actionNumber = selectFromRange(1, b);
            if (actionNumber == 1) {
                var count = selectFromRange(1, 100);
                countProduct[numberProduct] = count;
            } else if (actionNumber == 3) {
                countProduct[numberProduct] = 0;
            }
        } while (numberProduct >= 1);
    }

    private static void shopping() {
        List<String> list = new ArrayList<>();
        int numb = -1;
        while (numb != 0) {
            out.println();
            out.println("0. Call menu");
            out.println("1. Show cart");
            out.println("2. Add product to cart");
            out.println("3. Empty cart");
            numb = selectFromRange(0, 3);
            if (numb == 0) {
                subMenu(4);
            } else if (numb == 1) {
                showCart(list);
            } else if (numb == 2) {
                addProductToCart(list);
            } else if (numb == 3) {
                list.clear();
            }
        }
    }

    private static void addProductToCart(List<String> list) {
        out.println("The product's name:");
        String product;
        try {
            product = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list.add(product);
    }

    private static void showCart(List<String> list) {
        out.println();
        if (list.size() == 0) {
            out.println("Cart is empty");
        } else {
            out.print("Products name:\n");
            for (String item : list) {
                out.println(item);
            }
        }
    }

    private static void initBasket() {
        Arrays.fill(countProduct, 0);
        for (int j = 0; j < n; j++) {
            basket[j] = "Product " + (j + 1);
        }
    }

    private static void subMenu(int i) {
        out.println();
        out.println("0. Exit.");
        out.println("1. Return to main menu.");
        out.println("2. Repeat the operation.");
        var numb = selectFromRange(0, 2);

        switch (numb) {
            case 0 -> exit(0);
            case 1 -> menuSelectTasks(-1);
            case 2 -> menuSelectTasks(i);
            default -> out.println("Oops, something wrong !");
        }
    }

    private static void menuSelectTasks(int i) {
        int numb = i;
        if (numb == -1) {
            out.println();
            out.println("0. Exit.");
            out.println("1. Print variables to the console (maximum and minimum values for primitives). \n" +
                    "Expected variables are char, boolean, byte, short, int, long, float, double, String, Array.");
            out.println("2. A console application that will accept any 2 numbers and show which one is larger.");
            out.println("3. Prime numbers from the interval.");
            out.println("4. Shopping basket.");
            out.println("5. Shopping basket - with collection.");
            numb = selectFromRange(0, 5);
        }
        switch (numb) {
            case 0 -> exit(0);
            case 1 -> maxMinValuesForPrimitives();
            case 2 -> maxMinForInputsValues();
            case 3 -> primeNumbersFromInterval();
            case 4 -> {
                initBasket();
                shoppingBasket();
            }
            case 5 -> shopping();

            default -> out.println("Oops, something wrong !");
        }
    }

    public static void main(String[] args) {
        menuSelectTasks(-1);
    }
}
