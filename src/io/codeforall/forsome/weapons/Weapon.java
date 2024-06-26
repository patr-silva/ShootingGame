package io.codeforall.forsome.weapons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Weapon {

    private double shotDelay;
    private int damage;
    private int speed;
    private String bulletImagePath;
    private Picture weaponImage;
    private int timer;
    private int timeInterval;

    public Weapon(int damage, double shotDelay, String bulletImagePath, int speed,String weaponImgSrc, int playerPosX, int playerPosY, int timerInterval) {
        this.shotDelay = shotDelay;
        this.damage = damage;
        this.speed = speed;
        this.bulletImagePath = bulletImagePath;
        this.weaponImage = new Picture(playerPosX + 50,playerPosY + 50, weaponImgSrc);
        this.timeInterval = timerInterval;
        this.timer = timerInterval;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public String getBulletImagePath() {
        return bulletImagePath;
    }

    public double getShotDelay() {
        return shotDelay;
    }

    public Picture getWeaponImage() {
        return this.weaponImage;
    }

    public void show() {
        this.weaponImage.draw();
    }

    public int getTimer() {
        return this.timer;
    }

    public void resetTimer() {
        timer = timeInterval;
    }

    public void reload() {
        timer--;
    }

    public abstract void shoot();

}
