package io.codeforall.forsome.weapons;

import io.codeforall.forsome.CollideableManager;

public class MachineGun extends Weapon{
    public MachineGun(int playerPosX, int playerPosY) {
        super(20, 0.2,"src/io/codeforall/forsome/weapons/images/Bullet_resized_cropped.png",10, "src/io/codeforall/forsome/weapons/images/MachineGun_resized_cropped.png", playerPosX, playerPosY);
    }

    @Override
    public void shoot() {
        CollideableManager.addCollideable(new Bullet(getSpeed(),getDamage(),getBulletImagePath(), getWeaponImage().getMaxX(), getWeaponImage().getMaxY()));
    }
}