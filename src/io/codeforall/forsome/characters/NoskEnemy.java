package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Position;

public class NoskEnemy extends Enemy{
    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public void setCollided() {

    }

    @Override
    public boolean getCollided() {
        return false;
    }

    @Override
    public void kill() {

    }

    @Override
    public boolean isDead() {
        return false;
    }
}
