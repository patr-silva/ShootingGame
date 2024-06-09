package io.codeforall.forsome.weapons;

public class WeaponFactory {

    public static Weapon createWeapon(int playerPosX, int playerPosY) {

        switch((int) Math.floor(Math.random() * 3)) {
            case 0:
                return new Shotgun(playerPosX, playerPosY);
            case 1:
                return new MachineGun(playerPosX, playerPosY);
            case 2:
                return new Grenade(playerPosX, playerPosY);
            default:
                return new Grenade(playerPosX, playerPosY);

        }
    }
}
