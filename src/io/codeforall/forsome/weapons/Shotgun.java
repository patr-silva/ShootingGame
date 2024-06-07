package io.codeforall.forsome.weapons;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;

public class Shotgun extends Weapon {
    public Shotgun(int playerPosX, int playerPosY) {
        super(50, 1,"src/io/codeforall/forsome/weapons/images/Shotgun blast__cropped_resized.png", 10, "src/io/codeforall/forsome/weapons/images/Shotgun_resized_cropped.png", playerPosX, playerPosY);
    }

    @Override
    public void shoot() {

        Collideable bullet1 = new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY() + 50);
        bullet1.show();

        Collideable bullet2 = new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY());
        bullet2.show();

        Collideable bullet3 = new Bullet(getSpeed(),getDamage(),getBulletImagePath(),getWeaponImage().getMaxX(),getWeaponImage().getMaxY() - 50);
        bullet3.show();

        CollideableManager.addCollideable(bullet1);
        CollideableManager.addCollideable(bullet2);
        CollideableManager.addCollideable(bullet3);
    }
}