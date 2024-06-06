package io.codeforall.forsome.weapons;

import io.codeforall.forsome.CollideableManager;

public class Shotgun extends Weapon {
    public Shotgun(int playerPosX, int playerPosY) {
        super(50, 1,"src/io/codeforall/forsome/weapons/images/Shotgun blast__cropped_resized.png", 10, "src/io/codeforall/forsome/weapons/images/Shotgun_resized_cropped.png", playerPosX, playerPosY);
    }

    @Override
    public void shoot() {
        CollideableManager.addCollideable(new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY() + 50));
        CollideableManager.addCollideable(new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY()));
        CollideableManager.addCollideable(new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY() - 50));
    }
}