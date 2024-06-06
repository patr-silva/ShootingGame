package io.codeforall.forsome.weapons;

import io.codeforall.forsome.Collideable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet implements Collideable {
    private int speed;
    private int damage;
    private Picture bulletImage;

    public Bullet(int speed, int damage, Picture bulletImage) {
        this.speed = speed;
        this.damage = damage;
        this.bulletImage = bulletImage;
    }

    @Override
    public void move(){

    }

    @Override
    public Picture getPicture() {
        return null;
    }

    @Override
    public void kill() {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void show() {
        bulletImage.draw();
    }
}
