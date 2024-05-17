package org.example.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class CoffeeMachine {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private boolean powerStatus;

    private final int maxLevel;

    private boolean statusWaste;

    private final int maxPrepared;

    private int milk;

    private int coffee;

    private int water;

    private int countPrepared;

    CoffeeMachine() {
        powerStatus = false;
        maxLevel = 100;
        water = 52;
        coffee = 63;
        milk = 49;
        statusWaste = false;
        maxPrepared = 10;
        countPrepared = 0;
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

    public void addWater(String s) {
        setWater(getWater() + requestConsole("\nHow much " + s + " should I add?\n"));
    }

    public void addCoffee(String s) {
        setCoffee(getCoffee() + requestConsole("\nHow much " + s + " should I add?\n"));
    }

    public void addMilk(String s) {
        setMilk(getMilk() + requestConsole("\nHow much " + s + " should I add?\n"));
    }

    public void setWater(int volume) {
        if (volume <= maxLevel && volume > 0) {
            this.water = volume;
        } else if (volume < 0) {
            out.print("""

                    \t\t\tNot enough WATER

                    """);
        } else {
            out.print("""

                    \t\t\tOh. Too much!!

                    """);
        }
    }

    public void setCoffee(int volume) {
        if (volume <= maxLevel && volume > 0) {
            this.coffee = volume;
        } else if (volume < 0) {
            out.print("""

                    \t\t\tNot enough COFFEE

                    """);
        } else {
            out.print("""

                    \t\t\tOh. Too much!!

                    """);
        }
    }

    public void setMilk(int volume) {
        if (volume <= maxLevel && volume > 0) {
            this.milk = volume;
        } else if (volume < 0) {
            out.print("""

                    \t\t\tNot enough MILK

                    """);
        } else {
            out.print("""

                    \t\t\tOh. Too much!!

                    """);
        }
    }

    public boolean getStatus() {
        return powerStatus;
    }

    public void setStatus(boolean powerStatus) {
        this.powerStatus = powerStatus;
    }

    public void printStatusIngredients() {
        printProgress("WATER");
        printProgress("COFFEE");
        printProgress("MILK");
    }

    private void printProgress(String input) {
        var level = switch (input) {
            case "MILK" -> getMilk();
            case "COFFEE" -> getCoffee();
            case "WATER" -> getWater();
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
        out.printf("Level " + input + " - \t%d (max 100 units)\t: \t[", level);
        for (int i = 0; i < maxLevel; i++) {
            if (i < level) {
                out.print("*");
            } else {
                out.print("_");
            }
        }
        out.print("]\n");
    }

    public void printRecipe(Recipes item) {
        out.printf("\n" + item.text + "\n");
    }

    public int requestConsole(String s) {
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

    public int countRequest() {
        return requestConsole("\nEnter required number of units: ");
    }

    public void prepareCoffee(Recipes preparations, int count) {
        var water = getWater() - preparations.countWater * count;
        var milk = getMilk() - preparations.countMilk * count;
        var coffee = getCoffee() - preparations.countCoffee * count;
        setWater(water);
        setCoffee(coffee);
        setMilk(milk);
        if (water > 0 && milk > 0 && coffee > 0) {
            out.printf("\n\n\t\t\tSuccessful. Portion(s) %d servings of " + preparations + "\n\n", count);
            countPrepared += count;
        }
    }

    public void printNumberOfBrews() {
        out.print("\n\n\t\t\tNumber of brews " + countPrepared + "\n\n");
    }
}
