package org.example.task2;

public enum MenuItems {
    exit("Exit"),
    powerOn("On/Off"),
    numberOfBrews("Number of brews"),
    clearMachine("Clear machine"),
    addWater("Water"),
    addCoffee("Coffee"),
    addMilk("Milk"),
    prepareCappuccino("Cappuccino"),
    prepareAmericano("Americano"),
    prepareEspresso("Espresso"),
    threePrepareCappuccino("3 Cappuccino"),
    threePrepareAmericano("3 Americano"),
    threePrepareEspresso("3 Espresso"),
    prepareAnyCappuccino("Any quantity Cappuccino"),
    prepareAnyAmericano("Any quantity Americano"),
    prepareAnyEspresso("Any quantity Espresso"),
    showCappuccino("Cappuccino"),
    showAmericano("Americano"),
    showEspresso("Espresso"),
    showLog("Show log"),
    createProfile("Create profile");
    public final String text;

    MenuItems(String text) {
        this.text = text;
    }
}
