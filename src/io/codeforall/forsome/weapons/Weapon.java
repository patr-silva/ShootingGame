package io.codeforall.forsome.weapons;

public abstract class Weapon {

    private int damage;
    private double shotDelay;

    public Weapon(int damage, double shotDelay) {
        this.damage = damage;
        this.shotDelay = shotDelay;
    }

    public int getDamage() {
        return damage;
    }


    public double getShotDelay() {
        return shotDelay;
    }


    public abstract void shoot();

}

