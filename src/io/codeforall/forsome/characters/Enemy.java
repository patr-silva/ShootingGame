package io.codeforall.forsome.characters;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy implements Collideable {

    private Grid grid;
    private Picture image;

    protected int health;
    private boolean isArmoured;
    private boolean isDead;
    private int speed;


    public Enemy(int health, int speed, Grid grid) {
        this.health = health;
        this.speed = speed;
        this.grid = grid;
        this.image = new Picture();
        this.image.load("src/io/codeforall/forsome/characters/images/floppagun.png");
        this.image.translate(this.getSpawnXPosition(), this.getSpawnYPosition());
    }

    public int getSpawnYPosition() {
        int maxY = this.grid.getHeight() - this.image.getHeight();
        return (int) (Math.random() * (maxY));
    }

    public int getSpawnXPosition() {
        return this.grid.getWidth() - this.image.getWidth();
    }

    @Override
    public void show() {
        this.image.draw();
    }

    public void takeDamage(int hit) {
        this.health -= hit;
        System.out.println("Enemy health: " + this.health);
        if (this.health <= 0) {
            this.kill();
        }
    }

    public int checkHealth() {
        return this.health;
    }

    public void setArmoured() {
        this.isArmoured = true;
    }

    public boolean isArmoured() {
        return this.isArmoured;
    }

    @Override
    public Picture getPicture() {
        return this.image;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void move() {
        this.image.translate(-this.speed, 0);
    }


}
