package io.codeforall.forsome.weapons;

import io.codeforall.forsome.CollideableManager;

public class Grenade extends Weapon{
    public Grenade(int playerPosX, int playerPosY) {
        super(100, 1, "src/io/codeforall/forsome/weapons/images/Grenade_resized_cropped.png",10,"src/io/codeforall/forsome/weapons/images/Grenade_resized_cropped.png", playerPosX, playerPosY);
    }
    @Override
    public void shoot() {
        CollideableManager.addCollideable(new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY()));
    }
}