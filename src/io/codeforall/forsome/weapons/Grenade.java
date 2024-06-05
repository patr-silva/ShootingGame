package io.codeforall.forsome.weapons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grenade extends Weapon{
    private Picture grenade;



    public Grenade() {
        super(100, 1);
    }
    @Override
    public void shoot() {
        System.out.println("Grenade damage: " + getDamage() + ", shot delay: " + getShotDelay());
    }
}
