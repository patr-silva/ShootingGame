package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NoskEnemy extends Enemy {

    private int scoreDeduction;
    private int scoreIncremented;
    private String imageSource = "";
    private int speed = 20;

    public NoskEnemy(int health,  Grid grid, int scoreDeduction, int scoreIncremented) {
        super(health, grid);
        this.scoreDeduction = 20;
        this.scoreIncremented = 20;
    }


    @Override
    public void kill() {
        System.out.println("Nosk was defeated.");
    }
}
