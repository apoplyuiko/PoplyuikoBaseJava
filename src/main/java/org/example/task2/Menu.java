package org.example.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public enum Menu {
    exit(true, "Exit"),
    powerOn(true, "Power-On"),
    powerOff(false, "Power-Off"),
    addWater(false, "Add water"),
    addCoffee(false, "Add coffee"),
    addMilk(false, "Add milk"),
    clearMachine(false, "Clear machine"),
    numberOfBrews(false, "Number of brews"),
    checkIngredients(false, "Check ingredients");

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    public boolean visibility;

    public final String text;

    Menu(boolean visibility, String text) {
        this.visibility = visibility;
        this.text = text;
    }

    static void setVisibilityPowerOff() {
        exit.visibility = true;
        powerOn.visibility = true;
        powerOff.visibility = false;
        addWater.visibility = false;
        addCoffee.visibility = false;
        addMilk.visibility = false;
        clearMachine.visibility = false;
        numberOfBrews.visibility = false;
        checkIngredients.visibility = false;
    }

    static void setVisibilityPowerOn() {
        exit.visibility = true;
        powerOn.visibility = false;
        powerOff.visibility = true;
        addWater.visibility = true;
        addCoffee.visibility = true;
        addMilk.visibility = true;
        clearMachine.visibility = true;
        numberOfBrews.visibility = true;
        checkIngredients.visibility = true;
    }

    private static int selectFromRange(int endInterval) {
        int selectItem = 0;
        do {
            out.printf("\nEnter item number %d-%d: ", 0, endInterval);
            try {
                selectItem = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                out.printf("\nEnter item number %d-%d: ", 0, endInterval);
            }
        } while (selectItem < 0 || selectItem > endInterval);
        return selectItem;
    }

    static int showMenu() {
        Menu[] menu = values();
        int countItem = 0;
        for (Menu item : menu) {
            if (item.visibility) {
                out.printf("%d. " + item.text + "\t", countItem);
                countItem++;
            }
        }
        return selectFromRange(countItem - 1);
    }
}
