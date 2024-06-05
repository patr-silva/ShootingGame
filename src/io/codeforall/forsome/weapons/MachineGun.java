package io.codeforall.forsome.weapons;

public class MachineGun extends Weapon{
    public MachineGun() {
        super(20, 0.2);
    }

    @Override
    public void shoot() {
        System.out.println("MachineGun damage: " + getDamage() + " shot delay: " + getShotDelay());
    }
}
