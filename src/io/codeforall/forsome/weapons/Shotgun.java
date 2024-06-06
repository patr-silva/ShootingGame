package io.codeforall.forsome.weapons;

import io.codeforall.forsome.CollideableManager;

public class Shotgun extends Weapon {
    public Shotgun() {
        super(50, 1,"src/io/codeforall/forsome/weapons/images/Shotgun.png");
    }

    @Override
    public void shoot() {
        System.out.println("Shotgun damage: " + getDamage() + "shot delay: " + getShotDelay());
        Bullet bullet = new Bullet(getDamage(), getSpeed(), getBulletImagePath());
        CollideableManager.addCollideable()
    }
}
