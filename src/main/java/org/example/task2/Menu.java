package org.example.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class Menu {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private static int requestConsole(String s) {
        int count;
        do {
            out.print(s);
            try {
                count = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                out.print(s);
            }
        } while (true);
        return count;
    }

    private static MenuItems choiceItem(int endInterval, MenuItems[] menu) {
        int selectItem = requestConsole("\nEnter item number 0-" + endInterval + ": ");
        return menu[selectItem];
    }

    public static MenuItems showMenu(boolean statusPower) {
        MenuItems[] menu = MenuItems.values();
        int countItem = 0;
        out.print("\n");
        for (MenuItems item : menu) {
            if (countItem == 2 && !statusPower) {
                break;
            }
            if (countItem == 2) {
                out.print("Service:\n");
            }
            if (countItem == 4) {
                out.print("Add ingredients:\n");
            }
            if (countItem == 7) {
                out.print("Prepare:\n");
            }
            if (countItem == 16) {
                out.print("Show recipe:\n");
            }
            out.printf("%d) " + item.text + "\n", countItem);
            countItem++;
        }
        out.print("\n");
        return choiceItem(countItem - 1, menu);
    }
}

