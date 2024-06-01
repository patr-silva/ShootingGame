package io.codeforall.forsome;

import io.codeforall.forsome.grid.Position;

public interface Collideable {
    Position position = null;
    boolean hasCollided = false;

    Position getPosition();

    void setCollided();

    boolean getCollided();


}
