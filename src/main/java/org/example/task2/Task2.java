package org.example.task2;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.example.task2.MenuItems.powerOn;
import static org.example.task2.MenuItems.prepareAnyAmericano;
import static org.example.task2.MenuItems.prepareAnyCappuccino;
import static org.example.task2.MenuItems.prepareAnyEspresso;
import static org.example.task2.Recipes.AMERICANO;
import static org.example.task2.Recipes.CAPPUCCINO;
import static org.example.task2.Recipes.ESPRESSO;

public class Task2 {
    @SuppressWarnings("checkstyle:CyclomaticComplexity")
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        var count = 1;
        var countThree = 3;
        MenuItems event;
        while (true) {
            coffeeMachine.getStatus();
            coffeeMachine.printHealthMachine();
            coffeeMachine.showMenu();
            event = coffeeMachine.choiceItem();
            if (event == prepareAnyCappuccino || event == prepareAnyEspresso || event == prepareAnyAmericano) {
                count = coffeeMachine.countRequest();
            }
            if (event == null) {
                continue;
            }
            switch (event) {
                case exit -> exit(0);
                case numberOfBrews -> coffeeMachine.printNumberOfBrews();
                case clearMachine -> coffeeMachine.clearMachine();
                case addWater -> coffeeMachine.addWater("water");
                case addCoffee -> coffeeMachine.addCoffee("coffee");
                case addMilk -> coffeeMachine.addMilk("milk");
                case prepareCappuccino, prepareAnyCappuccino -> coffeeMachine.prepareCoffee(CAPPUCCINO, count);
                case prepareAmericano, prepareAnyAmericano -> coffeeMachine.prepareCoffee(AMERICANO, count);
                case prepareEspresso, prepareAnyEspresso -> coffeeMachine.prepareCoffee(ESPRESSO, count);
                case threePrepareCappuccino -> coffeeMachine.prepareCoffee(CAPPUCCINO, countThree);
                case threePrepareAmericano -> coffeeMachine.prepareCoffee(AMERICANO, countThree);
                case threePrepareEspresso -> coffeeMachine.prepareCoffee(ESPRESSO, countThree);
                case showCappuccino -> coffeeMachine.printRecipe(CAPPUCCINO);
                case showAmericano -> coffeeMachine.printRecipe(AMERICANO);
                case showEspresso -> coffeeMachine.printRecipe(ESPRESSO);
                case showLog -> coffeeMachine.showLogPrepare();
                case powerOn -> coffeeMachine.setStatus(!coffeeMachine.getStatus());
                case createProfile -> coffeeMachine.createProfiles();
                default -> out.println("Oops, something wrong!");
            }
        }
    }
}
