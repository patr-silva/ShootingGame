package io.codeforall.forsome.weapons;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;

public class Grenade extends Weapon{
    public Grenade(int playerPosX, int playerPosY) {
        super(100, 1, "src/io/codeforall/forsome/weapons/images/Holy Grenade_resized.png",10,"src/io/codeforall/forsome/weapons/images/Bazuca_resized.png", playerPosX, playerPosY);
    }
    @Override
    public void shoot() {
        Collideable bullet = new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY());
        bullet.show();
        CollideableManager.addCollideable(bullet);
    }
}