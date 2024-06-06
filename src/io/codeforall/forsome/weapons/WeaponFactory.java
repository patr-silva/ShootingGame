package io.codeforall.forsome.weapons;

public class WeaponFactory {

    public static Weapon createWeapon(int playerPosX, int playerPosY) {
        Shotgun shotgun = new Shotgun(playerPosX, playerPosY);
        MachineGun machineGun = new MachineGun(playerPosX, playerPosY);
        Grenade grenade = new Grenade(playerPosX, playerPosY);

        switch((int) Math.floor(Math.random() * 3)) {
            case 0:
                return shotgun;
            case 1:
                return machineGun;
            case 2:
                return grenade;
            default:
                return shotgun;
        }
    }
}
