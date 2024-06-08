package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NoskEnemy extends Enemy {

    public NoskEnemy(int health,  Grid grid, int scoreDeduction, int scoreIncremented, int speed, String source) {
        super(health, speed, grid, scoreDeduction + 300, scoreIncremented, source);
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
