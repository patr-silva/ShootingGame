package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NoskEnemy extends Enemy {

    public NoskEnemy(int health,  Grid grid, int scoreDeduction, int scoreIncremented, int speed) {
        super(health, speed, grid, scoreDeduction, scoreIncremented, "src/io/codeforall/forsome/characters/images/Nozk.png");
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
