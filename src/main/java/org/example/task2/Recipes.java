package org.example.task2;

public enum Recipes {
    ESPRESSO("", 7, 4, 3),
    CAPPUCCINO("", 3, 6, 8),
    AMERICANO("", 5, 2, 0);

    public final String text;

    final int countWater;

    final int countCoffee;

    final int countMilk;

    Recipes(String recipe, int water, int coffee, int milk) {
        this.text = "Recipe " + this + ": " + " \tWater - " + water +
                " \tCoffee - " + coffee + " \tMilk - " + milk + "\n";
        this.countWater = water;
        this.countCoffee = coffee;
        this.countMilk = milk;
    }
}
