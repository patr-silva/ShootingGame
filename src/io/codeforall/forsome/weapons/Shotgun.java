package io.codeforall.forsome.weapons;

public class Shotgun extends Weapon {
    public Shotgun() {
        super(50, 1);
    }

    @Override
    public void shoot() {
        System.out.println("Shotgun damage: " + getDamage() + "shot delay: " + getShotDelay());
    }
}
