package io.codeforall.forsome.level;
import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.NoskEnemy;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {


    public static Level createLevel() {
        // Instanciando objetos Picture

        Picture backGround = new Picture(0,0,"src/io/codeforall/forsome/level/IGREJA.jpeg");
        Picture backGroundDaSetimaSemana = new Picture(0,0,"src/io/codeforall/forsome/level/IGREJA.jpeg");
        Picture ground = new Picture(0,0,"src/io/codeforall/forsome/level/png-transparent-gray-floor-floor-gray-floor-ground2.png");
        Picture portal = new Picture(1200,250,"src/io/codeforall/forsome/level/Images/azul_portal-removebg-preview(1).png");
        // Instanciando objetos Enemy

        Enemy enemy1 = new NoskEnemy();
        Enemy enemy2 = new NormalEnemy();

        // Crinando um array d inimigos

        Enemy[] enemies = {enemy1, enemy2};


        Level setimeSemana = new Level(backGround, ground, portal, enemies);
        Level ceu = new Level(backGround, ground, portal, enemies);
        Level quartelMilitar = new Level(backGround, ground, portal, enemies);
        Level level1= new Level(backGround, ground, portal, enemies);
        Level level = new Level(backGround, ground, portal, enemies);
        return level;

    }

}
