package org.example.task2;

import static java.lang.System.out;

public class CoffeeMachine {

    public static org.example.task2.Ingredients ingredients;

    private boolean powerStatus; //false - powerOff and true - powerOn

    private final int upperLevelLimit;

    {
        powerStatus = false; //false - powerOff and true - powerOn
        upperLevelLimit = 100;
    }

    CoffeeMachine() {
    }

    public boolean getStatus() {
        return powerStatus;
    }

    public void setStatus(boolean powerStatus) {
        this.powerStatus = powerStatus;
        if (powerStatus) {
            printStatusIngredients();
        }
    }

    public void printStatusIngredients() {
        printProgress(Ingredients.milk);
        printProgress(Ingredients.coffee);
        printProgress(Ingredients.water);
    }

    private void printProgress(Ingredients input) {
        out.printf("Level " + input + " - \t%d (max 100 units)\t: \t[", input.volume);
        for (int i = 0; i < upperLevelLimit; i++) {
            if (i < input.volume) {
                out.print("*");
            } else {
                out.print("_");
            }
        }
        out.print("]\n");
    }
}

