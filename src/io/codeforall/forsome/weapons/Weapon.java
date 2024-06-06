package io.codeforall.forsome.weapons;

public abstract class Weapon {

    private double shotDelay;
    private int damage;
    private int speed;
    private String bulletImagePath;

    public Weapon(int damage, double shotDelay, String bulletImagePath, int speed) {
        this.shotDelay = shotDelay;
        this.damage = damage;
        this.speed = speed;
        this.bulletImagePath = bulletImagePath;
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


    public abstract void shoot();

}

