package io.codeforall.forsome;

public interface Collideable {
    boolean hasCollided = false;

    void setCollided();

    boolean getCollided();


    void move();
}
