package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NormalEnemy extends Enemy {

    public NormalEnemy(int health, int speed, Grid grid, int scoreDeduction, int scoreIncremented) {
        super(health, speed, grid, scoreDeduction, scoreIncremented, "src/io/codeforall/forsome/characters/images/floppagun-removebg.png");
    }

    @Override
    public void kill() {
        super.kill();
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }
}
