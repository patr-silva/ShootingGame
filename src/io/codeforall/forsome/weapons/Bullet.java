package io.codeforall.forsome.weapons;

import io.codeforall.forsome.Collideable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet implements Collideable {
    private int speed;
    private int damage;
    private Picture bulletImage;
    private boolean isDead;

    public Bullet(int speed, int damage, String bulletSrc, int weaponPosX, int weaponPosY) {
        this.speed = speed;
        this.damage = damage;
        this.isDead = false;
        this.bulletImage = new Picture(weaponPosX,weaponPosY - 50, bulletSrc);
    }

    @Override
    public void move(){
        this.bulletImage.translate(this.speed,0);
    }

    @Override
    public Picture getPicture() {
        return this.bulletImage;
    }

    @Override
    public void kill() {
        bulletImage.delete();
        this.isDead = true;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void show() {
        bulletImage.draw();
    }

    public int getDamage() {
        return this.damage;
    }
}