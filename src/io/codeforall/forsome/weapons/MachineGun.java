package io.codeforall.forsome.weapons;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;

public class MachineGun extends Weapon{
    public MachineGun(int playerPosX, int playerPosY) {
        super(40, 0.2,"Banana_resized.png",14, "Banana_resized.png", playerPosX, playerPosY, 5);
    }

    @Override
    public void shoot() {
        if(getTimer() <= 0) {
            Collideable bullet = new Bullet(getSpeed(),getDamage(),getBulletImagePath(), getWeaponImage().getMaxX(), getWeaponImage().getMaxY());
            bullet.show();
            CollideableManager.addCollideable(bullet);

            resetTimer();
        }
    }
}