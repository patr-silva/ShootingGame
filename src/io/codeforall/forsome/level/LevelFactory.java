package io.codeforall.forsome.level;
import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.NoskEnemy;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {


    public static Level createLevel(Grid grid, int enemySpeed, int spawnInterval, int scoreDeduction, int scoreIncrement, int numberOfEnemies, boolean firstTime) {

        int randomNumber = (int) Math.floor(Math.random() * 5);

        if(!firstTime) {

            switch (randomNumber) {
                case 0:
                    //level 1
                    Picture backGroundstarrySky = new Picture(0,0,"level1_background.jpg");

                    Picture groundstarrySky = new Picture();
                    groundstarrySky.load("level1_ground.png");
                    groundstarrySky.translate(0,grid.getHeight() - groundstarrySky.getHeight());

                    Picture portalsatrrySky = new Picture();
                    portalsatrrySky.load("level1_portal.png");
                    portalsatrrySky.translate(grid.getWidth() - portalsatrrySky.getWidth(),grid.getHeight() - portalsatrrySky.getHeight() );

                    return new Level(grid, backGroundstarrySky, groundstarrySky, portalsatrrySky, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);

                case 1:
                    //level 2
                    Picture backGroundmilitarUniforce = new Picture(0,0,"level2_background.jpg");

                    Picture groundmilitarUniforce = new Picture();
                    groundmilitarUniforce.load("level2_ground.jpg");
                    groundmilitarUniforce.translate(0,grid.getHeight() - groundmilitarUniforce.getHeight());

                    Picture portalmilitarUniforce = new Picture();
                    portalmilitarUniforce.load("level2_portal.png");
                    portalmilitarUniforce.translate(grid.getWidth() - portalmilitarUniforce.getWidth(),grid.getHeight() - portalmilitarUniforce.getHeight());


                    return new Level(grid, backGroundmilitarUniforce, groundmilitarUniforce, portalmilitarUniforce, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
                case 2:
                    // seventh week
                    Picture backGroundseventhweek = new Picture(0,0,"level3_background.jpg");

                    Picture groundseventhWeek = new Picture();
                    groundseventhWeek.load("level3_ground.jpg");
                    groundseventhWeek.translate(0,grid.getHeight() - groundseventhWeek.getHeight());

                    Picture portalseventhWeek = new Picture();
                    portalseventhWeek.load("level3_portal.png");
                    portalseventhWeek.translate(grid.getWidth() - portalseventhWeek.getWidth(),grid.getHeight() - portalseventhWeek.getHeight());

                    return new Level(grid, backGroundseventhweek, groundseventhWeek, portalseventhWeek, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
                case 3:
                    Picture backGroundforSome= new Picture(0,0,"level4_background.jpeg");

                    Picture groundforSome = new Picture();
                    groundforSome.load("level4_ground.jpeg");
                    groundforSome.translate(0,grid.getHeight() - groundforSome.getHeight());

                    Picture portalforSome = new Picture();
                    portalforSome.load("level4_portal.jpeg");
                    portalforSome.translate(grid.getWidth() - portalforSome.getWidth(),grid.getHeight() - portalforSome.getHeight());

                    return new Level(grid, backGroundforSome, groundforSome, portalforSome, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
                case 4:
                    Picture backGroundBetano = new Picture(0,0,"level5_background.jpg");

                    Picture groundBetano = new Picture();
                    groundBetano.load("level5_ground.png");
                    groundBetano.translate(0,grid.getHeight() - groundBetano.getHeight());

                    Picture portalBetano = new Picture();
                    portalBetano.load("level5_portal.png");
                    portalBetano.translate(grid.getWidth() - portalBetano.getWidth(), grid.getHeight() - portalBetano.getHeight());

                    return new Level(grid, backGroundBetano, groundBetano, portalBetano, numberOfEnemies, enemySpeed, spawnInterval, scoreDeduction, scoreIncrement);
            }


        } else {
            switch (randomNumber) {
                case 0:
                    //level 1
                    Picture backGroundstarrySky = new Picture(0,0,"level1_background.jpg");

                    Picture groundstarrySky = new Picture();
                    groundstarrySky.load("level1_ground.png");
                    groundstarrySky.translate(0,grid.getHeight() - groundstarrySky.getHeight());

                    Picture portalsatrrySky = new Picture();
                    portalsatrrySky.load("level1_portal.png");
                    portalsatrrySky.translate(grid.getWidth() - portalsatrrySky.getWidth(),grid.getHeight() - portalsatrrySky.getHeight() );


                    return new Level(grid, backGroundstarrySky, groundstarrySky, portalsatrrySky);
                case 1:
                    //level 2
                    Picture backGroundmilitarUniforce = new Picture(0,0,"level2_background.jpg");

                    Picture groundmilitarUniforce = new Picture();
                    groundmilitarUniforce.load("level2_ground.jpg");
                    groundmilitarUniforce.translate(0,grid.getHeight() - groundmilitarUniforce.getHeight());

                    Picture portalmilitarUniforce = new Picture();
                    portalmilitarUniforce.load("level2_portal.png");
                    portalmilitarUniforce.translate(grid.getWidth() - portalmilitarUniforce.getWidth(),grid.getHeight() - portalmilitarUniforce.getHeight());


                    return new Level(grid, backGroundmilitarUniforce, groundmilitarUniforce, portalmilitarUniforce);
                case 2:
                    // seventh week
                    Picture backGroundseventhweek = new Picture(0,0,"level3_background.jpg");

                    Picture groundseventhWeek = new Picture();
                    groundseventhWeek.load("level3_ground.jpg");
                    groundseventhWeek.translate(0,grid.getHeight() - groundseventhWeek.getHeight());

                    Picture portalseventhWeek = new Picture();
                    portalseventhWeek.load("level3_portal.png");
                    portalseventhWeek.translate(grid.getWidth() - portalseventhWeek.getWidth(),grid.getHeight() - portalseventhWeek.getHeight());


                    return new Level(grid, backGroundseventhweek, groundseventhWeek, portalseventhWeek);
                case 3:
                    Picture backGroundforSome= new Picture(0,0,"level4_background.jpeg");

                    Picture groundforSome = new Picture();
                    groundforSome.load("level4_ground.jpeg");
                    groundforSome.translate(0,grid.getHeight() - groundforSome.getHeight());

                    Picture portalforSome = new Picture();
                    portalforSome.load("level4_portal.jpeg");
                    portalforSome.translate(grid.getWidth() - portalforSome.getWidth(),grid.getHeight() - portalforSome.getHeight());


                    return new Level(grid, backGroundforSome, groundforSome, portalforSome);
                case 4:
                    Picture backGroundBetano = new Picture(0,0,"level5_background.jpg");

                    Picture groundBetano = new Picture();
                    groundBetano.load("level5_ground.png");
                    groundBetano.translate(0,grid.getHeight() - groundBetano.getHeight());

                    Picture portalBetano = new Picture();
                    portalBetano.load("level5_portal.png");
                    portalBetano.translate(grid.getWidth() - portalBetano.getWidth(), grid.getHeight() - portalBetano.getHeight());


                    return new Level(grid, backGroundBetano, groundBetano, portalBetano);
            }
        }
        return null;
    }


}
