package org.example.task2;

public enum MenuItems {
    exit("Exit"),
    powerOn("Power On/Off"),
    numberOfBrews("Number of brews"),
    clearMachine("Clear machine"),
    addWater("Water"),
    addCoffee("Coffee"),
    addMilk("Milk"),
    prepareCappuccino("Cappuccino"),
    prepareAmericano("Americano"),
    prepareEspresso("Espresso"),
    threePrepareCappuccino("3 Cappuccinos"),
    threePrepareAmericano("3 Americanos"),
    threePrepareEspresso("3 Espressos"),
    prepareAnyCappuccino("Any quantity Cappuccino"),
    prepareAnyAmericano("Any quantity Americano"),
    prepareAnyEspresso("Any quantity Espresso"),
    showCappuccino("Cappuccino"),
    showAmericano("Americano"),
    showEspresso("Espresso");
    public final String text;

    MenuItems(String text) {
        this.text = text;
    }
}
