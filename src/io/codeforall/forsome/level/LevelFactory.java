package io.codeforall.forsome.level;
import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.NoskEnemy;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {


    public static Level createLevel(Grid grid, int enemySpeed, int spawnInterval, int scoreDeduction, int scoreIncrement, int numberOfEnemies, boolean firstTime) {

        //level 1
        Picture backGroundstarrySky = new Picture(0,0,"src/io/codeforall/forsome/level/Images/level1/level1_background.jpg");

        Picture groundstarrySky = new Picture();
        groundstarrySky.load("src/io/codeforall/forsome/level/Images/level1/level1_ground.png");
        groundstarrySky.translate(0,grid.getHeight() - groundstarrySky.getHeight());

        Picture portalsatrrySky = new Picture();
        portalsatrrySky.load("src/io/codeforall/forsome/level/Images/level1/level1_portal.png");
        portalsatrrySky.translate(grid.getWidth() - portalsatrrySky.getWidth(),grid.getHeight() - portalsatrrySky.getHeight() );


        //level 2
        Picture backGroundmilitarUniforce = new Picture(0,0,"src/io/codeforall/forsome/level/Images/level2/level2_background.jpg");

        Picture groundmilitarUniforce = new Picture();
        groundmilitarUniforce.load("src/io/codeforall/forsome/level/Images/level2/level2_ground.jpg");
        groundmilitarUniforce.translate(0,grid.getHeight() - groundmilitarUniforce.getHeight());

        Picture portalmilitarUniforce = new Picture();
        portalmilitarUniforce.load("src/io/codeforall/forsome/level/Images/level2/level2_portal.png");
        portalmilitarUniforce.translate(grid.getWidth() - portalmilitarUniforce.getWidth(),grid.getHeight() - portalmilitarUniforce.getHeight());

        // seventh week
        Picture backGroundseventhweek = new Picture(0,0,"src/io/codeforall/forsome/level/Images/level3/level3_background.jpg");

        Picture groundseventhWeek = new Picture();
        groundseventhWeek.load("src/io/codeforall/forsome/level/Images/level3/level3_ground.jpg");
        groundseventhWeek.translate(0,grid.getHeight() - groundseventhWeek.getHeight());

        Picture portalseventhWeek = new Picture();
        portalseventhWeek.load("src/io/codeforall/forsome/level/Images/level3/level3_portal.png");
        portalseventhWeek.translate(grid.getWidth() - portalseventhWeek.getWidth(),grid.getHeight() - portalseventhWeek.getHeight());

        // forsome
        Picture backGroundforSome= new Picture(0,0,"src/io/codeforall/forsome/level/Images/level4/level4_background.jpeg");

        Picture groundforSome = new Picture();
        groundforSome.load("src/io/codeforall/forsome/level/Images/level4/level4_ground.jpeg");
        groundforSome.translate(0,grid.getHeight() - groundforSome.getHeight());

        Picture portalforSome = new Picture();
        portalforSome.load("src/io/codeforall/forsome/level/Images/level4/level4_portal.jpeg");
        portalforSome.translate(grid.getWidth() - portalforSome.getWidth(),grid.getHeight() - portalforSome.getHeight());

        //betano

        Picture backGroundBetano = new Picture(0,0,"src/io/codeforall/forsome/level/Images/level5/level5_background.jpg");

        Picture groundBetano = new Picture();
        groundBetano.load("src/io/codeforall/forsome/level/Images/level5/level5_ground.png");
        groundBetano.translate(0,grid.getHeight() - groundBetano.getHeight());

        Picture portalBetano = new Picture();
        portalBetano.load("src/io/codeforall/forsome/level/Images/level5/level5_portal.png");
        portalBetano.translate(grid.getWidth() - portalBetano.getWidth(), grid.getHeight() - portalBetano.getHeight());

        Level starrySky;
        Level militarUnitforce;
        Level seventhWeek;
        Level forSome;
        Level houseBetano;

        if(!firstTime) {
            starrySky = new Level(grid, backGroundstarrySky, groundstarrySky, portalsatrrySky, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
            militarUnitforce = new Level(grid, backGroundmilitarUniforce, groundmilitarUniforce, portalmilitarUniforce, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
            seventhWeek = new Level(grid, backGroundseventhweek, groundseventhWeek, portalseventhWeek, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
            forSome= new Level(grid, backGroundforSome, groundforSome, portalforSome, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
            houseBetano = new Level(grid, backGroundBetano, groundBetano, portalBetano, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
        } else {
            starrySky = new Level(grid, backGroundstarrySky, groundstarrySky, portalsatrrySky);
            militarUnitforce = new Level(grid, backGroundmilitarUniforce, groundmilitarUniforce, portalmilitarUniforce);
            seventhWeek = new Level(grid, backGroundseventhweek, groundseventhWeek, portalseventhWeek);
            forSome = new Level(grid, backGroundforSome, groundforSome, portalforSome);
            houseBetano = new Level(grid, backGroundBetano, groundBetano, portalBetano);
        }

        switch((int) Math.floor(Math.random() * 5)) {
            case 0:
                return starrySky;
            case 1:
                return militarUnitforce;
            case 2:
                return seventhWeek;
            case 3:
                return forSome;
            case 4:
                return houseBetano;
        }

        return seventhWeek;

    }


}
