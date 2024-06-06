package io.codeforall.forsome.level;
import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.NoskEnemy;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {


    public static Level createLevel() {
        // Instanciando objetos Picture

        /*
        //level 1
        Picture backGroundstarrySky = new Picture();
        backGroundstarrySky.load("src/io/codeforall/forsome/level/Images/Milky_Way_Stars_Sky_439498_1366x768.jpg");
        backGroundstarrySky.translate(0, 768 - backGroundstarrySky.getHeight());

        Picture groundstarrySky = new Picture();
        groundstarrySky.load("src/io/codeforall/forsome/level/Images/AdobeStock_14659835-1536x1050.jpeg.jpg");
        groundstarrySky.translate(0,768 - groundstarrySky.getHeight());

        Picture portalsatrrySky = new Picture();
        portalsatrrySky.load("src/io/codeforall/forsome/level/Images/azul_portal-removebg-preview(1).png");
        portalsatrrySky.translate(1023,477- portalsatrrySky.getHeight() );

*/
        //level 2
        Picture backGroundmilitarUniforce = new Picture();
        backGroundmilitarUniforce.load("src/io/codeforall/forsome/level/Images/AircraftCarrier_1920x1080_WG_SPb_WoWSL.jpg.5c4bfdfe50fccc4fb3007d9eb0ec59ed.jpg");
        backGroundmilitarUniforce.translate(0,768 -backGroundmilitarUniforce.getHeight());

        Picture groundmilitarUniforce = new Picture();
        groundmilitarUniforce.load("src/io/codeforall/forsome/level/Images/the-pacific-4fd5fda25592b.jpg");
        groundmilitarUniforce.translate(0,768-groundmilitarUniforce.getHeight());

        Picture portalmilitarUniforce = new Picture();
        portalmilitarUniforce.load("src/io/codeforall/forsome/level/Images/azul_portal-removebg-preview(1).png");
        portalmilitarUniforce.translate(1023,605-portalmilitarUniforce.getHeight());



        //level
        /*Picture backGroundseventhweek = new Picture();
        backGroundseventhweek.load("src/io/codeforall/forsome/level/Images/Untitled-1-1920x1080-40d871ba3129e359aaab454149e03063.jpg");
        backGroundseventhweek.translate(0,768- backGroundseventhweek.getHeight());

        Picture groundseventhWeek = new Picture();
        groundseventhWeek.load("src/io/codeforall/forsome/level/Images/lava_world_wallpaper_by_teksha_art_dg5mpiw-fullview.jpg");
        groundseventhWeek.translate(0,768- groundseventhWeek.getHeight());

        Picture portalseventhWeek = new Picture();
        portalseventhWeek.load("src/io/codeforall/forsome/level/Images/terrificante-portale-a-forma-di-bocca-in-lava-ardente-alle-porte-dell-inferno_124507-91375-removebg-preview.png");
        portalseventhWeek.translate(950,605 - portalseventhWeek.getHeight());

         */

/*



        /*

        //level 4
        Picture backGroundforSome= new Picture(0,0);
        Picture groundforSome = new Picture(0,0);
        Picture portalforSome = new Picture(0,0);

        //level 5

        Picture backGroundhouseBetano = new Picture(0,0);
        Picture groundhouseBetano = new Picture(0,0);
        Picture portalhouseBetano = new Picture(0,0);

        */

        // Instanciando objetos Enemy

        Enemy enemy1 = new NoskEnemy(10,new Grid(10,10),10,10);
        Enemy enemy2 = new NormalEnemy(10,10,new Grid(10,10), false,10,10);

        // Criando um array d inimigos

        Enemy[] enemies = {enemy1, enemy2};


        /*Level starrySky = new Level(backGroundstarrySky, groundstarrySky, portalsatrrySky, enemies);*/
        Level militarUnitforce = new Level(backGroundmilitarUniforce, groundmilitarUniforce, portalmilitarUniforce, enemies);
      /*  Level seventhWeek = new Level(backGroundseventhweek, groundseventhWeek, portalseventhWeek, enemies);
        /*Level forSome= new Level(backGroundforSome, groundforSome, portalforSome, enemies);
        Level houseBetano = new Level(backGroundhouseBetano, groundhouseBetano, portalhouseBetano, enemies);*/

        return militarUnitforce;

    }


}
