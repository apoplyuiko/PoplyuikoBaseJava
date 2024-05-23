package org.example.task2;

public class Profiles {
    private String name;

    private int countCappuccino;

    private int countAmericano;

    private int countEspresso;

    Profiles() {
    }

    public String getName() {
        return name;
    }

    public int getCountCappuccino() {
        return countCappuccino;
    }

    public int getCountAmericano() {
        return countAmericano;
    }

    public int getCountEspresso() {
        return countEspresso;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountCappuccino(int countCappuccino) {
        this.countCappuccino = countCappuccino;
    }

    public void setCountAmericano(int countAmericano) {
        this.countAmericano = countAmericano;
    }

    public void setCountEspresso(int countEspresso) {
        this.countEspresso = countEspresso;
    }
}
