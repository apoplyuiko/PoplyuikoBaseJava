package org.example.task2;

public enum Ingredients {
    milk(0),
    coffee(0),
    water(0);

    int volume;

    Ingredients(int volume) {
        this.volume = volume;
    }

    public static void addWater(int volume) {
        water.volume += volume;
    }

    public static void addCoffee(int volume) {
        coffee.volume += volume;
    }

    public static void addMilk(int volume) {
        milk.volume += volume;
    }
}
