package org.example.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;
import static org.example.task2.MenuItems.addCoffee;
import static org.example.task2.MenuItems.addMilk;
import static org.example.task2.MenuItems.addWater;
import static org.example.task2.MenuItems.clearMachine;
import static org.example.task2.MenuItems.createProfile;
import static org.example.task2.MenuItems.exit;
import static org.example.task2.MenuItems.numberOfBrews;
import static org.example.task2.MenuItems.powerOn;
import static org.example.task2.MenuItems.prepareAmericano;
import static org.example.task2.MenuItems.prepareCappuccino;
import static org.example.task2.MenuItems.prepareEspresso;
import static org.example.task2.MenuItems.showAmericano;
import static org.example.task2.MenuItems.showCappuccino;
import static org.example.task2.MenuItems.showEspresso;
import static org.example.task2.MenuItems.showLog;
import static org.example.task2.MenuItems.values;
import static org.example.task2.Recipes.AMERICANO;
import static org.example.task2.Recipes.CAPPUCCINO;
import static org.example.task2.Recipes.ESPRESSO;

public class CoffeeMachine {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private static boolean powerStatus;

    private static List<String> log = new ArrayList<>();

    private List<Profiles> profiles = new ArrayList<>();

    private int menuLength;

    private int maxLevel;

    private boolean statusWaste;

    private int maxPrepared;

    private int milk;

    private int coffee;

    private int water;

    private int countPrepared;

    private int countPrepareCappuccino;

    private int countPrepareAmericano;

    private int countPrepareEspresso;

    CoffeeMachine() {
        powerStatus = false;
        water = 92;
        coffee = 93;
        milk = 99;
        setMaxLevel(100);
        setStatusWaste(false);
        setMaxPrepared(10);
        setCountPrepared(0);
        setCountPrepareAmericano(0);
        setCountPrepareCappuccino(0);
        setCountPrepareEspresso(0);
        setMenuLength(0);
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public boolean getStatus() {
        if (!powerStatus) {
            out.print("Please, before starting work, turn me on.\n");
        }
        return powerStatus;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public boolean getStatusWaste() {
        return statusWaste;
    }

    public int getMaxPrepared() {
        return maxPrepared;
    }

    public int getCountPrepared() {
        return countPrepared;
    }

    public int getCountPrepareEspresso() {
        return countPrepareEspresso;
    }

    public int getCountPrepareAmericano() {
        return countPrepareAmericano;
    }

    public int getCountPrepareCappuccino() {
        return countPrepareCappuccino;
    }

    public List<Profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profiles> input) {
        profiles = input;
    }

    public int getMenuLength() {
        return menuLength;
    }

    public void setMenuLength(int menuLength) {
        this.menuLength = menuLength;
    }

    public static void setLog(List<String> input) {
        log = input;
    }

    public void setCountPrepareEspresso(int countPrepareEspresso) {
        this.countPrepareEspresso = countPrepareEspresso;
    }

    public void setCountPrepareAmericano(int countPrepareAmericano) {
        this.countPrepareAmericano = countPrepareAmericano;
    }

    public void setCountPrepareCappuccino(int countPrepareCappuccino) {
        this.countPrepareCappuccino = countPrepareCappuccino;
    }

    public void setMaxLevel(int vol) {
        maxLevel = vol;
    }

    public void setStatusWaste(boolean vol) {
        statusWaste = vol;
    }

    public void setMaxPrepared(int vol) {
        maxPrepared = vol;
    }

    public void setCountPrepared(int vol) {
        countPrepared = vol;
    }

    public void setWater(int water) {
        if (water <= getMaxLevel() && water >= 0) {
            this.water = water;
        } else if (water < 0) {
            out.print("\tNot enough WATER");
        } else {
            out.print("\tOh. Too much!!");
        }
    }

    public void setCoffee(int coffee) {
        if (coffee <= maxLevel && coffee >= 0) {
            this.coffee = coffee;
        } else if (water < 0) {
            out.print("\ttNot enough COFFEE");
        } else {
            out.print("\tOh. Too much!!");
        }
    }

    public void setMilk(int milk) {
        if (milk <= maxLevel && milk >= 0) {
            this.milk = milk;
        } else if (water < 0) {
            out.print("\ttNot enough MILK");
        } else {
            out.print("\tOh. Too much!!");
        }
    }

    public void setStatus(boolean status) {
        powerStatus = status;
        String s;
        if (status) {
            s = "On\n";
        } else {
            s = "Off\n";
        }
        addLog("Power " + s);
    }

    public void addWater(String ingredient) {
        setWater(getWater() + requestConsole("\nHow much " + ingredient + " should I add?\n"));
        addLog("Add water\n");
    }

    public void addCoffee(String ingredient) {
        setCoffee(getCoffee() + requestConsole("\nHow much " + ingredient + " should I add?\n"));
        addLog("Add coffee\n");
    }

    public void addMilk(String ingredient) {
        setMilk(getMilk() + requestConsole("\nHow much " + ingredient + " should I add?\n"));
        addLog("Add milk\n");
    }

    public boolean checkStatusWaste(int count) {
        setStatusWaste(count > getMaxPrepared());
        if (count > getMaxPrepared() && !getStatusWaste()) {
            out.print("Ohh. So much!\n");
        } else if (getStatusWaste()) {
            out.print("Clean me! Urgently! \n");
        }
        return getStatusWaste();
    }

    public boolean checkCanCleaned() {
        if (getCountPrepared() >= 2 && getStatus()) {
            out.print("I can be cleaned. \n");
        }
        return getCountPrepared() >= 2;
    }

    public void clearMachine() {
        String s = "Cleaning completed. \n";
        if (checkCanCleaned()) {
            out.print(s);
            setStatusWaste(false);
            setCountPrepared(0);
        } else if (getCountPrepared() == 0) {
            s = "No cleaning needed. \n";
            out.print(s);
        }
        addLog(s);
    }

    private static void addLog(String s) {
        List<String> log = getLog();
        log.add(s);
        setLog(log);
    }

    public void printHealthMachine() {
        printProgress("Count", "brews", getCountPrepared(), getMaxPrepared());
        printProgress("Level", "WATER", getWater(), getMaxLevel());
        printProgress("Level", "COFFEE", getCoffee(), getMaxLevel());
        printProgress("Level", "MILK", getMilk(), getMaxLevel());
    }

    private void printProgress(String s, String input, int currentLevel, int maxLevel) {
        out.printf(s + " \t" + input + " \t- \t%d (max %d units)\t: \t[", currentLevel, maxLevel);
        for (int i = 0; i < maxLevel; i++) {
            if (i < currentLevel) {
                out.print("*");
            } else {
                out.print("_");
            }
        }
        out.print("]\n");
    }

    public boolean checkStatusMachine() {
        if (!powerStatus) {
            out.print("Error. You need to turn on the coffee machine\n");
        }
        return powerStatus;
    }

    public int requestConsole(String s) {
        int count;
        String input = "";
        do {
            out.print(s);
            try {
                input = reader.readLine();
                count = Integer.parseInt(input);
                if (count > 0) {
                    break;
                }
            } catch (NumberFormatException | IOException e) {
                switch (input) {
                    case "Cappuccino" -> printRecipe(CAPPUCCINO);
                    case "Americano" -> printRecipe(AMERICANO);
                    case "Espresso" -> printRecipe(ESPRESSO);
                    default -> out.print("Invalid input\n");
                }
            }
        } while (true);
        return count;
    }

    public int countRequest() {
        return requestConsole("\nEnter required number of units: ");
    }

    private boolean checkIngredients(int water, int coffee, int milk) {
        boolean enoughWater = true;
        boolean enoughCoffee = true;
        boolean enoughMilk = true;
        if (water < 0) {
            enoughWater = false;
            out.print("\tNot enough WATER\n");
        }
        if (coffee < 0) {
            enoughCoffee = false;
            out.print("\tNot enough COFFEE\n");
        }
        if (milk < 0) {
            enoughMilk = false;
            out.print("\ttNot enough MILK\n");
        }
        if (enoughCoffee && enoughMilk && enoughWater) {
            setWater(water);
            setCoffee(coffee);
            setMilk(milk);
        }
        return enoughCoffee && enoughMilk && enoughWater;
    }

    public void prepareCoffee(Recipes recipes, int count) {
        if (checkStatusMachine() && !checkStatusWaste(getCountPrepared() + count)) {
            var water = getWater() - recipes.countWater * count;
            var milk = getMilk() - recipes.countMilk * count;
            var coffee = getCoffee() - recipes.countCoffee * count;
            String s = "Prepare " + count + " portion(s)\n";
            if (checkIngredients(water, milk, coffee)) {
                switch (recipes) {
                    case ESPRESSO -> setCountPrepareEspresso(getCountPrepareEspresso() + count);
                    case CAPPUCCINO -> setCountPrepareCappuccino(getCountPrepareCappuccino() + count);
                    case AMERICANO -> setCountPrepareAmericano(getCountPrepareAmericano() + count);
                    default -> out.println(s);
                }
                addLog(s);
                out.printf("\n\tSuccessful. Portion(s) %d servings of " + recipes + "\n", count);
                setCountPrepared(getCountPrepared() + count);
            }
        }
    }

    public void printNumberOfBrews() {
        String s = "Number of brews " + countPrepared + "\n";
        addLog(s);
        if (checkStatusMachine()) {
            out.print(s);
            checkCanCleaned();
        }
    }

    public void showLogPrepare() {
        List<String> list = getLog();
        out.print("\n\n");
        for (String item : list) {
            out.print(item);
        }
        out.printf("Prepare: %d-cappuccino, %d-americano, %d-espresso\n",
                getCountPrepareCappuccino(), getCountPrepareAmericano(), getCountPrepareEspresso());
    }

    public void printRecipe(Recipes recipe) {
        if (getStatus()) {
            out.printf("\n" + recipe.text + "\n");
            addLog("Show recipe for " + recipe.toString().toLowerCase() + "\n");
        } else {
            out.print("Error. You need to turn on the coffee machine\n");
        }
    }

    public void showMenu() {
        out.print("\n");
        out.format("+-------------+----------------------+------------------+-----------------------------------------------------------------+-----------------+%n");
        out.format("| System:     | Service:             | Add ingredients: | Prepare:                                                        | Show recipe:    |%n");
        out.format("+-------------+----------------------+------------------+-----------------------------------------------------------------+-----------------+%n");
        String leftAlignFormat = "| %-11s | %-20s | %-16s | %-63s | %-15s |%n";
        out.format(leftAlignFormat, "0) " + exit.text, "2) " + numberOfBrews.text, "4) " + addWater.text, "7) " + prepareCappuccino.text + " | 10) 3 Cappuccino  | 13) Any quantity Cappuccino", "16) " + showCappuccino.text);
        out.format(leftAlignFormat, "1) " + powerOn.text, "3) " + clearMachine.text, "5) " + addCoffee.text, "8) " + prepareAmericano.text + "  | 11) 3 Americano   | 14) Any quantity Americano", "17) " + showAmericano.text);
        out.format(leftAlignFormat, "", "", "6) " + addMilk.text, "9) " + prepareEspresso.text + "   | 12) 3 Espresso    | 15) Any quantity Espresso", "18) " + showEspresso.text);
        out.format("+-------------+----------------------+------------------+-----------------------------------------------------------------+-----------------+%n");
        out.print("19) " + showLog.text + "\n");
        out.print("20) " + createProfile.text + "\n");
        if (getProfiles().size() > 0) {
            int i = getMenuLength();
            out.print("Sorts profiles:" + "\n");
            for (Profiles item : getProfiles()) {
                out.println(++i + ") " + item.getName());
            }
        }
    }

    public MenuItems choiceItem() {
        MenuItems result = null;
        MenuItems[] menu = values();
        setMenuLength(menu.length);
        int selectItem = requestConsole("\nEnter item number 0-" + (getMenuLength() - 1) + ": ");
        if (selectItem < getMenuLength()) {
            result = menu[selectItem];
        } else if (checkStatusMachine()) {
            runProfile(selectItem);
        }
        return result;
    }

    private void runProfile(int selectItem) {
        Profiles selectProfile = getProfiles().get(selectItem - getMenuLength());
        if (!getStatusWaste()) {
            prepareCoffee(CAPPUCCINO, selectProfile.getCountCappuccino());
            prepareCoffee(AMERICANO, selectProfile.getCountAmericano());
            prepareCoffee(ESPRESSO, selectProfile.getCountEspresso());
        }
    }

    public void createProfiles() {
        if (checkStatusMachine()) {
            Profiles profile = new Profiles();
            String input = null;
            do {
                out.println("Enter Name to short profile:");
                try {
                    input = reader.readLine();
                } catch (IOException e) {
                    out.println("Oops, something wrong!");
                }
            } while (input == null || input.isEmpty());
            profile.setName(input);
            int countCappuccino = requestConsole("How much " + "Cappuccino" + " should I add to profile?\n");
            profile.setCountCappuccino(countCappuccino);
            int countAmericano = requestConsole("How much " + "Americano" + " should I add to profile?\n");
            profile.setCountAmericano(countAmericano);
            int countEspresso = requestConsole("How much " + "Espresso" + " should I add to profile?\n");
            profile.setCountEspresso(countEspresso);
            int countWater = (AMERICANO.countWater * countAmericano) +
                    (ESPRESSO.countWater * countAmericano) + (CAPPUCCINO.countWater * countAmericano);
            int countMilk = AMERICANO.countMilk * countAmericano +
                    ESPRESSO.countMilk * countAmericano + CAPPUCCINO.countMilk * countAmericano;
            int countCoffee = AMERICANO.countCoffee * countAmericano +
                    ESPRESSO.countCoffee * countAmericano + CAPPUCCINO.countCoffee * countAmericano;
            int count = countWater + countMilk + countCoffee;
            if (checkIngredients(getMaxLevel() - countWater, getMaxLevel() - countMilk,
                    getMaxLevel() - countCoffee) && getMaxPrepared() < count) {
                List<Profiles> currentProfiles = getProfiles();
                currentProfiles.add(profile);
                setProfiles(currentProfiles);
            } else {
                out.print("Failed to create recipe. There won't be enough ingredients anyway or count to much.\n");
            }
        }
    }

    public static List<String> getLog() {
        return log;
    }
}

