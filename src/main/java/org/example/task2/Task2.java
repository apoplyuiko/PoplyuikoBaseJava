package org.example.task2;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.example.task2.Menu.setVisibilityPowerOff;
import static org.example.task2.Menu.setVisibilityPowerOn;
import static org.example.task2.Menu.showMenu;

public class Task2 {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean status = false;
        while (true) {
            int selectItem = showMenu();

            switch (selectItem) {
                case 0 -> exit(0);
                case 1 -> {
                    status = !coffeeMachine.getStatus();
                    coffeeMachine.setStatus(status);
                }
                case 2 -> {
                    Ingredients.addWater(10);
                    coffeeMachine.printStatusIngredients();
                }
                case 3 -> {
                    Ingredients.addCoffee(10);
                    coffeeMachine.printStatusIngredients();
                }
                case 4 -> {
                    Ingredients.addMilk(10);
                    coffeeMachine.printStatusIngredients();
                }
                case 7 -> coffeeMachine.printStatusIngredients();
                default -> out.println("Oops, something wrong!");
            }
            if (status) {
                setVisibilityPowerOn();
            } else {
                setVisibilityPowerOff();
            }
        }
    }
}
