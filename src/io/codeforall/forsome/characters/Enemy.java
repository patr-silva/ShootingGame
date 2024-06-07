package io.codeforall.forsome.characters;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;
import io.codeforall.forsome.Game;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy implements Collideable {

    private Grid grid;
    private Picture image;

    protected int health;
    private boolean isArmoured;
    private boolean isDead;
    private int speed;

    private int scoreDeduction;
    private int scoreIncremented;


    public Enemy(int health, int speed, Grid grid, int scoreDeduction, int scoreIncremented, String imgSource) {
        this.health = health;
        this.speed = speed;
        this.grid = grid;
        this.isDead = false;
        this.image = new Picture();
        this.image.load(imgSource);
        this.image.translate(this.getSpawnXPosition(), this.getSpawnYPosition());
        this.scoreDeduction = scoreDeduction;
        this.scoreIncremented = scoreIncremented;
    }

    public Enemy(int health, Grid grid) {
        this.health = health;
        this.grid = grid;
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

        if (this.health <= 0) {
            Game.score += scoreIncremented;
            this.kill();
            System.out.println(isDead);
            System.out.println("Ai que dor");
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

    public int getScoreDeduction(){
        return this.scoreDeduction;
    }

    public int getScoreIncremented(){
        return this.scoreIncremented;
    }

    @Override
    public Picture getPicture() {
        return this.image;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    public void kill(){
        this.isDead = true;
        this.image.delete();
    }

    @Override
    public void move() {
        this.image.translate(-this.speed, 0);
    }


}
