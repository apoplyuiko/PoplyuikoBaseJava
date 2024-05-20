package org.example.task2;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.example.task2.MenuItems.PREPARE_ANY_AMERICANO;
import static org.example.task2.MenuItems.PREPARE_ANY_CAPPUCCINO;
import static org.example.task2.MenuItems.PREPARE_ANY_ESPRESSO;
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
            if (event == PREPARE_ANY_CAPPUCCINO || event == PREPARE_ANY_ESPRESSO || event == PREPARE_ANY_AMERICANO) {
                count = coffeeMachine.countRequest();
            }
            switch (event) {
                case EXIT -> exit(0);
                case NUMBER_OF_BREWS -> coffeeMachine.printNumberOfBrews();
                case CLEAR_MACHINE -> coffeeMachine.clearMachine();
                case ADD_WATER -> coffeeMachine.addWater("water");
                case ADD_COFFEE -> coffeeMachine.addCoffee("coffee");
                case ADD_MILK -> coffeeMachine.addMilk("milk");
                case PREPARE_CAPPUCCINO, PREPARE_ANY_CAPPUCCINO -> coffeeMachine.prepareCoffee(CAPPUCCINO, count);
                case PREPARE_AMERICANO, PREPARE_ANY_AMERICANO -> coffeeMachine.prepareCoffee(AMERICANO, count);
                case PREPARE_ESPRESSO, PREPARE_ANY_ESPRESSO -> coffeeMachine.prepareCoffee(ESPRESSO, count);
                case THREE_PREPARE_CAPPUCCINO -> coffeeMachine.prepareCoffee(CAPPUCCINO, countThree);
                case THREE_PREPARE_AMERICANO -> coffeeMachine.prepareCoffee(AMERICANO, countThree);
                case THREE_PREPARE_ESPRESSO -> coffeeMachine.prepareCoffee(ESPRESSO, countThree);
                case SHOW_CAPPUCCINO -> coffeeMachine.printRecipe(CAPPUCCINO);
                case SHOW_AMERICANO -> coffeeMachine.printRecipe(AMERICANO);
                case SHOW_ESPRESSO -> coffeeMachine.printRecipe(ESPRESSO);
                case SHOW_LOG -> coffeeMachine.showLogPrepare();
                case POWER_ON -> coffeeMachine.setStatus(!coffeeMachine.getStatus());
                case PROFILES -> coffeeMachine.menuProfile();
                default -> out.println("Oops, something wrong!");
            }
        }
    }
}
