package org.example.task2;

public enum MenuItems {
    EXIT("Exit"),
    POWER_ON("On/Off"),
    NUMBER_OF_BREWS("Number of brews"),
    CLEAR_MACHINE("Clear machine"),
    ADD_WATER("Water"),
    ADD_COFFEE("Coffee"),
    ADD_MILK("Milk"),
    PREPARE_CAPPUCCINO("Cappuccino"),
    PREPARE_AMERICANO("Americano"),
    PREPARE_ESPRESSO("Espresso"),
    THREE_PREPARE_CAPPUCCINO("3 Cappuccino"),
    THREE_PREPARE_AMERICANO("3 Americano"),
    THREE_PREPARE_ESPRESSO("3 Espresso"),
    PREPARE_ANY_CAPPUCCINO("Any quantity Cappuccino"),
    PREPARE_ANY_AMERICANO("Any quantity Americano"),
    PREPARE_ANY_ESPRESSO("Any quantity Espresso"),
    SHOW_CAPPUCCINO("Cappuccino"),
    SHOW_AMERICANO("Americano"),
    SHOW_ESPRESSO("Espresso"),
    SHOW_LOG("Show log"),
    PROFILES("Profiles");

    public final String text;

    MenuItems(String text) {
        this.text = text;
    }
}
