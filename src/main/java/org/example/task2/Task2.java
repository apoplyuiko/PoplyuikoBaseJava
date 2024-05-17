package org.example.task2;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.example.task2.Menu.showMenu;
import static org.example.task2.Recipes.*;

public class Task2 {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean status = coffeeMachine.getStatus();
        while (true) {
            if (status) {
                coffeeMachine.printStatusIngredients();
            }
            switch (showMenu(status)) {
                case exit -> exit(0);
                case powerOn -> {
                    status = !status;
                    coffeeMachine.setStatus(status);
                }
                case numberOfBrews -> coffeeMachine.printNumberOfBrews();
                case addWater -> coffeeMachine.addWater("water");
                case addCoffee -> coffeeMachine.addCoffee("coffee");
                case addMilk -> coffeeMachine.addMilk("milk");
                case prepareCappuccino -> {
                    var count = 1;
                    coffeeMachine.prepareCoffee(CAPPUCCINO, count);
                }
                case prepareAmericano -> {
                    var count = 1;
                    coffeeMachine.prepareCoffee(AMERICANO, count);
                }
                case prepareEspresso -> {
                    var count = 1;
                    coffeeMachine.prepareCoffee(ESPRESSO, count);
                }
                case threePrepareCappuccino -> {
                    var count = 3;
                    coffeeMachine.prepareCoffee(CAPPUCCINO, count);
                }
                case threePrepareAmericano -> {
                    var count = 3;
                    coffeeMachine.prepareCoffee(AMERICANO, count);
                }
                case prepareAnyEspresso -> {
                    var count = 3;
                    coffeeMachine.prepareCoffee(ESPRESSO, count);
                }
                case prepareAnyCappuccino -> {
                    var count = coffeeMachine.countRequest();
                    coffeeMachine.prepareCoffee(CAPPUCCINO, count);
                }
                case prepareAnyAmericano -> {
                    var count = coffeeMachine.countRequest();
                    coffeeMachine.prepareCoffee(AMERICANO, count);
                }
                case threePrepareEspresso -> {
                    var count = coffeeMachine.countRequest();
                    coffeeMachine.prepareCoffee(ESPRESSO, count);
                }
                case showCappuccino -> coffeeMachine.printRecipe(CAPPUCCINO);
                case showAmericano -> coffeeMachine.printRecipe(AMERICANO);
                case showEspresso -> coffeeMachine.printRecipe(ESPRESSO);
                default -> out.println("Oops, something wrong!");
            }
        }
    }
}
